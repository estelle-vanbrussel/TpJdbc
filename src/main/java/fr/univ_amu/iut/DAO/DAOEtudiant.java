package fr.univ_amu.iut.DAO;


import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.util.List;

public interface DAOEtudiant extends DAO<Etudiant> {


    int computeNbEtudiant();
    List<Etudiant> findByAnnee(int annee);
    List<Etudiant> findByGroupe(int groupe);
    List<Etudiant> findByNom(String nomEt);
    boolean delete(Etudiant obj);
    List<Etudiant> FindAll();
    Etudiant getById(int id);
    Etudiant insert(Etudiant obj);
    boolean update(Etudiant obj);
}