package ma.fstt.metier;

import java.util.List;

import jakarta.ejb.Local;
import ma.fstt.entities.Etudiant;

@Local
public interface EtudiantLocal {
	public Etudiant addEtudiant(Etudiant e);
	public Etudiant getEtudiant(int id);
	public List<Etudiant> listEtudiants();
	public void supprimerEtudiant(int id);
	public Etudiant updateEtudiant(Etudiant e);
}
