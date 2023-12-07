package Day2;

import java.io.*;
import java.util.*;

public class C1 {
    public static void main(String[] args) throws FileNotFoundException{
        if (args.length != 1) {
            System.out.println("Usage: Day4.C1 <filename>");
        }
        else{
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner lines = new Scanner(fis);
            boolean[] possible = new boolean[100];
            Arrays.fill(possible, true);
            int counter = 0;

            while(lines.hasNextLine()) {
                String line = lines.nextLine();
                Scanner words = new Scanner(line);
                int wordCounter = 0;

                while(words.hasNext()) {
                    String word = words.next();
                    if (wordCounter > 1) {
                        if (isNumeric(word)) {
                            String colorC = words.next();
                            String color = colorC.split(";")[0].split(",")[0];
                            int number = Integer.parseInt(word);
                            int limit = determineLimit(color);

                            if(number > limit) {
                                possible[counter] = false;
                            }
                        }
                    }
                    wordCounter++;
                }
                counter++;
            }

            int id = 1;
            int sum = 0;

            for(boolean game: possible) {
                System.out.println(game);
                if (game) {
                    sum += id;
                }
                id++;
            }

            System.out.println("Suma: " + sum);
        }
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int determineLimit(String color) {
        return switch (color) {
            case "red" -> 12;
            case "green" -> 13;
            case "blue" -> 14;
            default -> 0;
        };
    }
}