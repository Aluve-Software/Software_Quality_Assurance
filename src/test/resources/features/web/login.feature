@login
Feature: Login Feature

  Background:
    Given the user is on the landing page

  Scenario Outline: Validate that the user may login
    When the user logs in with the username "<username>" and password "<password>"
    Then the user is redirected to the main page

    Examples:
      | password             | username |
      | SuperSecretPassword! | tomsmith |