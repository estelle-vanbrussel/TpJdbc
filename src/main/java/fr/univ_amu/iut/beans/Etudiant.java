package fr.univ_amu.iut.beans;

public class Etudiant {
	private int numEt;
	private String nomEt;
	private String prenomEt;
	private String cpEt;
	private String villeEt;
	
	private int annee;
	private int groupe;

	public Etudiant() {
	}
	
	public Etudiant(int numEt, String nomEt, String prenomEt, String cpEt,
			String villeEt, int annee, int groupe) {
		this.numEt = numEt;
		this.nomEt = nomEt;
		this.prenomEt = prenomEt;
		this.cpEt = cpEt;
		this.villeEt = villeEt;
		this.annee = annee;
		this.groupe = groupe;
	}

	public int getAnnee() {
		return annee;
	}

	public String getCpEt() {
		return cpEt;
	}

	public int getGroupe() {
		return groupe;
	}

	public String getNomEt() {
		return nomEt;
	}

	public int getNumEt() {
		return numEt;
	}

	public String getPrenomEt() {
		return prenomEt;
	}

	public String getVilleEt() {
		return villeEt;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public void setCpEt(String cpEt) {
		this.cpEt = cpEt;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public void setNomEt(String nomEt) {
		this.nomEt = nomEt;
	}

	public void setNumEt(int numEt) {
		this.numEt = numEt;
	}

	public void setPrenomEt(String prenomEt) {
		this.prenomEt = prenomEt;
	}

	public void setVilleEt(String villeEt) {
		this.villeEt = villeEt;
	}

	@Override
	public String toString() {
		return "Etudiant [numEt=" + numEt + ", "
				+ (nomEt != null ? "nomEt=" + nomEt + ", " : "")
				+ (prenomEt != null ? "prenomEt=" + prenomEt + ", " : "")
				+ (cpEt != null ? "cpEt=" + cpEt + ", " : "")
				+ (villeEt != null ? "villeEt=" + villeEt + ", " : "")
				+ "annee=" + annee + ", groupe=" + groupe + ", "
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Etudiant etudiant = (Etudiant) o;

		if (numEt != etudiant.numEt) return false;
		if (annee != etudiant.annee) return false;
		if (groupe != etudiant.groupe) return false;
		if (!nomEt.equals(etudiant.nomEt)) return false;
		if (!prenomEt.equals(etudiant.prenomEt)) return false;
		if (!cpEt.equals(etudiant.cpEt)) return false;
		return villeEt.equals(etudiant.villeEt);
	}

	@Override
	public int hashCode() {
		int result = numEt;
		result = 31 * result + nomEt.hashCode();
		result = 31 * result + prenomEt.hashCode();
		result = 31 * result + cpEt.hashCode();
		result = 31 * result + villeEt.hashCode();
		result = 31 * result + annee;
		result = 31 * result + groupe;
		return result;
	}
}
