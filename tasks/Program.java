package tasks;

import java.io.FileReader;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        String str = sc.nextLine();
        fr.close();

        System.out.println(str);
    }
}
