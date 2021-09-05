package javarush;

import java.nio.file.Path;
import java.util.Scanner;

public class PathRelative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        Path path1 = Path.of(str1);
        Path path2 = Path.of(str2);
        try {
            Path rsl1 = path1.relativize(path2);
            Path rsl2 = path2.relativize(path1);
            if (!rsl1.toString().endsWith("...")) {
                System.out.println(rsl1);
            } else {
                System.out.println(rsl2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Path rsl2 = path2.relativize(path1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


