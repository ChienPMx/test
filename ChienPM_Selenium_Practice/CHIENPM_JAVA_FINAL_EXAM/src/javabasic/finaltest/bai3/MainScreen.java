package javabasic.finaltest.bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainScreen {
    public static void main(String[] args) {
        // a.	Sử dụng vòng lặp WHILE (hoặc DO…WHILE) để nhập thông tin Employee từ bàn phím.
        // Sau mỗi lần nhập in ra thông báo: Dou you want to continue (Y/N)?. Nếu người dùng nhập Y thì chương trình tiếp tục cho nhập Employee,
        // nếu người dùng nhập N thì dừng nhập Employee.
        // Sử dụng mảng ArrayList để tạo danh sách lưu các Employee vừa nhập
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        String continueEmp;
        do {
            Employee employee = new Employee();
            System.out.print("Nhập Fullname: ");
            employee.setFullName(sc.nextLine());
            System.out.print("Nhập Age: ");
            employee.setAge(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập DOB: ");
            employee.setDob(sc.nextLine());
            System.out.print("Nhập Level: ");
            employee.setLevel(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập Salary: ");
            employee.setSalary(sc.nextFloat());
            sc.nextLine();
            employeeList.add(employee);
            System.out.print("Do you want to continue (Y/N)?");
            continueEmp = sc.nextLine();
        } while (continueEmp.equalsIgnoreCase("Y"));

        // b. In ra tất cả Employee trong danh sách
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("  Fullname: " + emp.getFullName());
            System.out.println("  Age: " + emp.getAge());
            System.out.println("  DOB: " + emp.getDob());
            System.out.println("  Level: " + emp.getLevel());
            System.out.println("  Salary: " + emp.getSalary());
        }
        //  c.	Sử dụng vòng lặp FOR để in ra danh sách vừa nhập. Xét salary:
        //	Nếu: Salary < 10.000 thì in ra  <fullName> co mức lương thấp <salary>
        //	Nếu  10.000 <= salary < 20.000 in ra  <fullName> co mức lương trung bình <salary>
        //	Nếu salary >= 20.000 in ra  <fullName> co mức lương cao <salary>

        for (Employee emp : employeeList) {
            if (emp.getSalary() < 10000) {
                System.out.println(emp.getFullName() + " có mức lương thấp " + emp.getSalary());
            } else if (emp.getSalary() >= 10000 && emp.getSalary() < 20000) {
                System.out.println(emp.getFullName() + " có mức lương trung bình " + emp.getSalary());
            } else {
                System.out.println(emp.getFullName() + " có mức lương cao " + emp.getSalary());
            }
        }
        // d.	Tính tổng lương trung bình
        float tongLuong = 0;
        float tongLuongTB = 0;
        for (Employee emp : employeeList) {
            tongLuong+=emp.getSalary();
            tongLuongTB = tongLuong/employeeList.size();
        }
        System.out.println("Tổng lương trung bình: "+ tongLuongTB);
        sc.close();
    }
}
