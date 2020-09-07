package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static HashMap<String, Integer> readURLlookFor(ArrayList<String> words) throws Exception{

        URL cnn = new URL("https://www.dr.dk/nyheder/indland/aarhus-og-silkeborg-er-succeshistorien-om-faa-bugt-med-smitten-her-er-forklaringen");

        BufferedReader in = new BufferedReader(new InputStreamReader(cnn.openStream()));


        //dette map bruges til at have ét ord og integeren er hvor mange gange det er nævnt.
        //loopet tager alle ord vi har skrevet ind i vores array som vi vil tjekke efter, og sætter det ind i mappet med et default value af 0.
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String ss : words){
            hm.put(ss, Integer.valueOf(0));
        }

        String inputLine = ""; //hver linje der læses
        while(inputLine != null){
            System.out.println(inputLine);
            for (String ss : words){
                if(inputLine.indexOf(ss) > -1){ //dette går igennem hver linje og ser hvor mange gange ss (vores søgte ord) forekommer.
                    // den vil kun have nye eksempler så den looper -1 index,
                    // så den ikke finder et den har talt med allerede.
                    Integer ii = hm.get(ss); //så finder den vores integer i hashmappet og forøger den for hver gang det forekommer, og putter den derefter i hashmap igen.
                    ii++;
                    hm.put(ss,ii);
                }
            }
            inputLine = in.readLine();
        }

        in.close();
        return hm;

    }






    public static void main(String[] args) {
	// write your code here

        ArrayList<String> words = new ArrayList<>();
        words.add("corona");
        words.add("<div");
        words.add("dr");
        words.add("danmark");
        HashMap<String, Integer> hm1;
        try{
            hm1 = readURLlookFor(words);
            for( String sKey : hm1.keySet()){

                System.out.println("We found " + sKey + " " + hm1.get(sKey) + " times");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
