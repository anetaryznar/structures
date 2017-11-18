import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*String[] tab = new String[]{"Ala"};

        String result = concat(tab, " ");

        if("Ala".equals(result)) {
            System.out.println("OK");
        } else {
            System.out.println("Error");
            System.out.println("Ala ma kota");
            System.out.println(result);
        }*/

        /*Random random = new Random();

        int size = 10000;

        int[] tab0 = new int[size];
        int[] tab1 = new int[size];

        for(int i = 0;i < tab0.length;++i) {
            tab0[i] = random.nextInt(100);
        }

        long now = System.nanoTime();
        for(int i = 0;i < tab0.length;++i) {
            tab1[i] = tab0[i];
        }
        System.out.println(System.nanoTime() - now);

        for(int i = 0;i < tab0.length;++i) {
            tab0[i] = random.nextInt(100);
        }

        now = System.nanoTime();
        System.arraycopy(tab0, 0, tab1, 0, tab0.length);
        System.out.println(System.nanoTime() - now);
        */

        Random random = new Random();

        List numbers = new ArrayList();

        for(int i = 0;i < 10;++i) {
            numbers.add(random.nextInt(100) / 10.0);
        }

        numbers.remove(9);
        System.out.println(numbers);
    }

    public static String concat(String[] tab, String delimiter) {
        if(tab == null || tab.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder(tab[0]);
        for(int i = 1;i < tab.length;++i) {
            result.append(delimiter).append(tab[i]);
        }

        return result.toString();
    }
}
