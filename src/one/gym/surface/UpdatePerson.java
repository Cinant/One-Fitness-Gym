package one.gym.surface;
import one.gym.underground.Person;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UpdatePerson extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		//HttpSession misesion = req.getSession();
		
		//if(misesion.getAttribute("nombre")!=null){}
		
		
		String ids = req.getParameter("key");
		long id = Long.parseLong(ids);
		//final PersistenceManager pm = PMF.get().getPersistenceManager();
		String name = req.getParameter("name");
		String surname = req.getParameter("surName");
		String email = req.getParameter("mail");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String bactive = req.getParameter("active");
		boolean active;
		if(bactive.equals("si"))active = true;
		else active = false;
		//ing kind= req.getParameter("koperson");
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		//final Person p = new Person(name, surname, email, address, birthday, active, kind);
		try{
			Person person = pm.getObjectById(Person.class, id);
			person.setAddress(address);
			person.setBirthday(birthday);
			person.setMail(email);
			person.setActive(active);
			person.setName(name);
			person.setSurName(surname);
			//pm.makePersistent(person);
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

