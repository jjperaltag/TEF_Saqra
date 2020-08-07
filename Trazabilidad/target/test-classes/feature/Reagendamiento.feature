Feature: El usuario puede reagendar la visita de Tecnico

@SmokeTest
Scenario Outline: Como Usuario Activo, me logueo al sistema y programo un reagendamiento
	Given Me logue con mi SMS y ubico mi cita para reagendar "<Id_Reagendar>"
	When Reagendo pedido de visita, al dia siguiente. "<Id_Reagendar>"
	When Se reprograma la visita en fecha seleccionada "<Id_Reagendar>"
	Then Se confirma el reagendamiento "<Id_Reagendar>"
	Examples:
	| Id_Reagendar |
	|  5 |
	

