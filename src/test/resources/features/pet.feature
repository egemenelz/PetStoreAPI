Feature: Pet Features
  @pet
  Scenario: Everything about your Pets
    Given Add a new pet to the store
    When Find pet by ID
    And Uploads an Image
    When Update an existing pet
    And Find pet by status
    When Updates a pet in the store with form data
    And Delete a pet
    Then Verify pet deleted