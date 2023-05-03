package ma.enset.ga.sma;

import java.util.Random;

public class Test {
    static String  individual;
    private final  static String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private final static String target = "Bonjour SDIA";
    private final static Random rnd = new Random();
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append(GENES.charAt(rnd.nextInt(GENES.length())));
        }
        individual = sb.toString();
        System.out.println(individual);
    }
}
