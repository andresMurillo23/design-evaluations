# Tarea 3 – Análisis y Refactorización con Patrones de Diseño

## Errores de diseño identificados

1. **Violación del Principio de Sustitución de Liskov (LSP)**  
La clase `Food` implementa el método `testFunctionality()` lanzando una `UnsupportedOperationException`, lo cual rompe el contrato de la interfaz `Item` y causa errores en tiempo de ejecución cuando se utiliza polimorfismo.

2. **Violación del Principio de Responsabilidad Única (SRP)**  
`ElectronicProduct` contiene tanto la representación del producto como la lógica de prueba. Esto mezcla responsabilidades que deberían estar separadas.

3. **Lógica de creación acoplada y difícil de extender**  
En `ItemCreator`, la creación de objetos está controlada por múltiples estructuras condicionales `if/else`, lo cual hace que el código sea rígido y difícil de extender sin modificarlo.

4. **Implementación de Singleton no segura**  
La implementación actual del método `getInstance()` en `ShoppingCart` no es segura para entornos concurrentes, lo cual puede provocar la creación de múltiples instancias.

5. **Acceso concurrente no controlado**  
La lista de ítems (`items`) en `ShoppingCart` es un `ArrayList` no sincronizado, y se accede desde múltiples hilos sin protección, lo que puede generar errores como corrupción de memoria o comportamientos no esperados.

6. **Inserción de valores nulos en el carrito**  
No hay verificación para evitar que se agreguen objetos nulos al carrito. Esto llevó a errores en tiempo de ejecución, como `NullPointerException` al calcular el precio total.

---

## **Refactorizaciones realizadas**

### **Refactor 1: Aplicación del patrón Factory Method**  
Se creó la interfaz `ItemFactory` junto con las implementaciones concretas `ElectronicItemFactory` y `FoodItemFactory`. `ItemCreator` ahora delega la creación de productos a las fábricas, eliminando condicionales y facilitando la extensión del sistema.  
Errores corregidos: 3

### **Refactor 2: Aplicación del patrón Strategy**  
Se creó la interfaz `TestStrategy` y dos estrategias concretas: `ElectronicTestStrategy` y `NoTestStrategy`. Cada tipo de ítem utiliza una estrategia adecuada, eliminando el uso de excepciones como flujo de control y separando responsabilidades.  
Errores corregidos: 1 y 2

### **Refactor 3: Singleton thread-safe y lista sincronizada**  
`ShoppingCart` fue convertido a un Singleton con inicialización temprana (`private static final`). Además, la lista `items` fue transformada en una `Collections.synchronizedList` y se envolvieron los bloques de lectura con `synchronized` para evitar errores concurrentes.  
Errores corregidos: 4, 5 y 6

---

## Justificación de los refactores

Se eligieron estos tres refactores por su impacto directo en los errores más críticos del sistema:

- El patrón Factory Method permitió desacoplar la lógica de creación de objetos, lo cual era necesario para mejorar la extensibilidad del sistema.
- Strategy resolvió el problema de romper la interfaz con excepciones y permitió desacoplar la lógica de prueba del dominio.
- La refactorización del Singleton y el manejo de concurrencia eran fundamentales dado que el `Main` ejecuta múltiples hilos de forma simultánea.

---

## Resultados después del refactor

- El sistema funciona correctamente bajo carga concurrente.
- No se producen errores de ejecución ni excepciones inesperadas.
- Todos los ítems se procesan correctamente.
- El código es más claro, modular y extensible.
- Se eliminaron los puntos de fallo identificados sin afectar la funcionalidad general del sistema.

---

## Archivos modificados

- `Services/ItemCreator.java`
- `Services/ItemFactory.java`
- `Services/ElectronicItemFactory.java`
- `Services/FoodItemFactory.java`
- `Services/TestStrategy.java`
- `Services/ElectronicTestStrategy.java`
- `Services/NoTestStrategy.java`
- `Items/ElectronicProduct.java`
- `Items/Food.java`
- `ShoppingCart.java`

---

## Conclusión

Los refactores aplicados resolvieron los problemas estructurales del código y mejoraron significativamente la calidad general del sistema. Se eliminaron errores críticos de diseño, se aplicaron principios SOLID, y se utilizaron patrones de diseño que facilitan la escalabilidad y el mantenimiento futuro del proyecto. Aca se puede ver la salida correcta del programa:

```bash
Starting stress test with 10 threads, adding 100 items each...
Actual total items: 1000
Total items to test: 1000
Total items tested: 1000
Broken items: 41
Errors during testing: 0
Total price of items in the cart: 482.12252016141554
```
