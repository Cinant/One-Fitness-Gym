package one.gym.surface;

import java.io.IOException;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import one.gym.underground.Person;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GmailServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");

		

		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		HttpSession misesion;

		final PersistenceManager pm = PMF.get().getPersistenceManager();

		if (user == null) {
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));
		} else {

			Query q = pm.newQuery(Person.class);
			q.setFilter("mail == email");
			// q.setOrdering("height desc");
			q.declareParameters("String email");

			// q.setRange(0, 10);
			try {
				@SuppressWarnings("unchecked")
				List<Person> person = (List<Person>) q.execute(user.getEmail());
				if (!person.isEmpty() && person.size() == 1) {
					Person p = person.get(0);

					misesion = req.getSession(true);
					misesion.setAttribute("email", user.getEmail());
					misesion.setAttribute("name", p.getName());
					misesion.setAttribute("surname", p.getSurName());
					misesion.setAttribute("id", p.getId().getId());
					//misesion.setAttribute("all", (Person)p);
					misesion.setAttribute("estado", (String)((Boolean)p.isActive()).toString());
					//misesion.setAttribute("all", p);
					resp.sendRedirect("/");
					
					/*out.println("<!DOCTYPE html>" + "<html>"
							+ "<head><title>Información de la cuenta</title>"
							+ "<meta charset=utf-8;>" + "<body>"
							+ "<h1>Información de la Cuenta Google</h1>"
							+ "<br><a href='../'>Regresar...</a>"
							+ "<br/><b>User :</b>"
							+ "<br/>getNickname retornó : "
							+ user.getNickname()
							+ "<br/>getAuthDomain retornó : "
							+ user.getAuthDomain()
							+ "<br/>getEmail retornó : "
							+ user.getEmail()
							+ "<br/>getUserId retornó : "
							+ user.getUserId()
							+ "<br/>getFederatedIdentity retornó : "
							+ user.getFederatedIdentity()
							+ "<br/>"
							+ "Email : "
							+ misesion.getAttribute("email")
							+ "Nombre : "
							+ misesion.getAttribute("name")
							+ "Apellido : "
							+ misesion.getAttribute("surname")
							+ "<br/><b>UserService :</b>"
							+ "<br/>isUserAdmin retornó : "
							+ us.isUserAdmin()
							+ "<br/>isUserLoggedIn retornó : "
							+ us.isUserLoggedIn()
							+ "<br/>getCurrentUser retornó : "
							+ us.getCurrentUser()
							+ "<br/>"
							+ "<a href='"
							+ us.createLogoutURL(req.getRequestURI())
							+ "'> Cerrar sesión </a>" + "</body></html>");*/

				} else {

				}
				// req.setAttribute("person", person);
				// RequestDispatcher rd =
				// req.getRequestDispatcher("/WEB-INF/listkoperson.jsp");
				// rd.forward(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				q.closeAll();
				pm.close();
			}

		}
	}
}