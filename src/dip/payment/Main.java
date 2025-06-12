package dip.payment;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de los diferentes métodos de pago
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod payPal = new PayPalPayment();
        PaymentMethod crypto = new CryptoPayment();

        // Procesar un pago con tarjeta de crédito
        PaymentProcessor creditCardProcessor = new PaymentProcessor(creditCard);
        System.out.println("--- Using Credit Card ---");
        creditCardProcessor.makePayment(150.0);

        // Procesar un pago con PayPal
        PaymentProcessor payPalProcessor = new PaymentProcessor(payPal);
        System.out.println("\n--- Using PayPal ---");
        payPalProcessor.makePayment(75.50);

        // Procesar un pago con criptomonedas
        PaymentProcessor cryptoProcessor = new PaymentProcessor(crypto);
        System.out.println("\n--- Using Crypto ---");
        cryptoProcessor.makePayment(250.25);
    }
}