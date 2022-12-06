package ma.fstt.metier;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.fstt.entities.Etudiant;


public class TestMe {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  "org.wildfly.naming.client.WildFlyInitialContextFactory");
		      jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming"
		);
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080"); 
		jndiProperties.put("jboss.naming.client.ejb.context",true);
		Context context;
		try {
			context = new InitialContext(jndiProperties);
			EtudiantRemote test = (EtudiantRemote) context.lookup("ejb:/EjbContainerLSI/EtudiantEJBImpl!ma.fstt.metier.EtudiantRemote");
			Etudiant e=new Etudiant();
			e.setAdresse("msala");
			e.setCne("k580333");
			e.setNiveau("A");
			e.setNom("jebbomur");
			e.setPrenom("hamzakka");
			test.addEtudiant(e);
			System.out.println(test.listEtudiants().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		     

	}

}





