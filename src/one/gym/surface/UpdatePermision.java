package one.gym.surface;
import one.gym.underground.KindOfPerson;
import one.gym.underground.Link;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UpdatePermision extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		//HttpSession misesion = req.getSession();
		
		//if(misesion.getAttribute("nombre")!=null){}
		
		
		String ids = req.getParameter("idm");
		long id = Long.parseLong(ids);
		//final PersistenceManager pm = PMF.get().getPersistenceManager();
		String C = req.getParameter("activec");
		String R = req.getParameter("activer");
		String U = req.getParameter("activeu");
		String D = req.getParameter("actived");
		String kop = req.getParameter("id");
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		//final Person p = new Person(name, surname, email, address, birthday, active, kind);
		try{
			KindOfPerson koperson = pm.getObjectById(KindOfPerson.class, id);
			if(koperson.getPermision().isEmpty()){
				Link a = new Link(kop, Boolean.parseBoolean(C), Boolean.parseBoolean(R), Boolean.parseBoolean(U), Boolean.parseBoolean(D));
				koperson.getPermision().add(a);
			}else{
				ArrayList<Link> l = new ArrayList<Link>(koperson.getPermision());
				for(int i=0; i<l.size(); i++){
						if(l.get(i).getName().equals(kop)){
							System.out.println(l.get(i).getName());
							System.out.println(kop);
							System.out.println(C+"/"+R+"/"+U+"/"+D);
							l.get(i).setC(Boolean.parseBoolean(C));
							l.get(i).setR(Boolean.parseBoolean(R));
							l.get(i).setU(Boolean.parseBoolean(U));
							l.get(i).setD(Boolean.parseBoolean(D));
						}else if(i==l.size()-1){
							Link a = new Link(kop, Boolean.parseBoolean(C), Boolean.parseBoolean(R), Boolean.parseBoolean(U), Boolean.parseBoolean(D));
							koperson.getPermision().add(a);
						}
					}
				
				
			}
			//pm.makePersistent(person);
			resp.getWriter().println("Persona grabada correctamente.");
			resp.sendRedirect("/managepermitions");
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/regperson");
		}finally{
			pm.close();
		}
	}
}

