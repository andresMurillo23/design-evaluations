from flota import Flota

def main():
  flota = Flota()

  while True:
    print("\n--- MENÚ ---")
    print("1. Agregar vehículo")
    print("2. Generar reporte")
    print("3. Salir")

    opcion = input("Seleccione una opción: ").strip()

    if opcion == "1":
      flota.agregar_vehiculo()
    elif opcion == "2":
      flota.generar_reporte()
    elif opcion == "3":
      print("¡Hasta luego!")
      break
    else:
      print("Opción no válida. Intente nuevamente.")

if __name__ == "__main__":
  main()
