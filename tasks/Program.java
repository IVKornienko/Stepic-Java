package tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        String str = sc.nextLine();
        fr.close();

        String[] s = str.split(" ");
        double a = 0, b = 0, result = 0;
        String resultString = "";

        try {
            a = Double.parseDouble(s[0]);
            b = Double.parseDouble(s[2]);
            switch (s[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        resultString = "Error! Division by zero";
                        break;
                    }
                    result = a / b;
                    break;
                default:
                    resultString = "Operation Error!";
                    break;
            }
            if (resultString.isEmpty())
                resultString = String.valueOf(result);
        } catch (Exception e) {
            resultString = "Error! Not number";
        }

        FileWriter fw = new FileWriter("output.txt");
        fw.write(str + " = " + resultString);
        fw.close();
    }
}
