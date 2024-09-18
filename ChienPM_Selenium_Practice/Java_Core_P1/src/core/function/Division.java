package core.function;

public class Division {
    public double doDivision(double a, double b, double c) {
        Multiplication multiplication = new Multiplication();
        double result = multiplication.nhanHaiSo(a, b);
        return result / c;
    }
}