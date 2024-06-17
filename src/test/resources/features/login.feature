Feature: Google Login Form Access

  Scenario: User can access the Google login form
    Given the user is on the Google homepage
    When the user clicks on the "Sign in" button
    Then the user should be redirected to the Google login form