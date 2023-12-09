// Package contenant la classe Aviary
package org.example.enclosure;

// Importation des classes et interfaces nécessaires
import org.example.Cleanliness;
import org.example.Creature;
import org.example.Enclosure;
import org.example.interfaces.FlyingCreature;

import java.util.List;

// Déclaration de la classe Aviary qui étend Enclosure
public class Aviary extends Enclosure {
    // Attribut spécifique à la classe Aviary
    private double height;

    // Constructeur de la classe Aviary
    public Aviary(String name, double area, int maxCapacity, List<Creature> creatures, Cleanliness cleanliness,
                  double height) {
        super(name, area, maxCapacity, cleanliness);
        this.height = height;
    }

    // Méthode pour ajouter une créature à la volière
    @Override
    public void addCreature(Creature creature) {
        // Vérification que la créature est une créature volante avant de l'ajouter
        if (!(creature instanceof FlyingCreature)) {
            System.out.println("Seules les créatures volantes peuvent être ajoutées à une volière.");
            return;
        }
        super.addCreature(creature); // Appel de la méthode de la classe mère pour ajouter la créature
    }

    // Méthode de maintenance de l'enclos, surchargeant la méthode de la classe mère
    @Override
    public void maintainEnclosure() {
        super.maintainEnclosure(); // Appel de la méthode de la classe mère
        checkRoof(); // Vérification du toit

        setCleanliness(Cleanliness.BON); // Définition de la propreté à un niveau optimal

        System.out.println("La volière a été entretenue et son toit vérifié.");
    }

    // Méthode privée pour vérifier l'état du toit de la volière
    private void checkRoof() {
        System.out.println("Le toit de la volière a été vérifié et est en bon état.");
    }

    // Méthode getter pour la hauteur de la volière
    public double getHeight() {
        return height;
    }

    // Méthode setter pour la hauteur de la volière
    public void setHeight(double hei
