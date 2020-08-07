Feature: Verificar que el titular pueda cancelar su pedido a traves de trazabilidad y que se envie un mensaje confirmando
            la cancelación de la agenda. ANTES del agendamiento

  @SmokeTest
  Scenario Outline: Como Cliente Activo, me logueo al sistema
    Given Soy Cliente e ingreso al sistema "<Id_CancelarPedidoBS>"
    When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_CancelarPedidoBS>"
    And Se ingresa a la opción cancelar pedido "<Id_CancelarPedidoBS>"
    When Se selecciona el motivo "<Id_CancelarPedidoBS>"
    Then Confirmamos la cancelación "<Id_CancelarPedidoBS>"
    Examples:
      | Id_CancelarPedidoBS |
      | 1 |
