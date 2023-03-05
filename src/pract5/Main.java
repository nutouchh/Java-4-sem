package pract5;

public class Main {
    public static void main(String[] args) {
        SingletonOne s1 =SingletonOne.getInstance();
        SingletonOne s1e = SingletonOne.getInstance();
        System.out.println(s1+" "+s1e+" "+s1.equals(s1e));

        SingletonTwo s2 = SingletonTwo.getInstance();
        SingletonTwo s2e = SingletonTwo.getInstance();
        System.out.println(s2+" "+s2e+" "+s2.equals(s2e));

        SingletonThree s3 = SingletonThree.getInstance();
        SingletonThree s3e = SingletonThree.getInstance();
        System.out.println(s3+" "+s3e+" "+s3.equals(s3e));

    }
}
