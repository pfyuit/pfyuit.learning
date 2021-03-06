package com.pfyuit.myjavaee.dao.messaging.activemq;

import com.pfyuit.myjavaee.model.messaging.activemq.Notify;

/**
 * Message producer service interface.
 * @author yupengfei
 */
public interface MessageProducerService {

	public void sendMessage(Notify notify);

}
