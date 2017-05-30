package one.gym.surface;
import one.gym.underground.Resource;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegResource extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String name = req.getParameter("name");
		String link = req.getParameter("link");
		String description = req.getParameter("description");
		String kind = req.getParameter("kind");
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Resource p = new Resource(name, link, kind, description);
		try{
			pm.makePersistent(p);
			resp.getWriter().println("Tipo de Persona grabada correctamente.");
			resp.sendRedirect("/listresource");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("regresource.jsp");
		}finally{
			pm.close();
		}
	}

}
