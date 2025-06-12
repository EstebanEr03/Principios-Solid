package dip.payment;

// Clase de alto nivel que ahora depende de la abstracción
class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    // La dependencia se inyecta a través del constructor
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        // Llama al método de la interfaz, no de la implementación
        paymentMethod.processPayment(amount);
    }
}