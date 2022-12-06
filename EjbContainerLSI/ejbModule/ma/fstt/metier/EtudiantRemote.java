package ma.fstt.metier;

import java.util.List;

import jakarta.ejb.Remote;
import ma.fstt.entities.Etudiant;

@Remote
public interface EtudiantRemote {
	public Etudiant addEtudiant(Etudiant e);
	public Etudiant getEtudiant(int id);
	public List<Etudiant> listEtudiants();
	public void supprimerEtudiant(int id);
	public Etudiant updateEtudiant(Etudiant e);
}
