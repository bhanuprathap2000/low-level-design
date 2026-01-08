package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {

    private static final Map<String, Supplier<PaymentGateway>> registry = new HashMap<>();

    static {
        registry.put("card",JuspayPaymentGateway::new);
        registry.put("upi",RazorpayPaymentGateway::new);
    }


    public static PaymentGateway getPaymentGateway(String paymentMethod){

        Supplier<PaymentGateway> supplier = registry.get(paymentMethod.toLowerCase());

        if (supplier == null) {
            throw new RuntimeException("Payment method not supported");

        }

        return supplier.get();
    }
}
