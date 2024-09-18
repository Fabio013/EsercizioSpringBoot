package co.develhope.demo_esercizio1709;

import org.springframework.http.HttpStatus;

public class CustomResponse <T> {
    private int code;
    private HttpStatus status;
    private T data;

    public CustomResponse(int code, HttpStatus status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public CustomResponse(int code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
