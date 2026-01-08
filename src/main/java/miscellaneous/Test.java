package miscellaneous;

public class Test {

    public static void main(String[] args) {


        var orderStatus =  OrderStatus.valueOf("PLACED");

        System.out.println(orderStatus);

        System.out.println(orderStatus.name());

        System.out.println(orderStatus.getValue());


    }
}
