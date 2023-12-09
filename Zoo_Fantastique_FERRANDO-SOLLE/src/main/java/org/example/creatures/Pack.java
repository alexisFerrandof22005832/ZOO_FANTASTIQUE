// Package contenant la classe Pack
package org.example.creatures;

// Importation des classes nécessaires
import java.util.ArrayList;
import java.util.List;

// Déclaration de la classe Pack
public class Pack {
    // Attributs de la classe Pack
    private String name;
    private Lycanthrope alphaMale;
    private Lycanthrope alphaFemale;
    private List<Lycanthrope> members;

    // Constructeur de la classe Pack
    public Pack(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    // Méthode pour ajouter un membre à la meute
    public void addMember(Lycanthrope lycanthrope) {
        if (!members.contains(lycanthrope)) {
            members.add(lycanthrope);
            lycanthrope.setPack(this);
        }
    }

    // Méthode pour retirer un membre de la meute
    public void removeMember(Lycanthrope lycanthrope) {
        if (members.remove(lycanthrope)) {
            lycanthrope.setPack(null);
        }
    }

    // Méthode pour définir le couple alpha de la meute
    public void setAlphaCouple(Lycanthrope male, Lycanthrope female) {
        this.alphaMale = male;
        this.alphaFemale = female;
    }

    // Méthode pour gérer la reproduction au sein de la meute
    public void reproduce() {
        // Logique de reproduction, potentiellement liée au couple α
    }

    // Méthode pour afficher les informations sur la meute
    public void displayPackInfo() {
        System.out.println("Meute dirigée par : " + alphaMale.getName() + " et " + alphaFemale.getName());
        System.out.println("Membres de la meute : ");
        for (Lycanthrope member : members) {
            member.displayCharacteristics();
        }
    }

    // Méthode pour gérer la domination et la soumission entre membres de la meute
    public void manageDomination(Lycanthrope dominator, Lycanthrope submissive) {
        // Gérer la domination et la soumission
    }

    // Méthode getter pour le nom de la meute
    public String getName() {
        return name;
    }

    // Méthode setter pour le nom de la meute
    public void setName(String name) {
        this.name = name;
    }

    // Méthode getter pour le mâle alpha
    public Lycanthrope getAlphaMale() {
        return alphaMale;
    }

    // Méthode setter pour le mâle alpha
    public void setAlphaMale(Lycanthrope alphaMale) {
        this.alphaMale = alphaMale;
    }

    // Méthode getter pour la femelle alpha
    public Lycanthrope getAlphaFemale() {
        return alphaFemale;
    }

    // Méthode setter pour la femelle alpha
    public void setAlphaFemale(Lycanthrope alphaFemale) {
        this.alphaFemale = alphaFemale;
    }

    // Méthode getter pour la liste des membres de la meute
    public List<Lycanthrope> getMembers() {
        return members;
    }

    // Méthode setter pour la liste des membres de la meute
    public void setMembers(List<Lycanthrope> members) {
        this.members = members;
    }
}
