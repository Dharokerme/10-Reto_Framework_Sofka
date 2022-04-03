# language: es
@FeatureName:UsoCarroCompras
Característica: Uso del carro de compras
  Como cliente en línea
  Necesito contactar a Costumer Service
  Para poder solucionar dudas puntuales.

  @ScenarioName:CompraExitosa
    Escenario: Compra exitosa
    Dado que el cliente empieza esta en la página de inicio
    Cuando el cliente crea su cuenta y hace los pasos para comprar un producto
    Entonces debería ver un mensaje de confirmación de compra exitosa.

  @ScenarioName:CompraNoExitosa
  Escenario: Compra no exitosa
    Dado que el cliente empieza esta en la página de inicio
    Cuando el cliente crea su cuenta y hace los pasos para comprar un producto pero se arrepiente y vacia el carro de compras
    Entonces aparece un mensaje de tú carro está vacío.
