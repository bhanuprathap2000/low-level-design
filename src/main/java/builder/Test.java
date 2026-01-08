package builder;

public class Test {

    public static void main(String[] args) {

        HttpRequest request1 = new HttpRequest.Builder("https://api.example.com/data")
                .build();

        HttpRequest request2 = new HttpRequest.Builder("https://api.example.com/data")
                .withMethod("POST")
                .withBody("{\"key\":\"value\"}")
                .withTimeout(15000)
                .build();

        HttpRequest request3 = new HttpRequest.Builder("https://api.example.com/data")
                .withMethod("PUT")
                .withHeaders("X-API-KEY","secret")
                .withQueryParameters("env","prod")
                .withBody("{\"key\":\"value\"}")
                .withTimeout(30000)
                .build();


        System.out.println(request1);
        System.out.println(request2);
        System.out.println(request3);
    }
}
