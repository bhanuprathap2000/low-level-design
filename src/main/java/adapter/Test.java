package adapter;

public class Test {

    public static void main(String[] args) {

        ModernPaymentProcessor modernPaymentProcessor = new ModernPaymentProcessor();

        LegacyGateway legacyGateway = new LegacyGateway();
        LegacyGatewayAdapter legacyGatewayProcessor = new LegacyGatewayAdapter(legacyGateway);

        CheckoutService checkoutServiceWithModernPayment = new CheckoutService(modernPaymentProcessor);
        CheckoutService checkoutServiceWithLegacyPayment = new CheckoutService(legacyGatewayProcessor);

        checkoutServiceWithModernPayment.checkOutAmount(100);
        checkoutServiceWithLegacyPayment.checkOutAmount(200);

    }
}

