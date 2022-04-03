# language: es
@FeatureName:contactoConElCostumerService
Característica: Contactar con el Costumer Service
  Como cliente en línea
  Necesito contactar a Costumer Service
  Para poder solucionar dudas puntuales.

  @ScenarioName:EnviarMensajeOk
  Escenario: Mensaje enviado correctamente
    Dado que el cliente esta en la página de inicio
    Cuando el cliente envia su mensaje al administrador
    Entonces como resultado se muestra un mensaje de exito

  @ScenarioName:EnviarMensajeError
  Escenario: Mensaje no enviado
    Dado que el cliente esta en la página de inicio
    Cuando el cliente envia un mensaje incorrecto al administrador
    Entonces como resultado se muestra un mensaje de error
