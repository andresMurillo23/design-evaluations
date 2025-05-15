from abc import ABC, abstractmethod

class Vehiculo(ABC):
  def __init__(self, color, peso, ruedas, es_electrico, capacidad_pasajeros):
    self.color = color
    self.peso = peso
    self.ruedas = ruedas
    self.es_electrico = es_electrico
    self.capacidad_pasajeros = capacidad_pasajeros
    self.estado = "nuevo"

  @abstractmethod
  def calcular_costo(self):
    pass

  @abstractmethod
  def necesita_inspeccion(self):
    pass

  def imprimir_datos(self):
    print(f"Vehículo tipo: {self.__class__.__name__}")
    print(f"Color: {self.color}")
    print(f"Peso: {self.peso} kg")
    print(f"Ruedas: {self.ruedas}")
    print(f"Eléctrico: {'Sí' if self.es_electrico else 'No'}")
    print(f"Capacidad: {self.capacidad_pasajeros} pasajeros")
    print(f"Costo: ${self.calcular_costo()}")
    print(f"Requiere inspección: {'Sí' if self.necesita_inspeccion() else 'No'}")
    print("------------------------")
