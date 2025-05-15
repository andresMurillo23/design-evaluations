from vehiculo import Vehiculo

class Camion(Vehiculo):
  def __init__(self, color, peso):
    super().__init__(color, peso, ruedas=4, es_electrico=False, capacidad_pasajeros=2)

  def calcular_costo(self):
    base = 45000
    extra = self.peso * 200
    return base + extra

  def necesita_inspeccion(self):
    return True
