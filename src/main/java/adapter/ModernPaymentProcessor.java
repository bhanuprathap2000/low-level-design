package adapter;

public class ModernPaymentProcessor implements PaymentProcessor{

    boolean isPaymentSuccess;
    String transactionId;

    @Override
    public void processPayment(double amount) {

        System.out.println("Modern Gateway: Processing payment of amount %s".formatted(amount));

        isPaymentSuccess = true;

        transactionId = "TXN_" + System.currentTimeMillis();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return isPaymentSuccess;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}
