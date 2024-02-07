Feature: User Registration

  Scenario: Successful User Registration
    Given I am on the Mailchimp registration page
    When I enter valid user details
    And I submit the form
    Then I should be registered successfully

  Scenario: User Registration with long username
    Given I am on the Mailchimp registration page
    When I enter a username longer than 100 characters
    And I submit the form
    Then I should see a username length error

  Scenario: User Registration with existing username
    Given I am on the Mailchimp registration page
    When I enter an existing username
    And I submit the form
    Then I should see a username already exists error

  Scenario: User Registration without email
    Given I am on the Mailchimp registration page
    When I do not enter an email
    And I submit the form
    Then I should see an email is required error
