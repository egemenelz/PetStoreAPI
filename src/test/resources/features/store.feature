Feature: Store Features
  @store
  Scenario: Access to PetStore orders
    Given Returns pet inventories by status
    When Place an order for a pet
    And Find purchases order by ID
    When Delete purchase order by ID
    Then Verify purchase deleted
