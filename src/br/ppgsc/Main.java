package br.ppgsc;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(10);
        try {
            names.append("Alice");
            names.append("Bob");
            names.append("Cloud");
            names.append("Denis");
            names.append("Eric");
            names.append("Fran");
            names.append("Gaia");
            names.append("Goia");
            names.append("Gulliver");
            names.append("Hugo");
            System.out.println(names);
            int position = names.binarySearch("Goia", (f, s) -> f.compareTo(s) > 0);
            if (position >= 0) {
                names.moveToPosition(position);
                System.out.println("Lista[" + position + "] = " + names.getElement());
            } else {
                System.out.println("not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
