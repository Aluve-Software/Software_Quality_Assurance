@register
Feature: Add User Feature

  Scenario Outline: Validate that the user may login
    Given the email is "<email>"
    And the password is "<password>"
    When the user sends the request
    Then the response code is "<code>"
    And the id is "<id>"
    And the token is "<token>"

    Examples:
      | email              | password | code | id | token             |
      | eve.holt@reqres.in | pistol   | 200  | 4  | QpwL5tke4Pnpja7X4 |