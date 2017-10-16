package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.ConnexionUnique;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEtudiantJDBC implements DAOEtudiant {
    @Override
    public int computeNbEtudiant() {
        int nbEtudiants = 0;
        String req = "SELECT COUNT * FROM ETUDIANT";
        System.out.println("Connexion ");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            nbEtudiants = rset.getInt("COUNT * ");
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return nbEtudiants;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        String req = "SELECT * FROM ETUDIANT WHERE ANNEE = ?";
        System.out.println("Connexion ");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,annee);
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = pstmt.executeQuery();

            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            pstmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        String req = "SELECT * FROM ETUDIANT WHERE GROUPE = ?";
        System.out.println("Connexion ");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,groupe);
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = pstmt.executeQuery();

            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            pstmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        String req = "SELECT * FROM ETUDIANT WHERE NOM_ET = ?";
        System.out.println("Connexion ");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1,nomEt);
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = pstmt.executeQuery();

            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            pstmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public boolean delete(Etudiant obj) {
        String req = "DELETE FROM ETUDIANT WHERE NUM_ET=" + obj.getNumEt();
        System.out.println("Connexion ");
        boolean delete = false;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            int rset = stmt.executeUpdate(req);
            if (rset == 1) delete=true;
            // Affichage du resultat
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return delete;
    }

    @Override
    public List<Etudiant> FindAll() {
        String req = "SELECT * FROM ETUDIANT";
        System.out.println("Connexion ");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement pstmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = pstmt.executeQuery(req);

            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            pstmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public Etudiant getById(int id) {
        String req = "SELECT * FROM ETUDIANT WHERE NUM_ET=?";
        System.out.println("Connexion ");
        Etudiant etudiant = new Etudiant();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1,id);
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = pstmt.executeQuery();

            // Affichage du resultat

                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));

            // Fermeture de l'instruction (liberation des ressources)
            pstmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiant;
    }

    @Override
    public Etudiant insert(Etudiant obj) {
        String req = "INSERT INTO ETUDIANT(NUM_ET,NOM_ET,PRENOM_ET,CP_ET,VILLE_ET,ANNEE,GROUPE) VALUES(" +obj.getNumEt()+ "," +obj.getNomEt() +","+ obj.getPrenomEt()+","+obj.getCpEt()+","+obj.getVilleEt()+","+obj.getAnnee()+","+obj.getGroupe()")"
        System.out.println("Connexion ");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            int rset = stmt.executeUpdate(req);
            // Affichage du resultat
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return obj;
    }

    @Override
    public boolean update(Etudiant obj) {
        String req = "UPDATE ETUDIANT SET NUM_ET=" + obj.getNumEt() +" AND NOM_ET=" + obj.getNomEt() + " AND PRENOM_ET=" + obj.getPrenomEt() + " AND CP_ET=" + obj.getCpEt() + " AND VILLE_ET=" + obj.getVilleEt() + " AND ANNEE=" + obj.getAnnee() +" AND GROUPE=" + obj.getGroupe();
        System.out.println("Connexion ");
        boolean update = false;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            int rset = stmt.executeUpdate(req);
            if (rset == 1) update=true;
            // Affichage du resultat
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return update;
    }
}
