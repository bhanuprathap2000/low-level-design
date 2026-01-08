package strategy;

public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public void initiatePayment(double amount) {
        System.out.println("call Razorpay API with amount : %s".formatted(amount));
    }
}
