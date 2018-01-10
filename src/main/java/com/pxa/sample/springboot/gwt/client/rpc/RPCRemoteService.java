package com.pxa.sample.springboot.gwt.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.pxa.sample.springboot.gwt.client.exception.ClientException;
import com.sun.deploy.util.SessionState;

import java.util.Map;

/**
 *
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 */
@RemoteServiceRelativePath("rpc/RPCRemoteServiceImpl")
public interface RPCRemoteService extends RemoteService {

    Map execute(final Map<String, Object> params) throws ClientException;

}

