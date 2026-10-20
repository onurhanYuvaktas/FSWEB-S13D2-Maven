package org.example;

public class Main {

    public static boolean isPalindrome(int number) {
        int originalNumber = Math.abs(number);
        int reversedNumber = 0;
        int temp = originalNumber;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            temp /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }


    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        if (number == 0) {
            return "Zero";
        }

        int reversedNumber = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        StringBuilder result = new StringBuilder();
        int temp = reversedNumber;

        while (temp > 0) {
            int digit = temp % 10;
            switch (digit) {
                case 0:
                    result.append("Zero ");
                    break;
                case 1:
                    result.append("One ");
                    break;
                case 2:
                    result.append("Two ");
                    break;
                case 3:
                    result.append("Three ");
                    break;
                case 4:
                    result.append("Four ");
                    break;
                case 5:
                    result.append("Five ");
                    break;
                case 6:
                    result.append("Six ");
                    break;
                case 7:
                    result.append("Seven ");
                    break;
                case 8:
                    result.append("Eight ");
                    break;
                case 9:
                    result.append("Nine ");
                    break;
            }
            temp /= 10;
        }

        // Handle trailing zeros if the original number ended with zero(s)
        for (int i = 0; i < (originalDigitCount - reversedDigitCount); i++) {
            result.append("Zero ");
        }

        return result.toString().trim();
    }


    public static int reverse(int number) {
        int reversed = 0;
        int temp = Math.abs(number);
        boolean isNegative = number < 0;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversed = (reversed * 10) + lastDigit;
            temp /= 10;
        }

        return isNegative ? -reversed : reversed;
    }


    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }

        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("isPalindrome(-1221): " + isPalindrome(-1221)); // true
        System.out.println("isPalindrome(707): " + isPalindrome(707));       // true
        System.out.println("isPalindrome(11212): " + isPalindrome(11212));   // false

        System.out.println("isPerfectNumber(6): " + isPerfectNumber(6));     // true
        System.out.println("isPerfectNumber(28): " + isPerfectNumber(28));   // true
        System.out.println("isPerfectNumber(5): " + isPerfectNumber(5));     // false
        System.out.println("isPerfectNumber(-1): " + isPerfectNumber(-1));   // false

        System.out.println("numberToWords(123): " + numberToWords(123));     // One Two Three
        System.out.println("numberToWords(1010): " + numberToWords(1010));   // One Zero One Zero
        System.out.println("numberToWords(-12): " + numberToWords(-12));     // Invalid Value
    }
}