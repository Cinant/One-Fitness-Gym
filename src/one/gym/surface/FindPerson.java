package one.gym.surface;

import one.gym.underground.Person;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FindPerson extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String ids = req.getParameter("key");
		long id = Long.parseLong(ids);
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		/**final Query q = pm.newQuery(Person.class);
		q.setFilter("id == id");
		//q.setOrdering("height desc");
		q.declareParameters("String id");*/
		//Person person = pm.getObjectById(Person.class, id);
		
		try {
			@SuppressWarnings("unchecked")
			//List<Person> person = (List<Person>) q.execute(id);
			
			Person person = pm.getObjectById(Person.class, id);
			//if (!person.isEmpty()&& person.size()==1) {
			    //Person p = person.get(0);
				
				
			req.setAttribute("person", person);
			    
			  //} else {
			    
			  //}
			//req.setAttribute("person", person);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateperson.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//q.closeAll();
			pm.close();
		}

	}
}
