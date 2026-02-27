package com.coursera.utils;

import com.coursera.annotations.Web;
import com.coursera.annotations.Webs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class WebInitializer {
    public static void init(WebDriver driver, Object pageClass) {
        String activeLocale = System.getProperty("testLocale", "en_US");

        Field[] fields = pageClass.getClass().getDeclaredFields();
        ClassLoader loader = pageClass.getClass().getClassLoader();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Web.class) || field.isAnnotationPresent(Webs.class)) {
                Web[] allWebs = field.getAnnotationsByType(Web.class);
                Web selectedWeb = (allWebs.length > 0) ? allWebs[0] : null;
                By locator;

                for (Web w : allWebs) {
                    if (w.locale().equalsIgnoreCase(activeLocale)) {
                        selectedWeb = w;
                        break;
                    }
                }
                if(selectedWeb != null) {
                    final By finalLocator = getLocator(selectedWeb);

                    ElementLocator elementLocator = new ElementLocator() {
                        @Override
                        public WebElement findElement() {
                            return driver.findElement(finalLocator);
                        }

                        @Override
                        public List<WebElement> findElements() {
                            return driver.findElements(finalLocator);
                        }
                    };

                    boolean isList = List.class.isAssignableFrom(field.getType());
                    InvocationHandler handler;
                    Object proxy;

                    if (isList) {
                        handler = new LocatingElementListHandler(elementLocator);
                        proxy = Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
                    } else {
                        // EXISTING CODE: Use the Single Element Handler
                        handler = new LocatingElementHandler(elementLocator);
                        proxy = Proxy.newProxyInstance(loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class},
                                handler);
                    }
                    try {
                        field.setAccessible(true);
                        field.set(pageClass, proxy);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static By getLocator(Web web) {
        if (!web.id().isEmpty()) return By.id(web.id());
        if (!web.css().isEmpty()) return By.cssSelector(web.css());
        if (!web.xpath().isEmpty()) return By.xpath(web.xpath());
        if (!web.name().isEmpty()) return By.name(web.name());
        return null;
    }
}
