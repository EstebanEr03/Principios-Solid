package dip.payment;

// Implementación concreta para pagos con tarjeta de crédito
class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
