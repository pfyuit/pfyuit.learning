package com.pfyuit.myjavaee.dao.messaging.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pfyuit.myjavaee.model.messaging.activemq.Notify;

/**
 * Message consumer service implementation.
 * @author yupengfei
 */
public class MessageConsumerServiceImpl implements MessageConsumerService {

	private static final Logger logger = LoggerFactory.getLogger(MessageConsumerService.class);

	public void receiveMessage(Notify notify) {
		logger.info("Message received: {}==>{}", notify.getNotifyId(), notify.getNotifyMsg());
	}

}
