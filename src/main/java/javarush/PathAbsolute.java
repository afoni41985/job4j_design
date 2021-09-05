package javarush;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathAbsolute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Path.of(str);
        Path rsl;
        if (!path.isAbsolute()) {
            rsl = path.toAbsolutePath();
            System.out.println(rsl);
        } else {
            System.out.println(path);
        }
    }
}
