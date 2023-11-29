@TodoEnUno
Feature: PetStore Order Service

  @CreacionOrder
  Scenario Outline: Create Order in PetStore
    Given el idOrder <idOrder>, tiene un petId <petId>, una cantidad <quantity>, y una fecha de envío <shipDate>
    When el método es POST
    Then el código de estado de respuesta es <statusCode>
    And el cuerpo de la respuesta debería contener el estado de la orden placed
    And el cuerpo de la respuesta debería contener el id de la orden <idOrder>
    Examples:
      | idOrder | petId | quantity | shipDate                   | statusCode |
      | 70       | 5     | 7       | "2023-11-28T23:43:34.863Z"  | 200        |
      | 71       | 10    | 6       | "2023-12-28T23:43:34.863Z"  | 200        |
      | 72       | 2     | 1       | "2023-10-28T23:43:34.863Z"  | 200        |


  @ConsultaOrder
  Scenario Outline: Consultar Order
    Given el idOrder es <arg0>
    When el método es GET
    Then el código de estado de respuesta es 200
    And el cuerpo de la respuesta debería contener el id de la orden <arg0>
    Examples:
      | arg0 |
      | 70    |
      | 71    |
      | 72    |