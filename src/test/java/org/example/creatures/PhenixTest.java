package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhenixTest {


    @Test
    void displayCharacteristics() {
        Phenix phenix = new Phenix("Phenix", "Femelle", 100, 50, 100, 50, "SHIIIII");
        assertEquals("Phenix", phenix.getName());
        assertEquals("Femelle", phenix.getGender());
        assertEquals(100, phenix.getWeight());
        assertEquals(100, phenix.getHeight());
        assertEquals(100, phenix.getAge());
        assertEquals(100, phenix.getHealth());
        assertEquals("Grrrrr", phenix.getCries());
        assertEquals("Phenix", phenix.getSpecies());
    }
    @Test
    void fly() {
        Phenix phenix = new Phenix("Phenix", "Male", 50, 100, 50, 100, "SHIIIII");
        assertEquals("Le Phenix s'élève dans les airs.", phenix.fly());
    }
}