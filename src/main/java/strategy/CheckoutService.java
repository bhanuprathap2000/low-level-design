package strategy;

public class CheckoutService {

    private PaymentGateway paymentGateway;

    /**
     * pg is the juspay payment gateway , but the checkout service( client) doesn't directly use the juspay payment
     * gateway, it uses the payment gateway interface and access the juspay.
     *
     * So there is no tight coupling ( we could sap with different implementation or dynamic selection).
     * */

    CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    void setPaymentGateway(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    void initiatePayment(double amount){

        paymentGateway.initiatePayment(amount);
    }



}
