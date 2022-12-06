package ma.fstt.controller;

import java.util.List;
import java.util.Map;


import jakarta.ejb.EJB;

import jakarta.faces.context.FacesContext;
import ma.fstt.entities.Etudiant;
import ma.fstt.metier.EtudiantRemote;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;


@ManagedBean(name = "etudiantBean")
@RequestScoped
public class EtudiantBean {
	@EJB(mappedName="java:global/EjbContainerLSI/EtudiantEJBImpl!ma.fstt.metier.EtudiantRemote")
	private EtudiantRemote etudiantRemote;
	
	private  Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private String niveau;
	private String cne;
	
	public String nouveau() {
		return  "/faces/nouveau.xhtml";
	}
	
	public String save () {
		Etudiant e=new Etudiant();
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setAdresse(adresse);
		e.setNiveau(niveau);
		e.setCne(cne);
		etudiantRemote.addEtudiant(e);
		return  "/faces/index.xhtml";
	}
	
	public List<Etudiant> getAll(){
		return etudiantRemote.listEtudiants();
	}
	
	public String update(Etudiant e) {
		
		
		etudiantRemote.updateEtudiant(e);
		return "/faces/Etudiants.xhtml";
	}
	
	public String editer(Integer id) {
		Etudiant e = etudiantRemote.getEtudiant(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("etudiant", e);
		return "/faces/editer.xhtml";
	}


	
	public String supprimer(Integer id) {
		etudiantRemote.supprimerEtudiant(id);
		System.out.println("Etudiants supprime..");
		return "/faces/Etudiants.xhtml";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}
	

}
