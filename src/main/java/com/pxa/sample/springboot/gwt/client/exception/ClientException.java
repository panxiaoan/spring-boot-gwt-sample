package com.pxa.sample.springboot.gwt.client.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-10 18:50
 */
public class ClientException extends RuntimeException implements IsSerializable {

    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
