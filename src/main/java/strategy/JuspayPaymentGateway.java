package strategy;

class JuspayPaymentGateway implements PaymentGateway {
        @Override
        public void initiatePayment(double amount) {

            System.out.println("call JUSPAY API with amount : %s".formatted(amount));
        }
    }