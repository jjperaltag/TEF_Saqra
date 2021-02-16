Feature: El usuario puede cambiar datos del Contacto

  @SmokeTest
  Scenario Outline: Como Usuario Activo, me logueo al sistema y cambio datos del contacto
    Given Me logue con mi SMS y ubico mi boton "<Id_CambioContacto>"
    When Cambio el contacto que recibira al tecnico, en la direccion registrada. "<Id_CambioContacto>"
    Then Se cambia contacto de instalacion "<Id_CambioContacto>"
    Examples:
      | Id_CambioContacto |
      |  5 |
