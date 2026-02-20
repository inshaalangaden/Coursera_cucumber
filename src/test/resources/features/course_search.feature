Feature: Search in the input box and get the course
  Scenario Outline: Search experience for course search in the Home page
    Given User is on the Home page
    When User search a "<keyword>" in the search input
    Then Validate the title of the first course contains the "<keyword>"
    Examples:
    | keyword |
    | Selenium |
    | java     |
    | Automation |

