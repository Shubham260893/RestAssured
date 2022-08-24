Feature: Add vehicle

  Scenario: Add Vehicle through VehicleAndSales API
    Given I do the new user registration through "identity" microservice
    Then Validate the response code as 200
    #And Validate "isProcessed" in the response body is "true"
    And I generate the token by passing login claims
    Then Validate the response code as 200
    When I call "AddVehicleAndSalesAPI" with POST request
    Then Validate the response code as 201
    And Validate "data" in the response body is "Success"
