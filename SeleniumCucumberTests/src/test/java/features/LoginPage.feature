Feature: Login to Monkeytype

  Scenario Outline: User logs into Monkeytype
    Given the user is on the Monkeytype homepage
    When the user clicks the profile button
    Then the login modal should appear
    And the user enters email "<email>"
    And the user enters password "<password>"
    Then the user clicks on log in button
    Then the user should be redirected to the landing page

  Examples:
    | email              | password |
    | placeyouremailhere@gmail.com      | passwordhere |
   