package selenium.part1;

import java.util.Scanner;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        if (mauSo == 0) {
            throw new IllegalArgumentException("Phan so khong hop le");
        }
    }

    // method cong phan so
    public PhanSo cong(PhanSo b) {
        int newTuSo = this.tuSo * b.mauSo + b.tuSo * this.mauSo;
        int newMauSo = this.mauSo * b.mauSo;
        return new PhanSo(newTuSo, newMauSo).rutgon();
    }

    // method tru phan so
    public PhanSo tru(PhanSo b) {
        int newTuSo = this.tuSo * b.mauSo - b.tuSo * this.mauSo;
        int newMauSo = this.mauSo * b.mauSo;
        return new PhanSo(newTuSo, newMauSo).rutgon();
    }

    // method nhan phan so
    public PhanSo nhan(PhanSo b) {
        int newTuSo = this.tuSo * b.tuSo;
        int newMauSo = this.mauSo * b.mauSo;
        return new PhanSo(newTuSo, newMauSo).rutgon();
    }

    // method chia phan so
    public PhanSo chia(PhanSo b) {
        int newTuSo = this.tuSo * b.mauSo;
        int newMauSo = this.mauSo * b.tuSo;
        return new PhanSo(newTuSo, newMauSo).rutgon();
    }

    // method rut gon phan so
    public PhanSo rutgon() {
        int gcd = gcd(this.tuSo, this.mauSo);
        return new PhanSo(this.tuSo / gcd, this.mauSo / gcd);
    }

    // ucln
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // to string
    @Override
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap tu so phan so 1: ");
        int tuSo1 = scanner.nextInt();
        System.out.println("Nhap mau so phan so 1: ");
        int mauSo1 = scanner.nextInt();
        PhanSo ps1 = new PhanSo(tuSo1, mauSo1);

        System.out.println("Nhap tu so phan so 2: ");
        int tuSo2 = scanner.nextInt();
        System.out.println("Nhap mau so phan so 2: ");
        int mauSo2 = scanner.nextInt();
        PhanSo ps2 = new PhanSo(tuSo2, mauSo2);

        PhanSo tong = ps1.cong(ps2);
        PhanSo hieu = ps1.tru(ps2);
        PhanSo tich = ps1.nhan(ps2);
        PhanSo thuong = ps1.chia(ps2);

        System.out.println("Cong: " + ps1 + " + " + ps2 + " = " + tong);
        System.out.println("Tru: " + ps1 + " - " + ps2 + " = " + hieu);
        System.out.println("Nhan: " + ps1 + " * " + ps2 + " = " + tich);
        System.out.println("Chia: " + ps1 + " / " + ps2 + " = " + thuong);
    }
}



