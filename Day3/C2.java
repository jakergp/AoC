import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class C2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("sample.txt");
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
                if (string[i] == '*') {

                }
                i++;
            }

        }
        System.out.println(sum);
    }

    public static StringBuilder searchNums(int i, char[] string) {
        StringBuilder number = new StringBuilder();
        C1.searchNumbers(string, i, number);
        return number;
    }
}
