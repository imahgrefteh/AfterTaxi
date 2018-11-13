package hello.Generic;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public final class RestDetails<T> {

    private String url;
    private HttpMethod httpMethod;
    private HttpHeaders httpHeaders;
    private T payload;

    public RestDetails(String url, HttpMethod httpMethod, HttpHeaders httpHeaders) {
        this(url, httpMethod, httpHeaders, null);
    }

    public RestDetails(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, T payload) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.httpHeaders = httpHeaders;
        this.payload = payload;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
