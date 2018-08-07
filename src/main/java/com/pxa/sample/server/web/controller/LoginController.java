package com.pxa.sample.server.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxa.sample.client.RestResult;
import com.pxa.sample.client.exception.ClientException;
import com.pxa.sample.server.model.vo.UserVO;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-12 16:00
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserVO userVO) {
        if ("admin".equals(userVO.getUsername()) && "123".equals(userVO.getPassword())) {
            return String.format("Spring Boot GWT Server Say: Welcome, %s", userVO.getUsername());
        } else {
            throw new ClientException("账号或者密码错误，请重新输入");
        }
    }
    
    @RequestMapping(value = "/rpcLogin", method = RequestMethod.POST)
    public RestResult rpcLogin(@RequestBody UserVO userVO) {
    	if ("admin".equals(userVO.getUsername()) && "123".equals(userVO.getPassword())) {
            return new RestResult(0, "登录成功");
        } else {
        	return new RestResult(1, "登录失败，用户名或密码错误");
        }
    }
}
