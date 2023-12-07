import java.io.*;
import java.util.*;

public class C2 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: C1 <filename>");
        } else {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner lines = new Scanner(fis);
            int[] powers = new int[100];
            Arrays.fill(powers, 1);
            int counter = 0;

            while (lines.hasNextLine()) {
                String line = lines.nextLine();
                Scanner words = new Scanner(line);
                int wordCounter = 0;
                int maxRed = 0, maxBlue = 0, maxGreen = 0;
                while (words.hasNext()) {
                    String word = words.next();
                    if (wordCounter > 1) {
                        if (C1.isNumeric(word)) {
                            String colorC = words.next();
                            String color = colorC.split(";")[0].split(",")[0];
                            int number = Integer.parseInt(word);
                            switch (color) {
                                case "red":
                                    if (number > maxRed) {
                                        maxRed = number;
                                    }
                                    break;
                                case "green":
                                    if (number > maxGreen) {
                                        maxGreen = number;
                                    }
                                    break;
                                case "blue":
                                    if (number > maxBlue) {
                                        maxBlue = number;
                                    }
                                    break;
                            }

                        }
                    }
                    wordCounter++;
                }
                System.out.println(maxRed + " " + maxGreen + " " + maxBlue);
                powers[counter] = maxRed * maxGreen * maxBlue;
                counter++;
            }

            int sum = 0;

            for (int game : powers) {
                System.out.println(game);
                sum += game;
            }

            System.out.println("Suma: " + sum);
        }
    }

}
