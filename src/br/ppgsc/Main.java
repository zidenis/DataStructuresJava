package br.ppgsc;

public class Main {

    public static void main(String[] args) {
        List<Integer> decimals = new ArrayList(10);
        try {
            decimals.append(1);
            System.out.println(decimals);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
