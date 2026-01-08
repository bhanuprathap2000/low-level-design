package builder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String url;

    private final String method;

    private final Map<String,String> headers;
    private final Map<String,String> queryParameters;

    private final String body;

    private final int timeout;

    private HttpRequest(Builder builder){

        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParameters = builder.queryParameters;
        this.body = builder.body;
        timeout = builder.timeout;
    }


    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParameters=" + queryParameters +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    public static class Builder{

        private final String url; // required

        public Builder(String url){
            this.url = url;
        }

        private String method = "GET";

        private  Map<String,String> headers = new HashMap<>();
        private Map<String,String> queryParameters = new HashMap<>();

        private String body;

        private int timeout;

        public Builder withMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder withHeaders(String key,String value) {
            this.headers.put(key,value);
            return this;
        }

        public Builder withQueryParameters(String key,String value) {
            this.queryParameters.put(key, value);
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build(){
            return new HttpRequest(this);
        }
    }
}
