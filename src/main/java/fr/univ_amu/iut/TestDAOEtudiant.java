package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v16005687 on 29/09/17.
 */
public class TestDAOEtudiant {
    static final String req = "SELECT * " +
            "FROM ETUDIANT ET, NOTATION NO " +
            "WHERE ET.NUM_ET = NO.NUM_ET";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion ");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            List<Etudiant> etudiants = new ArrayList<>();
            while (rset.next()){
                DAOEtudiant dao = new DAOEtudiantJDBC();
                Etudiant e = creerEtudiant(rset);
                e= dao.insert(e);
                etudiants.add(e);
            }

            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();

            for (Etudiant etudiant: etudiants) {
                System.out.println(etudiant);
            }

            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static Etudiant creerEtudiant(ResultSet rset) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setNumEt(rset.getInt("NUM_ET"));
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setGroupe(rset.getInt("GROUPE"));
        return etudiant;
    }
}
