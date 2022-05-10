package tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        FileWriter fw = new FileWriter("input.txt");
        fw.write(str);
        fw.close();
    }
}
