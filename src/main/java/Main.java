import java.util.*;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

        /*Random random = new Random();

        List numbers = new ArrayList();

        for(int i = 0;i < 10;++i) {
            numbers.add(random.nextInt(100) / 10.0);
        }

        numbers.remove(9);
        System.out.println(numbers);*/

        /*String text = "abcABCxyzXYZ!";
        int number = 100;

        String encoded = encode(text, number);
        String decoded = decode(encoded, number);

        System.out.println(text);
        System.out.println(encoded);
        System.out.println(decoded);*/

        /*Random random = new Random();

        Stack stack = new LinkedStack();
        stack.push(random.nextInt(100) / 10.0);
        stack.push(random.nextInt(100) / 10.0);
        stack.push(random.nextInt(100) / 10.0);
        stack.push(random.nextInt(100) / 10.0);
        stack.push(random.nextInt(100) / 10.0);
        System.out.print("\n" + stack.toString() + "\n");
        System.out.println('\n' + stack.pop() + '\n');
        System.out.println('\n' + stack.toString() + '\n');
        System.out.println('\n' + stack.pop() + '\n');
        System.out.println('\n' + stack.toString() + '\n');
        System.out.println('\n' + stack.pop() + '\n');
        System.out.println('\n' + stack.toString() + '\n');
        System.out.println('\n' + stack.pop() + '\n');
        System.out.println('\n' + stack.toString() + '\n');
        System.out.println('\n' + stack.pop() + '\n');
        System.out.println('\n' + stack.toString() + '\n');
        //System.out.println('\n' + stack.pop() + '\n');*/


        /*Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new LinkedStack<>();

        int a = scanner.nextInt();
        int count = 0;
        while(a != 0) {
            stack.push(a);
            ++count;
            a = scanner.nextInt();
        }

        /*for(int i = 0;i < count;++i) {
            System.out.println(stack.pop());
        }*/

        /*while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }*/

        /*String text = "A│la\nmiała ko│t|a.!";

        //Java 7
        char[] chars = text.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        for(char c : chars) {
            c = Character.toLowerCase(c);
            c = Character.isWhitespace(c) ? '_' : c;

            if(Character.isLetter(c) || c == '_') {
                stringBuilder.append(c);
            }
        }

        System.out.println(stringBuilder.toString());

        //Java 8
        System.out.println(text.toLowerCase()
                .replaceAll("\\s", "_")
                .codePoints()
                .filter(c -> Character.isLetter(c) || c == '_')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());*/
        /*Random random = new Random();

        LinkedList<Integer> numbers = new LinkedList<>();

        for(int i = 0;i < 1500;++i) {
            numbers.add(i);
        }

        int[] array = new int[1000];
        BinarySearchTree bst = new BinarySearchTree();

        for(int i = 0;i < array.length - 1;++i) {
            int a = numbers.remove(random.nextInt(numbers.size()));

            array[i] = a;
            bst.add(a);
        }

        array[array.length -1] = 10001;
        bst.add(10001);

        int a = 857;

        long now = System.nanoTime();
        System.out.println(contain(array, 10001));
        System.out.println(System.nanoTime() - now);

        now = System.nanoTime();
        System.out.println(bst.contain(10001));
        System.out.println(System.nanoTime() - now);

        System.out.println();
        System.out.println(bst.minDepth());
        System.out.println(bst.depth());


        bst.normalise();
        System.out.println();
        System.out.println(bst.minDepth());
        System.out.println(bst.depth());

        now = System.nanoTime();
        System.out.println(bst.contain(10001));
        System.out.println(System.nanoTime() - now);*/

        Set<Double> set = new HashSet<>();

        Random random = new Random();

        int size = random.nextInt(11) + 10;

        for(int i = 0;i < size;++i) {
            set.add(i * i / 5.0);
        }

        //Java 7
        set.foreach(new Consumer<Double>() {
            @Override
            public void accept(Double number) {
                System.out.println(number);
            }
        });

        //Java 8
        set.foreach((Double number) -> {
            System.out.println(number);
        });

        set.foreach(number -> {
            System.out.println(number);
        });

        set.foreach(number -> System.out.println(number));

        Consumer<Double> println = System.out::println;

        set.foreach(println);

        Set<String> stringSet = set.map(number -> "_" + number);

        stringSet.foreach(System.out::println);
    }

    public static boolean contain(int[] array, int a) {
        for(int e : array) {
            if(e == a) {
                return true;
            }
        }

        return false;
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

    public static int countSmallA(String line) {
        return 0;
    }

    private static int ALPHABET_SIZE = 'z' - 'a' + 1;
    public  static String encode(String text, int number) {
        if(number < 0) {
            throw new IllegalArgumentException("number < 0");
        }

        char[] chars = text.toCharArray();

        for(int i = 0;i < chars.length;++i) {
            char c = chars[i];

            char a;
            if(Character.isLowerCase(c)) {
                a = 'a';
            } else if(Character.isUpperCase(c)) {
                a = 'A';
            } else {
                continue;
            }

            c -= a;

            //encode start

            c += number;

            c %= ALPHABET_SIZE;

            //encode end

            c += a;

            chars[i] = c;
        }

        return String.valueOf(chars);
    }

    public  static String decode(String text, int number) {
        if(number < 0) {
            throw new IllegalArgumentException("number < 0");
        }

        char[] chars = text.toCharArray();

        for(int i = 0;i < chars.length;++i) {
            char c = chars[i];

            char a;
            if(Character.isLowerCase(c)) {
                a = 'a';
            } else if(Character.isUpperCase(c)) {
                a = 'A';
            } else {
                continue;
            }

            c -= a;

            //decode start

            /*c += ALPHABET_SIZE;
            c -= number % ALPHABET_SIZE;*/

            c += ALPHABET_SIZE * (number / ALPHABET_SIZE + 1);
            c -= number;

            c %= ALPHABET_SIZE;

            //decode end

            c += a;

            chars[i] = c;
        }

        return String.valueOf(chars);
    }
}
