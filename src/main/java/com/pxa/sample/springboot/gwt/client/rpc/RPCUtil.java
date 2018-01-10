package com.pxa.sample.springboot.gwt.client.rpc;

import com.google.gwt.core.client.GWT;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-10 18:54
 */
public class RPCUtil {

    private static RPCRemoteServiceAsync rpcRemoteServiceAsync = null;

    public static RPCRemoteServiceAsync createRemoteService() {
        if (rpcRemoteServiceAsync == null) {
            rpcRemoteServiceAsync = GWT.create(RPCRemoteService.class);
        }
        return rpcRemoteServiceAsync;
    }
}
