package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v16005687 on 25/09/17.
 */
public class TestAsso1 {
    // La requete de test
    static final String req = "SELECT * " +
            "FROM PROF ";

    static final String reqProf = "SELECT * " +
            "FROM PROF " +
            "WHERE PROF.NUM_PROF=?";

    static final String reqModule = "SELECT * " +
            "FROM MODULE " +
            "WHERE CODE=?";


    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion ");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req);
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            List<Prof> profs = new ArrayList<>();
            while (rset.next()){
                Prof prof = creerProf(rset);
                profs.add(prof);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();

            for (Prof prof: profs) {
                System.out.println(prof);
                System.out.println(prof.getMatSpec());
            }

            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static Prof creerProf(ResultSet rset2) throws SQLException {
        Prof prof = new Prof();
        prof.setNumProf(rset2.getInt("NUM_PROF"));
        prof.setNomProf(rset2.getString("NOM_PROF"));
        prof.setPrenomProf(rset2.getString("PRENOM_PROF"));
        prof.setAdrProf(rset2.getString("ADR_PROF"));
        prof.setVilleProf(rset2.getString("VILLE_PROF"));
        prof.setCpProf(rset2.getString("CP_PROF"));
        prof.setMatSpec(creerModule(rset2.getString("MAT_SPEC")));
        return prof;
    }

    private static Module creerModule(String code) throws SQLException {
        Connection conn = ConnexionUnique.getInstance().getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement(reqModule);
        preparedStmt.setString(1, code);
        ResultSet resultSet = preparedStmt.executeQuery();
        return creerModule(resultSet);
    }

     private static Prof  creerProf(int numProf) throws SQLException {
        Connection conn = ConnexionUnique.getInstance().getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement(reqProf);
        preparedStmt.setInt(1, numProf);
        ResultSet resultSet = preparedStmt.executeQuery();
        return creerProf(resultSet);
    }

    private static Module creerModule(ResultSet rset2) throws SQLException {
        Module MatSpec = new Module();
        MatSpec.setCode(rset2.getString("CODE"));
        MatSpec.setLibelle(rset2.getString("LIBELLE"));
        MatSpec.setCoefCc(rset2.getInt("COEFF_CC"));
        MatSpec.setCoefTest(rset2.getInt("COEFF_TEST"));
        MatSpec.setDiscipline(rset2.getString("DISCIPLINE"));
        MatSpec.sethCoursPrev(rset2.getInt("H_COURS_PREV"));
        MatSpec.sethCoursRea(rset2.getInt("H_COURS_REA"));
        MatSpec.sethTpPrev(rset2.getInt("H_TP_PREV"));
        MatSpec.sethTpRea(rset2.getInt("H_TP_REA"));
        MatSpec.setResponsable(creerProf(rset2.getInt("RESP")));
        MatSpec.setPere(creerModule(rset2.getString("CODEPERE")));
        return MatSpec;
    }

}
