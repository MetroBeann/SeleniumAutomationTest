Feature: Login to Monkeytype

  Scenario: User logs into Monkeytype
    Given the user is on the Monkeytype homepage
    When the user clicks the profile button
    Then the login modal should appear
