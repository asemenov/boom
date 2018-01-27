package ru.asemenov.boom.common;

import java.util.Random;

/**
 * @author a.semenov
 */
public class TestDataGenerator {
    private static final Random RANDOM = new Random();

    private static final String[] NAMES = {
            "Jose", "Jesus", "Dolores", "Pedro", "Susana",
            "Maria", "Javier", "Alejandro", "Álvaro",
            "Raul", "Andre", "Ángel", "Pablo", "Alexis",
            "Aurelio", "Fabio", "Juan", "Gorge", "Mariano"};


    private static final String[] FAMILY_NAMES = {
            "Vasquez", "Rodriquez", "Pérez", "Gonzalez",
            "Sanchez", "Oliveira", "Iñárritu", "Díaz",
            "Garcia", "Iglesias", "Rajoy", "Ojeda",
            "Buendia", "Rivera", "Martinez"};

    private static String next(String[] array) {
        return array[RANDOM.nextInt(array.length)];
    }

    public static String newName() {
        return next(NAMES) + " " + next(FAMILY_NAMES) + " " + nextNumeric(4) + "-" + nextNumeric(6);
    }

    private static String nextNumeric(int length) {
        String result = "";

        for (int i = 0; i < length; i++) {
            result += RANDOM.nextInt(10);
        }

        return result;
    }
}
