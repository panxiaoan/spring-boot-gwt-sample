package com.pxa.sample.server.web.controller;

import com.pxa.sample.server.model.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-07-12 17:57
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Map<String, Map<String, Object>> list() {
        List<UserVO> userList = new ArrayList<>();
        UserVO user = new UserVO(1L, "admin", "admin", 18, "Male");
        user.setPassword("");
        userList.add(user);

        user = new UserVO(2L, "jack", "jack", 18, "Male");
        user.setPassword("");
        userList.add(user);

        user = new UserVO(3L, "lucy", "lucy", 18, "Female");
        user.setPassword("");
        userList.add(user);

        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("status", 0);
        dataMap.put("startRow", 0);
        dataMap.put("endRow", 3);
        dataMap.put("totalRows", 3);

        dataMap.put("data", userList);

        Map<String, Map<String, Object>> result = new HashMap<>(10);
        result.put("response", dataMap);

        return result;
    }

    @RequestMapping(value = "/list2", method = RequestMethod.POST)
    public Map<String, Object> list2() {
        Map<String, Object> res = new HashMap<>();
        res.put("string", "asdasd");
        res.put("num", 2.3);
        res.put("array", Arrays.asList(new String[]{"asd", "asdas", "sdsd"}));
        return res;
    }


}
