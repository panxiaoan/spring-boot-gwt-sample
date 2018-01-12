package com.pxa.sample.springboot.gwt.server.model.vo;

import java.io.Serializable;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-12 16:17
 */
public class UserVO implements Serializable {

    private String username;
    private String password;

    public UserVO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
