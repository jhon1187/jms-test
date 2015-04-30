package br.com.jva.jms;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sendMessage", loadOnStartup = 1)
public class SendMessageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProducerTest producerTest;

	@Override
	public void init() throws ServletException {
		produzirMensagem();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produzirMensagem();
	}

	public void produzirMensagem() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Enviando mensagem [" + i + "]");
			producerTest.enviarMensagem("Message [" + i + "]");
		}
	}

}
