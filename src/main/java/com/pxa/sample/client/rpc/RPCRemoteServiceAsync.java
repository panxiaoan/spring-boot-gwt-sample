package com.pxa.sample.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-10 18:51
 */
public interface RPCRemoteServiceAsync {
    void execute(final Map<String, Object> params, AsyncCallback<Map<String, Object>> rpcCallback);
}
