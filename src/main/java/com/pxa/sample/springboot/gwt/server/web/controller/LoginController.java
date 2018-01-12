package com.pxa.sample.springboot.gwt.server.web.controller;

import com.apple.eawt.AppEvent;
import com.pxa.sample.springboot.gwt.client.exception.ClientException;
import com.pxa.sample.springboot.gwt.server.model.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-12 16:00
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody UserVO userVO) {
        if ("admin".equals(userVO.getUsername()) && "123".equals(userVO.getPassword())) {
            return String.format("Spring Boot GWT Server Say: Welcome, %s", userVO.getUsername());
        } else {
            throw new ClientException("账号或者密码错误，请重新输入");
        }
    }
}
