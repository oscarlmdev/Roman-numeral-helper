public class RomanNumerals {
    public static String toRoman(int n) {
        int number = n;
        // Case out of input range
        if (number < 1 || number >= 4000)
            return null;
        // Roman will be the result string, store max value first
        StringBuilder roman = new StringBuilder();
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        for (int i = 0; i < value.length; i++) {
            // Add symbol if >= value
            while (number >= value[i]) {
                number -= value[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            int value = romanToInt(romanNumeral.charAt(i));
            // If value less than next one, substract, else add
            if (i < romanNumeral.length() - 1) {
                int nextVal = romanToInt(romanNumeral.charAt(i + 1));
                if (value < nextVal) {
                    result -= value;
                } else {
                    result += value;
                }
            } else {
                result += value;
            }
        }
        return result;
    }

    public static int romanToInt(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
