package miscellaneous;

public enum OrderStatus {

    PLACED("1"),
    CONFIRMED("2"),
    SHIPPED("3"),
    DELIVERED("4"),
    CANCELLED("5");

    private final String value;

    OrderStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
