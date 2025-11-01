public class checkEven {
    public static void main(String[] args) {
        int[] numbers = {6,59,64,70,40,41,37,58,7,23};

        for (int i = 0; i < numbers.length; i++) {
            boolean even = isEven(numbers[i]);

            if (even) {
                System.out.printf("%d is even\n",numbers[i]);
            } else System.out.printf("%d is not even\n",numbers[i]);
        }
    }

    public static boolean isEven(int aNumber) {
        if (aNumber == 0 || aNumber % 2 != 0) {
            return false;
        } else return true;
    }
}