from vehiculo import Vehiculo

class Auto(Vehiculo):
  def __init__(self, color, peso, es_electrico):
    super().__init__(color, peso, ruedas=4, es_electrico=es_electrico, capacidad_pasajeros=5)

  def calcular_costo(self):
    base = 15000
    extra = self.peso * 100
    if self.es_electrico:
      extra += 5000
    return base + extra

  def necesita_inspeccion(self):
    return self.peso > 2000
