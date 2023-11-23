package fr.it_akademy.motus.dasha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.it_akademy.motus.dasha.business.Mot;

public class App {
    public static List<Mot> mots = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenue sur Motus !");
        System.out.println("Nombre de mots à 7 chiffres : 9607");

        // Les phases principales du projet
        // methode url qui lit tous les mots de la base
        listeDesMots();
        // System.out.println(mots);
        // methode qui rajoute la liste de tous les mots dans un tablea

        // methode qui compte tous les mots du tableau
        // boucle for avec l'incrementation de 6 pour 6 essais
        // methode sort by chronologie
        // methode sort by alphabet
    }

    // methode de recuperation des mots
    public static void listeDesMots() {
        try {
            URI uri = new URI("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire7.txt");
            URL url = URL.of(uri, null);
            // ouvrir url
            InputStream inputStream = url.openStream();
            // recuperer les données dans un nouvel objet
            InputStreamReader repository = new InputStreamReader(inputStream);
            // lire les données
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // initialiser une ligne
            String ligne = null;
            // tant que la ligne n'est pas vide, lire son contenu
            while ((ligne = reader.readLine()) != null) {
                // et ajouter dans le tableau mot par mot
                mots.add(new Mot(ligne));
            }
        } catch (MalformedURLException e) {
            System.out.println("URL incorrecte");
            // On décide d'arrêter l'application
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Problème réseau");
            // En cas de panne réseau, nous allons arriver ici
            System.exit(-1);
        } catch (URISyntaxException e) {
            System.out.println("Verifiez le lien");
            System.exit(-1);
        }

    }

    public static List<Mot> enregistrerLesMots(String nom) {
        List<Mot> motsEnregistres = new ArrayList<>();
        for (Mot mot : mots) {
            if (nom.equals(mot.getNom())) {
                motsEnregistres.add(mot);
                System.out.println(motsEnregistres);
            }
        }
        return mots;
    }

    //
    public static void algorithmeMotus() {
        // Jeu demarre avec l'annonce des nombre d'essais
        System.out.println("Vous avez 6 essais pour trouver le mot secret");
        // Générer un mot secret de 7 lettres
        String motSecret = genererMotSecret();
        // Initialiser le scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        // Boucle du jeu
        while (true) {
            System.out.println("Devinez le mot (7 lettres) : ");
            String proposition = scanner.nextLine();

            // Vérifier la proposition et afficher les indications
            verifierProposition(motSecret, proposition);

            // Vérifier si le joueur a trouvé le mot
            if (motSecret.equals(proposition)) {
                System.out.println("Bravo, vous avez trouvé le mot !");
                break;
            }
        }
        scanner.close();
    }

    private static String genererMotSecret() {
        // Sélectionner un mot au hasard
        Random random = new Random();
        Mot motAuHasard = new Mot();
        motAuHasard = mots.get(random.nextInt(mots.size()));
        return motAuHasard.toString();
    }

    private static void verifierProposition(String motSecret, String proposition) {
        for (int i = 0; i < motSecret.length(); i++) {
            char lettreMotSecret = motSecret.charAt(i);
            char lettreProposition = proposition.charAt(i);

            if (lettreMotSecret == lettreProposition) {
                System.out.print("X"); // Lettre bien placée
            } else if (motSecret.contains(String.valueOf(lettreProposition))) {
                System.out.print("O"); // Lettre présente mais mal placée
            } else {
                System.out.print("-"); // Lettre absente
            }
        }

        System.out.println();
    }
}
