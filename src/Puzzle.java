
import java.util.Scanner;
//Yaren gokhan date 02/11/2021
//Student no 20200808069
public class Puzzle {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st input value: ");
        String s = scanner.nextLine();
        if (s.length() < 2 && s.length() > 6) {
            throw new Exception("words must greater than or equal to 2 and less than 6 or equal to 6 ");
        }
        System.out.println("Enter 2nd input value:");
        String s1 = scanner.nextLine();
        if (s1.length() < 2 && s1.length() > 6) {
            throw new Exception("words must greater than or equal to 2 and less than 6 or equal to 6 ");
        }
        System.out.println("Enter output value:");
        String s2 = scanner.nextLine();
        if (s1.length() < 2 && s1.length() > 6) {
            throw new Exception("words must greater than or equal to 2 and less than 6 or equal to 6 ");
        }
        answer(s, s1, s2);
    }

    static void answer(String s, String s1, String s2) {
        letter = new boolean[26];
        numbers = new boolean[26];
        usenumbers = new int[26];
        unique(s);
        unique(s1);
        unique(s2);
        recursion(0, s, s1, s2);

    }

    static boolean[] letter;
    static boolean[] numbers;
    static int[] usenumbers;

    static void recursion(int k, String s, String s1, String s2) {
        if (k == 26) {
            if (control(s, s1, s2)) {
                System.out.println("searching ... found");
                for (int i = 0; i < 26; ++i)
                    if (letter[i])
                        System.out.printf("(%c = %d)", (char) (i + 'A'), usenumbers[i]);

            }
            return;
        }

        if (!letter[k]) {
            recursion(k + 1, s, s1, s2);
            return;
        }
        for (int h = 0; h < 10; ++h) {
            if (!numbers[h]) {
                numbers[h] = true;
                usenumbers[k] = h;

                recursion(k + 1, s, s1, s2);
                numbers[h] = false;
            }
        }
    }

    static void unique(String s3) {
        for (int i = 0; i < s3.length(); ++i) {
            if (s3.length() >= 2 && s3.length() <= 6) {
                letter[s3.charAt(i) - 'A'] = true;
            }
        }
    }

    static boolean control(String s, String s1, String s2) {
        return val(s) + val(s1) == val(s2);
    }

    static int val(String s4) {
        int x = 0;
        for (int i = 0; i < s4.length(); ++i)
            x = x * 10 + usenumbers[s4.charAt(i) - 'A'];
        return x;

    }
}


