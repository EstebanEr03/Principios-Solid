package dip.payment;

// Abstracción que define el contrato para cualquier método de pago
interface PaymentMethod {
    void processPayment(double amount);
}