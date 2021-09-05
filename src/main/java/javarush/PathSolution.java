package javarush;
import java.nio.file.Path;
import java.util.Scanner;

/*
Зри в корень
*/

public class PathSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path rsl = Path.of(str);
        System.out.println(rsl.getRoot());
    }
}
