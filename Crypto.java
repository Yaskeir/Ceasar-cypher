import java.util.*;

class Crypto {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide a string for encryption: ");
        String inputString = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Please specify the cypher's shift: ");
        int shift = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        System.out.println("And finally, please specify the cypher group size: ");
        int groupSize = sc3.nextInt();
        String encrypted = encryptString(inputString, shift, groupSize);
        System.out.println(encrypted);
        String ungrouped = ungroupify(encrypted);
        System.out.println(decryptString(ungrouped, shift));
        sc.close();
        sc2.close();
        sc3.close();
    }

    public static String normalizeText(String inputString) {
        String noSpaces = inputString.replaceAll("\\s+", "");
        String noPunctuation = noSpaces.replaceAll("\\W", "");
        String finalString = noPunctuation.toUpperCase();
        return finalString;
    }

    public static String ceasarify(String finalString, int key) {
        String result = "";
        for (int i = 0; i < finalString.length(); i++) {
            char c = (char)(finalString.charAt(i) + key);
            if (c > 'z') {
                result += (char)(finalString.charAt(i) - (26 - key));
            }
            else {
                result += (char)((finalString.charAt(i)) + key);
            }
        }
        return result;
    }
    
    public static String groupify(String inputString, int number) {
        String result = "";
        boolean StringShorterThanKey = inputString.length() < number;
        if (inputString.equals("")) {
            return result;
        }
        else if (StringShorterThanKey) {
            result += inputString;
            for (int i = 1; i <= number - inputString.length(); i++) {
                result += "x";
            }
            return result;
        }
        String sub = inputString.substring(0, number);
        String remainder = inputString.substring(number, inputString.length());
        result = sub + " ";
        return result + groupify(remainder, number);
    }

    public static String encryptString(String inputString, int shift, int groupSize) {
        String normalized = normalizeText(inputString);
        String ceasarified = ceasarify(normalized, shift);
        String finalString = groupify(ceasarified, groupSize);
        return finalString;
    }

    public static String ungroupify(String inputString) {
        String noSpaces = inputString.replaceAll("\\s+", "");
        return noSpaces;
    }

    public static String decryptString(String inputString, int shift) {
        String unceasarified = ceasarify(inputString, -shift);
        return unceasarified;
    }
}
