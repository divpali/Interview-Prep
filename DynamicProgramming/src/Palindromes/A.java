package Palindromes;

public class A {
	
	String getName() {
        return "A";
    }

    static class B extends A {
        String getName() {
            return "B";
        }
    }

    public static void main(String[] args) {
        B b = new B();
        A a = (A) b;
        System.out.println(a.getName() + "," + b.getName());
        System.out.println((int)(2.2f * 2.25f));
    }

}
