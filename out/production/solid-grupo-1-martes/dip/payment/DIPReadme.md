Refactorización con el Principio de Inversión de Dependencias (DIP)
Este documento describe el proceso de refactorización aplicado al módulo de pagos del proyecto para cumplir con el Principio de Inversión de Dependencias (DIP).

Problema Inicial: Acoplamiento Fuerte
El código original tenía una violación directa del DIP. La clase de alto nivel PaymentProcessor dependía directamente de una implementación de bajo nivel, la clase CreditCardPayment.

Código problemático:

Java

class PaymentProcessor {
private CreditCardPayment payment;

    public PaymentProcessor() {
        // ❌ Dependencia directa: El módulo de alto nivel crea y depende de un módulo de bajo nivel.
        this.payment = new CreditCardPayment();
    }

    public void makePayment(double amount) {
        payment.processPayment(amount);
    }
}
Esto generaba dos problemas principales:

Rigidez: Era imposible cambiar el método de pago sin modificar el código de PaymentProcessor.
Fragilidad: Agregar nuevos métodos de pago (como PayPal o Cripto) requería una reestructuración significativa de la clase, violando el Principio Abierto/Cerrado.
Solución Aplicada: Inversión de la Dependencia
Para solucionar el problema, se invirtió la dirección de la dependencia aplicando el DIP. En lugar de que el módulo de alto nivel dependa del de bajo nivel, ahora ambos dependen de una abstracción.

Pasos de la Refactorización
Crear una Abstracción 📝:
Se creó una interfaz llamada PaymentMethod. Esta interfaz define un "contrato" con un método processPayment(double amount) que cualquier método de pago debe implementar. Esta abstracción es el punto central del nuevo diseño.

Java

// La abstracción de la que todos dependerán
interface PaymentMethod {
void processPayment(double amount);
}
Hacer que los Módulos de Bajo Nivel Dependan de la Abstracción 🔩:
Las clases CreditCardPayment, PayPalPayment y CryptoPayment se modificaron para implementar la interfaz PaymentMethod. De esta forma, los "detalles" ahora dependen de la abstracción.

Java

class CreditCardPayment implements PaymentMethod {
// ... implementación del método processPayment
}

class PayPalPayment implements PaymentMethod {
// ... implementación del método processPayment
}
Hacer que el Módulo de Alto Nivel Dependa de la Abstracción ✨:
La clase PaymentProcessor se refactorizó para depender de la interfaz PaymentMethod, no de una clase concreta. La implementación específica se suministra desde el exterior a través del constructor, una técnica conocida como Inyección de Dependencias.

Java

class PaymentProcessor {
// ✅ Depende de la abstracción
private final PaymentMethod paymentMethod;

    // ✅ La dependencia se inyecta desde fuera
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        // Se comunica a través de la interfaz, sin conocer el detalle
        paymentMethod.processPayment(amount);
    }
}
Beneficios Obtenidos
Al aplicar el DIP, el sistema ganó:

Flexibilidad: PaymentProcessor puede trabajar con cualquier método de pago que cumpla con la interfaz PaymentMethod.
Escalabilidad: Añadir nuevos métodos de pago es tan simple como crear una nueva clase que implemente la interfaz, sin necesidad de tocar el código de PaymentProcessor.
Testabilidad: Es mucho más fácil realizar pruebas unitarias de PaymentProcessor al poder inyectarle "mocks" o simulacros de PaymentMethod.