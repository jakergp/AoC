import java.io.*;
import java.util.*;

public class C1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("engine.txt");
        Scanner lineScanner = new Scanner(fis);
        ArrayList<String> lines = new ArrayList<>();

        while(lineScanner.hasNext()) {
            lines.add(lineScanner.nextLine());
        }

        int sum = 0;
        for(int counter = 0; counter < lines.size(); counter++) {
            char[] string = lines.get(counter).toCharArray();
            char[] previousLine, nextLine;
            StringBuilder number = new StringBuilder();
            int i = 0;
            while(i < string.length){
                i = searchNumbers(string, i, number);
                if(!number.isEmpty()) {
                    int previous = i - number.length() - 1;
                    System.out.println(i);
                    if (i >= 0 && i < string.length && string[i] != '.' ||
                            previous >= 0 && string[previous] != '.') {
                        sum += Integer.parseInt(number.toString());
                        System.out.println(number);
                    }
                    else {
                        boolean done = false;
                        if(counter - 1 >= 0) {
                            previousLine = lines.get(counter - 1).toCharArray();
                            for(int j = previous; j <= i; j++) {
                                if(j >= 0 && j < previousLine.length) {
                                    if(previousLine[j] != '.' && !Character.isDigit(previousLine[j])) {
                                        sum += Integer.parseInt(number.toString());
                                        System.out.println(number);
                                        done = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if(counter + 1 < lines.size() && !done) {
                            nextLine = lines.get(counter + 1).toCharArray();
                            for(int j = previous; j <= i; j++) {
                                if(j >= 0 && j < nextLine.length) {
                                    if(nextLine[j] != '.' && !Character.isDigit(nextLine[j])) {
                                        sum += Integer.parseInt(number.toString());
                                        System.out.println(number);
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
                number = new StringBuilder();
                i++;
            }

        }
        System.out.println(sum);
    }

    public static int searchNumbers (char[] string, int i, StringBuilder number) {
        if (Character.isDigit(string[i])){
            number.append(string[i]);
            if (i + 1 < string.length)
                return searchNumbers(string, i + 1, number);
            if (i == string.length - 1)
                return i + 1;
        }
        return i;
    }


}
