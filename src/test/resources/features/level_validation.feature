Feature: Validate level of course
  Scenario: Search for a course and validate if the level is mentioned or not
    Given User is on the Home page
    When User navigate to explore page
    And Click "Python" link
    And Select the first course
    Then validate if the page contains "level" in it
