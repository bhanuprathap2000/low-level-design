package adapter;

public class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    CheckoutService(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void checkOutAmount(double amount){

        System.out.println("Starting the checkout process");

        paymentProcessor.processPayment(amount);

        if(paymentProcessor.isPaymentSuccessful()){

            System.out.println("Payment is success, your order is booked");
        }else{
            System.out.println("Payment still in process...");
        }
    }

}
