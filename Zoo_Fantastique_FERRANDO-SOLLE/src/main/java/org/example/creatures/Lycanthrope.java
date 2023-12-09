// Package contenant la classe Lycanthrope
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.ZooKeeper;
import org.example.interfaces.*;

// Déclaration de la classe Lycanthrope qui étend Creature et implémente les interfaces Run et Viviparous
public class Lycanthrope extends Creature implements Run, Viviparous {

    // Attributs spécifiques à la classe Lycanthrope
    private String gender;
    private String ageCategory;
    private int strength;
    private int dominationFactor;
    private char rank;
    private int level;
    private int impetuosity;
    private Pack pack;

    // Constructeur de la classe Lycanthrope
    public Lycanthrope(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce du Lycanthrope
        this.setSpecies("Lycanthrope");
    }

    // Méthode pour afficher les caractéristiques du Lycanthrope
    public void displayCharacteristics() {
        super.displayInfo(); // Appel de la méthode displayInfo() de la classe mère
        System.out.println("Sexe: " + gender);
        System.out.println("Catégorie d'âge: " + ageCategory);
        System.out.println("Force: " + strength);
        System.out.println("Facteur de domination: " + dominationFactor);
        System.out.println("Rang: " + rank);
        System.out.println("Niveau: " + level);
        System.out.println("Impétuosité: " + impetuosity);
        System.out.println("Meute: " + (pack != null ? pack.getName() : "Solitaire"));
    }

    // Méthode pour produire le cri du Lycanthrope
    public void cries() {
        System.out.println(this.getName() + " hurle." + this.getCries());
    }

    // Méthode getter pour la catégorie d'âge
    public String getAgeCategory() {
        return ageCategory;
    }

    // Méthode setter pour la catégorie d'âge
    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    // Méthode getter pour la force
    public int getStrength() {
        return strength;
    }

    // Méthode setter pour la force
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Méthode getter pour le facteur de domination
    public int getDominationFactor() {
        return dominationFactor;
    }

    // Méthode setter pour le facteur de domination
    public void setDominationFactor(int dominationFactor) {
        this.dominationFactor = dominationFactor;
    }

    // Méthode getter pour le rang
    public char getRank() {
        return rank;
    }

    // Méthode setter pour le rang
    public void setRank(char rank) {
        this.rank = rank;
    }

    // Méthode getter pour le niveau
    public int getLevel() {
        return level;
    }

    // Méthode setter pour le niveau
    public void setLevel(int level) {
        this.level = level;
    }

    // Méthode getter pour l'impétuosité
    public int getImpetuosity() {
        return impetuosity;
    }

    // Méthode setter pour l'impétuosité
    public void setImpetuosity(int impetuosity) {
        this.impetuosity = impetuosity;
    }

    // Méthode getter pour la meute à laquelle appartient le Lycanthrope
    public Pack getPack() {
        return pack;
    }

    // Méthode pour entendre un hurlement
    public String hearHowl() {
        if (!this.isSleeping() && this.isAlive()) {
            System.out.println(this.getName() + " entend un hurlement.");
        }
        return this.getName() + " entend un hurlement.";
    }

    // Méthode pour quitter la meute
    public void leavePack() {
        if (this.pack != null) {
            this.pack.removeMember(this);
            this.pack = null;
            System.out.println(this.getName() + " a quitté la meute.");
        }
    }

    // Méthode pour se transformer en humain
    public String transformIntoHuman() {
        System.out.println(this.getName() + " se transforme en humain.");
        new ZooKeeper(this.getName(), this.getGender(), this.getAge()); // Création d'un ZooKeeper
        return this.getName() + " se transforme en humain.";
    }

    // Implémentation de la méthode run() de l'interface Run
    @Override
    public void run() {
        System.out.println(this.getName() + " court rapidement.");
    }

    // Implémentation de la méthode getGender() de l'interface Viviparous
    @Override
    public String getGender() {
        return gender;
    }

    // Implémentation de la méthode setGender() de l'interface Viviparous
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Méthode setter pour la meute à laquelle appartient le Lycanthrope
    public void setPack(Pack pack) {
        this.pack = pack;
    }
}
