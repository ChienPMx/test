package javabasic.finaltest.bai2;

import java.util.Scanner;

public class MyLoopClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // hàm để không cho phép nhập n < 0.
        int n =0;
        do {
            System.out.print("Nhập một số bất kì n (n>=0): ");
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Vui lòng nhập lại (n>=0): ");
            }
        } while (n < 0);

        //        Trong package javabasic.finaltest.bai2
        //                -	Tạo một class có tên MyLoopClass
        //        -	Nhập vào một số bất kỳ từ bàn phím
        //        -	Tính tổng các số chẵn và tổng các số lẻ từ 0 đến số vừa nhập. In kết quả ra màn hình
        int tongChan = 0;
        int tongLe = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                tongChan += i;
            } else {
                tongLe += i;
            }
        }
        System.out.println("Tổng số chẵn từ 0 đến "+n+" là: " + tongChan);
        System.out.println("Tổng số chẵn từ 0 đến "+n+" là: " + tongLe);
        sc.close();
    }
}

