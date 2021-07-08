Feature: Register Form

  @smokeTest
  Scenario: Register successful with faker
    Given That a web user i want to register in the form
    When fill all the requested fields in the form with faker
    Then we can see the form with our information with faker

  @Excel
  Scenario: Register successful with excel
    Given That a web user i want to register in the form
    When fill all the requested fields in the form with Excel
    Then we can see the form with our information with Excel

  @regression
  Scenario: Register successful with conf properties
    Given That a web user i want to register in the form
    When fill all the requested fields in the form with conf properties
    Then we can see the form with our information with conf properties