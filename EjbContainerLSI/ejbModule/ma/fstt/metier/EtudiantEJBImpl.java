package ma.fstt.metier;

import java.util.List;




import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.fstt.entities.Etudiant;


@Stateless
@LocalBean
public class EtudiantEJBImpl implements EtudiantLocal,EtudiantRemote {
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Etudiant addEtudiant(Etudiant e) {
		em.persist(e);
		return e;
	}

	@Override
	public Etudiant getEtudiant(int id) {
		// TODO Auto-generated method stub
		return em.find(Etudiant.class, id);
	}

	@Override
	public List<Etudiant> listEtudiants() {
		// TODO Auto-generated method stub
		return  em.createQuery("select a from Etudiant a").getResultList();
	}

	@Override
	public void supprimerEtudiant(int id) {
		Etudiant e= em.find(Etudiant.class, id);
		
		em.remove(e);
		
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return em.merge(e);
	}

}
