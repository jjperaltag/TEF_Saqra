Feature: El usuario puede agendar la visita de Tecnico
	@SmokeTest
	Scenario Outline: Como Usuario Activo, me logueo al sistema y programo un agendamiento
	#Scenario Outline: Como Cliente Activo, me logueo al sistema
		Given Soy Cliente e ingreso al sistema "<Id_Agendar>"
		When Hacemos login seleccionando el tipo_documento y numero_documento "<Id_Agendar>"
		#Given Me logue con mi SMS y ubico mi "<Id_Agendar>"
		When Agendo pedido de visita, en la fecha de hoy  y turno mañana, donde recibire al tecnico, en la direccion registrada. "<Id_Agendar>"
		When Se programa visita en fecha seleccionada "<Id_Agendar>"
		Then Se confirma el agendamiento "<Id_Agendar>"
		Examples:
			| Id_Agendar |
			|  5 |

