package one.gym.surface;
import one.gym.underground.KindOfPerson;
import one.gym.underground.Link;
import one.gym.underground.Resource;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.Query;
@SuppressWarnings("serial")
public class RegKindOfPerson extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final KindOfPerson p = new KindOfPerson(name, description);
		final Query q = pm.newQuery(Resource.class);
		try{
			@SuppressWarnings("unchecked")
			List<Resource> resource = (List<Resource>) q.execute();
			for(Resource c: resource){
				//long idr = c.getId().getId();
				//Link r = pm.getObjectById(Link.class, String.valueOf(c.getId().getId()));
				
				Link e = new Link(String.valueOf(c.getId().getId()),c.getKind() );
				p.getPermision().add(e);
			}
			pm.makePersistent(p);
			resp.getWriter().println("Tipo de Persona grabada correctamente.");
			resp.sendRedirect("/listkoperson");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/registerKindOfPerson.jsp");
		}finally{
			pm.close();
		}
	}

}
