from auto import Auto
from moto import Moto
from camion import Camion

class Flota:
  def __init__(self):
    self.vehiculos = []

  def agregar_vehiculo(self):
    tipo = input("Tipo (auto/moto/camion): ").strip().lower()
    color = input("Color: ").strip()
    
    try:
      peso = float(input("Peso (kg): ").strip())
    except ValueError:
      print("Error: El peso debe ser un número.")
      return

    electrico = False
    if tipo != "camion":
      electrico = input("¿Es eléctrico? (s/n): ").strip().lower() == 's'

    if tipo == "auto":
      vehiculo = Auto(color, peso, electrico)
    elif tipo == "moto":
      vehiculo = Moto(color, peso, electrico)
    elif tipo == "camion":
      vehiculo = Camion(color, peso)
    else:
      print("Tipo de vehículo no válido.")
      return

    self.vehiculos.append(vehiculo)
    print("Vehículo agregado correctamente.")

  def generar_reporte(self):
    total = 0
    electricos = 0
    requiere_inspeccion = 0

    for v in self.vehiculos:
      v.imprimir_datos()
      total += v.calcular_costo()
      if v.es_electrico:
        electricos += 1
      if v.necesita_inspeccion():
        requiere_inspeccion += 1

    print("\n--- RESUMEN DE FLOTA ---")
    print(f"Total de vehículos: {len(self.vehiculos)}")
    print(f"Vehículos eléctricos: {electricos}")
    print(f"Vehículos que requieren inspección: {requiere_inspeccion}")
    print(f"Valor total de la flota: ${total}")
