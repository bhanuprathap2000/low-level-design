package strategy;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String paymentMethod = scanner.next();

        PaymentGateway paymentGateway = PaymentFactory.getPaymentGateway(paymentMethod);
        var checkoutService = new CheckoutService(paymentGateway);

        checkoutService.initiatePayment(200);



        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("3");

        a.multiply(b).toString();

        Map<Integer,Integer> majorityMap = new HashMap<>();

    }
}
