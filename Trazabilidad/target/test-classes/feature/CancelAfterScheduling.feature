Feature: Verificar que el titular pueda cancelar su pedido a traves de trazabilidad y que se envie un mensaje confirmando
            la cancelación de la agenda. DESPUÉS del agendamiento

  @SmokeTest
  Scenario Outline: Como Cliente Activo, me logueo al sistema
    Given Soy Cliente e ingreso al sistema "<Id_CancelarPedidoAS>"
    When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_CancelarPedidoAS>"
    #And Se valida que el pedido tenga agendamiento "<Id_CancelarPedidoAS>"
    And Se ingresa a la opción cancelar pedido "<Id_CancelarPedidoAS>"
    When Se selecciona el motivo "<Id_CancelarPedidoAS>"
    Then Confirmamos la cancelación "<Id_CancelarPedidoAS>"
    Examples:
      | Id_CancelarPedidoAS |
      | 1 |
