Feature: Validate the form
  Scenario Outline: Validate the form using Excel row <RowNo>
    Given User is on the Home page
    When User navigate to forUniversities page
    And User clicked ContactUs button
    And fill the form with excel row "<RowNo>"
    Then validate alert behavior based on the excel Test Type

    Examples:
      | RowNo |
      | 1     |
      | 2     |
      | 3     |
      | 4     |
      | 5     |
