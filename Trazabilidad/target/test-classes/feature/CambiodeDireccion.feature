Feature: El usuario puede cambiar su direccion de instalacion

  @SmokeTest
  Scenario Outline: Como Usuario Activo, me logueo al sistema y cambio direccion de instalacion
    Given Me logueo con mi SMS y ubico mi boton para cambiar direccion de instalacion "<Id_CambiodeDireccion>"
    When Cambio la direcion de instalacion de mi pedido. "<Id_CambiodeDireccion>"
    Examples:
      | Id_CambiodeDireccion |
      |  5 |
