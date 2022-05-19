import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("\nPrograma skaiciuojanti ivesto zodzio ilgiausia dali, be pasikartojanciu simboliu.\n");
        System.out.println("Iveskite zodi:");
        Scanner scan = new Scanner(System.in);
        String givenString = scan.nextLine();
        System.out.println("\nilgiausia nesikartojanti ivesto zodzio dalis yra: " +
                lengthOfLongestSubstring(givenString) + " simboliai");
    }

    /**
     * Funkcija skaiciuojanti zodzio dalies, be pasikartojanciu simboliu, ilgi
     * @param passedString perduodamas zodis
     * @return zodzio dalies, be pasikartojanciu simboliu, ilgis
     */
    public static int lengthOfLongestSubstring(String passedString) {

        int n = passedString.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            // ciklas nr.1 - iteruojam per kiekviena is pateikto zodzio simbolio indekso numeri. Kiekvienoje iteracijoje
            // nustatome zodzio simbolio indekso nr. kuris bus pradine reiksme cikle nr.2:
            System.out.println("\n>>>>>>>>>>>");
            System.out.println(i);
            System.out.println("\n>>>>>>>>>>>\n");
            for (int j = i; j < n; j++) {
                // ciklas nr.2 - iteruojam per kiekviena is pateikto zodzio simbolio indekso nr, iki zodzio pabaigos
                // arba iki pirmo pasikartojancio simbolio
                System.out.println(j);
                // jei atsiranda simboliu pasikartojimas:
                if (checkRepetition(passedString, i, j)) {
                    // rezultatas lygus didesnei reiksmei is buvusio rezutato ir ciklo nr.2:
                    result = Math.max(result, j - i + 1);
                    System.out.println("\n ^ rezultatas: "+ result);
                }
            }
        }
        return result;
    }

    /**
     * Funkcija tikrinanti ar simboliai kartojasi
     * @param passedString perduodamas zodis
     * @param start zodzio dalies pradzia
     * @param end zodzio dalies pabaiga
     * @return true - jei simboliai kartojasi, false - jei nesikartoja
     */
    private static boolean checkRepetition(String passedString, int start, int end) {
        // sukuriam tuscia masyvam kurio dydis lygus maximaliam Extended ASCII simboliu skaiciui
        int[] chars = new int[256];

        for (int i = start; i <= end; i++) {
            char c = passedString.charAt(i);
            //System.out.print(c);

            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
            System.out.print(c);
        }
        System.out.println("");
        return true;
    }
}
