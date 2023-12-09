package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegalodonsTest {

    @Test
    void displayCharacteristics() {
        Megalodons megalodons = new Megalodons("Megalodons", "Femelle", 50, 100, 50, 100, "AHRRRR");
        assertEquals("Megalodons", megalodons.getName());
        assertEquals("Femelle", megalodons.getGender());
        assertEquals(100, megalodons.getWeight());
        assertEquals(100, megalodons.getHeight());
        assertEquals(100, megalodons.getAge());
        assertEquals(100, megalodons.getHealth());
        assertEquals("Grrrrr", megalodons.getCries());
        assertEquals("Megalodons", megalodons.getSpecies());
    }

    @Test
    void swim() {
        Megalodons megalodons = new Megalodons("Megalodons", "Male", 100, 50, 100, 50, "AHRRRR");
        assertEquals("Le Megalodon se déplace puissamment dans l'eau.", megalodons.swim());
    }







}