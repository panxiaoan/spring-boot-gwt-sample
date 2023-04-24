package com.pxa.sample.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.pxa.sample.client.exception.ClientException;

import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-10 19:06
 */
@RemoteServiceRelativePath("rpc/RPCRemoteServiceImpl")
public interface RPCRemoteService extends RemoteService {

    Map execute(final Map<String, Object> params) throws ClientException;

}

