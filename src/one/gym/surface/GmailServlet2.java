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

import one.gym.underground.KindOfPerson;
import one.gym.underground.Person;
import one.gym.underground.Resource;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GmailServlet2 extends HttpServlet{
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
					
					if(p.isActive()){
						
						Query qe = pm.newQuery(Resource.class);
						q.setFilter("name == nameR");
						q.declareParameters("String nameR");
						@SuppressWarnings("unchecked")
						List<Resource>  rl= (List<Resource>) qe.execute("CRUD");
						misesion = req.getSession(true);
						misesion.setAttribute("estado", String.valueOf(rl.get(0).getId().getId()) );
						misesion.setAttribute("email", user.getEmail());
						misesion.setAttribute("name", p.getName());
						misesion.setAttribute("surname", p.getSurName());
						misesion.setAttribute("id", p.getId().getId());
						misesion.setAttribute("person", p);
						//misesion.setAttribute("estado", (String)((Boolean)p.isActive()).toString());
						
						if(p.getPersonalResources().isEmpty()){
							//Query q2 = pm.newQuery(KindOfPerson.class);
							KindOfPerson koperson = pm.getObjectById(KindOfPerson.class, Long.parseLong(p.getKindOfPerson()));
							misesion.setAttribute("permisos", koperson.getPermision());
							
						}else{
							misesion.setAttribute("permisos", p.getPersonalResources());
						}
						
						
						misesion.setAttribute("all", p);
						resp.sendRedirect("/");
					}else{
						resp.sendRedirect(us.createLogoutURL("/"));
					}

					
					
					
				} else {
					resp.sendRedirect(us.createLogoutURL("/index.jsp"));
				}
				// req.setAttribute("person", person);
				// RequestDispatcher rd =
				// req.getRequestDispatcher("/WEB-INF/listkoperson.jsp");
				// rd.forward(req, resp);
			} catch (Exception e) {
				System.out.println(e);
				resp.sendRedirect("/");
			} finally {
				q.closeAll();
				pm.close();
			}

		}
	}
}