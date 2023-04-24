package com.pxa.sample.server.rpc;

import com.pxa.sample.client.exception.ClientException;
import com.pxa.sample.client.rpc.RPCRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-10 19:02
 */
@Service("RPCRemoteServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RPCRemoteServiceImpl implements RPCRemoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RPCRemoteServiceImpl.class);

    @Override
    public Map execute(Map<String, Object> params) throws ClientException {
        Map<String, Object> resultMap = new HashMap<>();

        String username = params.get("username").toString();
        String password = params.get("password").toString();

        if ("admin".equals(username) && "123".equals(password)) {
            resultMap.put("message", String.format("Spring Boot GWT Server Say: Welcome, %s", username));
        } else {
            throw new ClientException("账号或者密码错误，请重新输入");
        }

        LOGGER.info(">>> rpc request message: " + resultMap.toString());

        LOGGER.info("嘻嘻");

        return resultMap;
    }
}
