Feature: User Features
  @user
  Scenario: Operations about user
    Given Creates List of Users
    When Create user
    And Updated user
    And Logs user into the system
    When Logs out current
    And Creates list of users
    Then Get user by userName
    When Delete user
    Then Verify user deleted

