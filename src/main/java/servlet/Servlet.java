package servlet;

import jms.producer.SenderBean;
import jms.receiver.ReceiverBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gregor Tudan
 */
@WebServlet("/message")
public class Servlet extends HttpServlet {

	@EJB
	private ReceiverBean receiverBean;
	@EJB
	private SenderBean senderBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] message = receiverBean.getMessages();
		resp.setContentType("text/html");
		resp.getWriter().append("<html><body><ul>");
		for (String msg : message) {
			resp.getWriter().append(String.format("<li>%s</li>", msg));
		}
		resp.getWriter().append("</ul></body</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		senderBean.sendMessageJavaEE7(req.getParameter("message"));
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		resp.getWriter().write("OK");
	}

}
