package dev.spring.restapi.core.result;

import lombok.Getter;

import javax.xml.crypto.Data;
@Getter
public class   ResultData <T> extends  Result{
    private T data;
    public ResultData(boolean status, String message, String httpCode,T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
