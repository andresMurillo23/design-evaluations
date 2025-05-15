from vehiculo import Vehiculo

class Moto(Vehiculo):
  def __init__(self, color, peso, es_electrico):
    super().__init__(color, peso, ruedas=2, es_electrico=es_electrico, capacidad_pasajeros=2)

  def calcular_costo(self):
    base = 8000
    extra = self.peso * 50
    if self.es_electrico:
      extra += 3000
    return base + extra

  def necesita_inspeccion(self):
    return self.peso > 300
