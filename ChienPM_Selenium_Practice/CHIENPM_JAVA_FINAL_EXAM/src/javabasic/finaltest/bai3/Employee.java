package javabasic.finaltest.bai3;

public class Employee {
//    Tạo một class có tên: Employee với các thuộc tính
//    o fullName (kiểu String)
//    o age (kiểu int)
//    o dob (kiểu String dạng dd/mm/yyyy)
//    o level (kiểu double)
//    o salary (kiểu float)
    private String fullName;
    private int age;
    private String dob;
    private double level;
    private float salary;
// constructer
    public Employee(){

    }
    public Employee(String fullName, int age, String dob, double level, float salary){
        this.fullName = fullName;
        this.age = age;
        this.dob = dob;
        this.level = level;
        this.salary = salary;
    }
// Tạo các phương thức set, get cho các thuộc tính trên
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public void setLevel(double level){
        this.level = level;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }
    public String getDob() {
        return dob;
    }
    public double getLevel() {
        return level;
    }
    public float getSalary() {
        return salary;
    }
}