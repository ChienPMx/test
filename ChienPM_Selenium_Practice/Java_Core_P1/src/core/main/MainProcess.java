package core.main;
import core.function.Division;
import java.util.Scanner;

public class MainProcess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số a: ");
        double a = scanner.nextDouble();

        System.out.println("Nhập vào số b: ");
        double b = scanner.nextDouble();

        System.out.println("Nhập vào số c: ");
        double c = scanner.nextDouble();

        Division division = new Division();
        double result = division.doDivision(a, b, c);

        System.out.println("Kết quả của phép chia là: " + result);
    }
}
