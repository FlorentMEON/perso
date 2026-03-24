import java.util.*;
import java.io.*;

public class Monstrestock {

    private ArrayList<Entite> guerriers;

    public Monstrestock() {
        guerriers = new ArrayList<>();
    }




    public int getIndexKO() {
        for (int i = 0; i < guerriers.size(); i++) {
            Entite e = guerriers.get(i);
            if (e.getPointsDeVie() <= 0) {
                retirerGuerrier(i);
            }
        }
        return -1; // aucun KO trouvé
    }




    // Ajouter un guerrier
    public void ajouterGuerrier(Entite e) {
        guerriers.add(e);
        System.out.println(e.getNom() + " a été ajouté à la liste.");
    }
    public void ajouterGuerrierFirst(Entite e) {
        guerriers.add(e);
    }

    // Retirer un guerrier
    public void retirerGuerrier(Entite e) {
        if (guerriers.remove(e)) {
            System.out.println(e.getNom() + " a été retiré de votre liste,il est surement mort");
        } else {
            System.out.println("Impossible de retirer : guerrier introuvable.");
        }
    }

    // Retirer par index
    public void retirerGuerrier(int index) {
        if (index >= 0 && index < guerriers.size()) {
            Entite e = guerriers.remove(index);
            System.out.println(e.getNom() + " a été retiré de la liste.");
        } else {
            System.out.println("Index invalide.");
        }
    }

    // Obtenir un guerrier
    public Entite getGuerrier(int index) {
        if (index >= 0 && index < guerriers.size()) {
            return guerriers.get(index);
        }
        System.out.println("Index invalide.");
        return null;
    }

    // Afficher tous les guerriers


    public void afficherGuerriers() {
        System.out.println("=== Liste des guerriers ===");

        if (guerriers.isEmpty()) {
            System.out.println("Aucun guerrier enregistré.");
            return;
        }

        for (int i = 0; i < guerriers.size(); i++) {
            Entite e = guerriers.get(i);

            System.out.println(
                    "[" + i + "] " + e.getNom() +
                            " | PV : " + e.getPointsDeVie() + "/" + e.getPvmax() +
                            " | Armure : " + e.armure +
                            " | Dégâts : " + e.damage
            );
        }
    }



    // Taille de la liste
    public int taille() {
        return guerriers.size();
    }

    // Vérifier si vide
    public boolean estVide() {
        return guerriers.isEmpty();
    }



    public void loadFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Ignorer les lignes vides
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(";");

                if (data.length < 5) {
                    System.out.println("Ligne invalide : " + line);
                    continue;
                }

                String nom = data[0];
                int pvmax = Integer.parseInt(data[1]);
                int armure = Integer.parseInt(data[2]);
                int damage = Integer.parseInt(data[3]);
                String type = data[4].toLowerCase();

                Entite e;

                switch (type) {
                    case "goblin":
                        e = new goblin(nom, pvmax, armure, damage);
                        break;

                    case "monstre":
                        e = new Monstre(nom, pvmax, armure, damage);
                        break;

                    default:
                        System.out.println("Type inconnu : " + type + " → ligne ignorée");
                        continue;
                }

                ajouterGuerrierFirst(e);
            }

            System.out.println("Chargement terminé depuis : " + path);

        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du fichier : " + e.getMessage());
        }
    }
    public void saveToFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (Entite e : guerriers) {

                String type;

                // Détection du type
                if (e instanceof goblin) {
                    type = "goblin";
                } else if (e instanceof Monstre) {
                    type = "monstre";
                } else {
                    type = "entite";
                }

                // Format : Nom;PVmax;Armure;Damage;Type
                String line = e.getNom() + ";" +
                        e.getPvmax() + ";" +
                        e.getArmure() + ";" +
                        e.getDamage() + ";" +
                        type;

                bw.write(line);
                bw.newLine();
            }

            System.out.println("Sauvegarde effectuée dans : " + path);

        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}

