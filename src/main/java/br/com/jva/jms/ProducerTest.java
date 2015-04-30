package br.com.jva.jms;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

@Singleton
public class ProducerTest {

	@Resource(mappedName = "jms/testJmsFactory")
	private ConnectionFactory factory;

	@Resource(mappedName = "jms/testJmsQueue")
	private Queue queue;

	public void enviarMensagem(String msg) {
		try {
			Connection connection = this.factory.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(this.queue);

			ObjectMessage message = session.createObjectMessage();

			message.setObject(msg);

			messageProducer.send(message);

			messageProducer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}