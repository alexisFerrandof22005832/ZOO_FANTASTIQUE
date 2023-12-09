package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @Test
    void fly() {
        // generate test dragon fly
        Dragon dragon = new Dragon("Dragon", "Male", 50, 100, 50, 100, "RRRRRR");
        assertEquals("Le Dragon s'envole dans les airs.", dragon.fly());
    }

    @Test
    void swim() {
        // generate test dragon swim
        Dragon dragon = new Dragon("Dragon", "Male", 100, 50, 100, 50, "RRRRRR");
        assertEquals("true", dragon.swim());
    }
}