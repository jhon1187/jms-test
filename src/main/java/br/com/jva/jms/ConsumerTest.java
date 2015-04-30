package br.com.jva.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/testJmsQueue", 
			   activationConfig = { @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"), 
									@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class ConsumerTest implements MessageListener {

	@Override
	public void onMessage(Message message) {
		String msg = null;
		try {
			msg = message.getBody(String.class);
		} catch (JMSException e) {
			e.printStackTrace();
		}

		System.out.println("*************** CONTEUDO DA MENSAGEM RECEBIDA: " + msg);
	}

}