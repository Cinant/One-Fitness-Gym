package one.gym.surface;
import one.gym.underground.KindOfPerson;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegKindOfPerson extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String name = req.getParameter("name");
		
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final KindOfPerson p = new KindOfPerson(name);
		try{
			pm.makePersistent(p);
			resp.getWriter().println("Tipo de Persona grabada correctamente.");
			resp.sendRedirect("/listkoperson");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("regKindOfperson.jsp");
		}finally{
			pm.close();
		}
	}

}
