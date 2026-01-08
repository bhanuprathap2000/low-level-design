package adapter;

public class LegacyGatewayAdapter implements PaymentProcessor{

    private final LegacyGateway legacyGateway;
    LegacyGatewayAdapter(LegacyGateway legacyGateway){
        this.legacyGateway = legacyGateway;
    }
    @Override
    public void processPayment(double amount) {

        legacyGateway.executeTransaction(amount,"rupee");
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyGateway.checkStatus(legacyGateway.getReferenceNumber());
    }

    @Override
    public String getTransactionId() {
        return String.valueOf(legacyGateway.getReferenceNumber());
    }
}
