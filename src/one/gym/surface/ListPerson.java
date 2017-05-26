package one.gym.surface;
import one.gym.underground.*;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListPerson  extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/plain");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Person.class);
		
		q.setOrdering("id descending");
		//q.setRange(0, 10);
			try{
				@SuppressWarnings("unchecked")
				List<Person> person = (List<Person>) q.execute();
				req.setAttribute("person", person);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listperson.jsp");
				rd.forward(req, resp);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				q.closeAll();
				pm.close();
			}
					
	
				
				
			
			
	}

}
