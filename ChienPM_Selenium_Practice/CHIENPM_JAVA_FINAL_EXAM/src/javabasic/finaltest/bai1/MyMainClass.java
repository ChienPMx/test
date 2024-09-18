package javabasic.finaltest.bai1;

import java.util.Scanner;

public class MyMainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất x = ");
        double x = sc.nextDouble();
        System.out.println("Nhập số thứ hai y = ");
        double y = sc.nextDouble();
        System.out.println("Nhập lệnh ACTION = ");

        //Upper case de nhap gia tri thuong thi van hop le
        String action = sc.next();
        if (action.equalsIgnoreCase("CONG")){
            double result = MyUtilClass.tinhTong(x,y);
            System.out.print("Kết quả của phép cộng là: "+result);
        }
        else if (action.equalsIgnoreCase("NHAN")) {
            double result = MyUtilClass.tinhNhan(x, y);
            System.out.print("Kết quả của phép nhân là: "+result);
        }
        else {
            System.out.print("ACTION nên là CONG hoặc NHAN");
        }
        sc.close();
    }
}
