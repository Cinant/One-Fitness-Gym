package one.gym.surface;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.gym.underground.KindOfPerson;
import one.gym.underground.Person;
import one.gym.underground.Resource;

@SuppressWarnings("serial")
public class RemoveAll extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/plain");		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query p3 = pm.newQuery(Person.class);
		final Query p2 = pm.newQuery(Resource.class);
		final Query q = pm.newQuery(KindOfPerson.class);
			try{
				p3.deletePersistentAll();
				p2.deletePersistentAll();
				q.deletePersistentAll();
				resp.getWriter().println("Se han borrado personas y colores.");
				resp.sendRedirect("/");
			}catch(Exception e){
					System.out.println(e);
					resp.getWriter().println("No se han podido borrar datos.");
					resp.sendRedirect("/");
			}finally{
				q.closeAll();
				pm.close();
			}				
	}
}

