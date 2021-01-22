public class Tasks {
    public static String EXCEPTION = "Number cannot be negative.";
    public static String EXCEPTION_EXP = "Exponent cannot be negative.";

    public int getFibonacci(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        return (number < 2) ? number : getFibonacci(number - 1) + getFibonacci(number - 2);
    }

    public int getFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        return (number < 2) ? 1 : number * getFactorial(number - 1);
    }

    public int getExponentiation(int number, int exponentiation) {
       if (exponentiation < 0) {
            throw new IllegalArgumentException(EXCEPTION_EXP);
        }

        if (exponentiation > 0) {
            return number * getExponentiation(number, exponentiation - 1);
        }
        return 1;
    }
}
