package Palindromes;

public class MyClass {
	static String name;
    MyClass(String n) {
        name = n;
    }
    public boolean equals(Object o) {
        MyClass m = (MyClass) o;
        if (m.name != null) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        MyClass m1 = new MyClass("guitar");
        MyClass m2 = new MyClass("tv");
        MyClass m3 = new MyClass(null);
        System.out.println(m1.equals(m2) + "," + m2.equals(m3) + "," + (m3==m3));
    }
}
