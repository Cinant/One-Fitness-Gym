package one.gym.surface;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CloseSesion extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//resp.setContentType("text/html");

		

		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		HttpSession misesion = req.getSession();

		

		if (user == null) {
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));
		} else {
			misesion.invalidate();
			resp.sendRedirect(us.createLogoutURL("/index.jsp"));
			us.createLogoutURL(req.getRequestURI());
			

		}
	}
}
