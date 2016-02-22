package com.okuklina.guitarJokes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class JokesLib {

    private static final ArrayList<String> JOKES_LIST = new ArrayList<String>();

    static {
//        String file = "assets/guitarjokes.txt";
//        InputStream in = JokesLib.class.getClassLoader().getResourceAsStream(file);
//        InputStreamReader reader = new InputStreamReader(in);
//        BufferedReader buffReader = new BufferedReader(reader);
//        String current = null;
//        StringBuilder joke = new StringBuilder();
//        try {
//            while ((current = buffReader.readLine()) != null) {
//                if (current.length() != 0) {
//                    joke.append(current);
//                } else {
//                    JOKES_LIST.add(joke.toString());
//                    joke.setLength(0);
//                }
//            }
//            if(joke.length() !=0) {
//                JOKES_LIST.add(joke.toString());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        JOKES_LIST.add(0,"Two jazz guitarists meet in a bar, and one says, “Yeah man, I bought your last album, it was awesome!” to which the other replies, “Oh so that was you!”.");

        JOKES_LIST.add(1,"What’s the difference between an electric guitar player and a vacuum cleaner?\n" +
                "When you unplug a vacuum cleaner it doesn’t suck anymore.”.");
        JOKES_LIST.add(2,"What’s the difference between a Fender and a Gretsch?\n" +
                "The Gretsch burns longer.");
        JOKES_LIST.add(3,"The fact that there’s a Highway To Hell but only a Stairway To Heaven says a lot about anticipated traffic numbers.");
        JOKES_LIST.add(4," What do you call a guitarist who breaks up with his girlfriend?\n" +
                "Homeless");
        JOKES_LIST.add(5,"How does a guitar player protect his Guitar from being stolen?\n" +
                "Store it in a bass case");
    }

    public String getJoke() {
        Random generateJoke = new Random();
        return JOKES_LIST.get(generateJoke.nextInt(JOKES_LIST.size()));
    }
}
