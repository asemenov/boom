package ru.asemenov.boom.common;

import ru.asemenov.boom.publisher.PublisherData;

import java.time.LocalDate;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

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

    private static final String[] PSEUDONYMS_SUBJECT = {
            "Lobo", "Gato", "Oso", "Hombre"
    };

    private static final String[] PSEUDONYMS_ADJECTIVE = {
            "Justo", "Negro", "Rojo", "Solitario", "Azul", "Lento"
    };

    private static final String[] FAMILY_NAMES = {
            "Vasquez", "Rodriquez", "Pérez", "Gonzalez",
            "Sanchez", "Oliveira", "Iñárritu", "Díaz",
            "Garcia", "Iglesias", "Rajoy", "Ojeda",
            "Buendia", "Rivera", "Martinez"};

    private static final String[] SKILLS = {"invisibility", "thunderstorm", "rain", "snow", "flash"};

    private static String next(String[] array) {
        return array[RANDOM.nextInt(array.length)];
    }

    public static String newName() {
        return next(NAMES) + " " + next(FAMILY_NAMES) + " " + nextNumeric(4) + "-" + nextNumeric(6);
    }

    public static String nextNumeric(int length) {
        String result = "";

        for (int i = 0; i < length; i++) {
            result += RANDOM.nextInt(10);
        }

        return result;
    }

    public static String newPseudonym() {
        return "Un " + next(PSEUDONYMS_SUBJECT) + " " + next(PSEUDONYMS_ADJECTIVE);
    }

    public static PublisherData newPublisher() {
        final PublisherData data = new PublisherData();

        data.setName("Independent publisher " + nextNumeric(12));

        return data;
    }

    public static String anyDate() {
        return LocalDate.ofEpochDay(LocalDate.now().toEpochDay() - RANDOM.nextInt(3600)).format(ISO_LOCAL_DATE);
    }

    public static String anySkill() {
        return next(SKILLS);
    }
}
