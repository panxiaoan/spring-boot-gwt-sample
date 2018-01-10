package com.pxa.sample.springboot.gwt.server.web;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.pxa.sample.springboot.gwt.client.exception.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-10 19:06
 */
public class RPCServlet extends RemoteServiceServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(RPCServlet.class);

    private WebApplicationContext applicationContext = null;

    @Override
    public void init() {
        if (applicationContext == null) {
            applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        }
        LOGGER.info(">>> RPCServlet init success...{}", applicationContext);
    }

    @Override
    public String processCall(String payload) throws SerializationException {

        try {
            Object handler = getBean(getThreadLocalRequest());
            RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
            onAfterRequestDeserialized(rpcRequest);
            String result = RPC.invokeAndEncodeResponse(handler, rpcRequest.getMethod(),
                    rpcRequest.getParameters(), rpcRequest.getSerializationPolicy(), rpcRequest.getFlags());
            return result;
        } catch (Exception ex) {
            LOGGER.error("", ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }

    protected String getService(HttpServletRequest request) {
        String url = request.getRequestURI();
        String service = url.substring(url.lastIndexOf("/") + 1);
        LOGGER.debug("GWT RPC RemoteService: {}", url, service);
        return service;
    }

    protected Object getBean(HttpServletRequest request) {
        String service = getService(request);
        Object bean = getBean(service);
        if (!(bean instanceof RemoteService)) {
            throw new ClientException("Spring bean is not a GWT RemoteService: " + service + " (" + bean + ")");
        }
        return bean;
    }

    protected Object getBean(String name) {
        Assert.notNull(applicationContext, "'applicationContext' is null");

        Object bean = applicationContext.getBean(name);
        if (bean == null) {
            throw new ClientException("Spring bean not found: " + name);
        }
        return applicationContext.getBean(name);
    }

}
