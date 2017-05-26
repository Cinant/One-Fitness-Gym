package one.gym.surface;
import one.gym.underground.Person;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegPerson extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String email = req.getParameter("mail");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String bactive = req.getParameter("active");
		boolean active;
		if(bactive.equals("si"))active = true;
		else active = false;
		String kind= req.getParameter("koperson");
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Person p = new Person(name, surname, email, address, birthday, active, kind);
		try{
			pm.makePersistent(p);
			resp.getWriter().println("Persona grabada correctamente.");
			resp.sendRedirect("/listperson");
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/regperson");
		}finally{
			pm.close();
		}
	}
}
