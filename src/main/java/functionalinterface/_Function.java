package functionalinterface;
import java.util.function.BiFunction;
import java.util.function.Function;
public class _Function {

    static int result;
    public static void main(String[] args) {
        regularFunctionVsFunctionalInterface();
    }
    static void regularFunctionVsFunctionalInterface() {

        // regular method / function
        System.out.println("INCREMENTING BY 1");
        result = increment(109);
        System.out.println("Regular method or function   : " + result);
        // using a Functional interface
        result = incrementByOneFunction.apply(109);
        System.out.println("Using a Functional interface : " + result);

        // regular method / function
        System.out.println("MULTIPLYING BY 10");
        result = multiplyByTen(11);
        System.out.println("Regular method or function   : " + result);
        // using a Functional interface
        result = multiplyByTenFunction.apply(incrementByOneFunction.apply(10));
        System.out.println("Using a Functional interface : " + result);

        // regular method / function
        System.out.println("INCREMENTING BY 1, THEN MULTIPLYING BY TEN");
        result = incrementByOneAndMultiplyByTen(10);
        System.out.println("Regular method or function   : " + result);
        // using a Functional interface
        result = addByOneAndThenMultiplyByTen.apply(10);
        System.out.println("Using a Functional interface : " + result);
    }
    static void usingBiFunction() {
        // regular method / function
        result = setIncrementByOneAndMultiply(10, 10);
    }

    // regular method / function, adding 1 to a number, then returning it.
    static int increment(int number) {
        return ++number;
    }
    // using a Function
    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    // regular method / function, multiplying a number by ten.
    static int multiplyByTen(int number) {
        return number * 10;
    }
    // using a Function
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    // regular method / function, adding 1 to a number, multiplying the result of that number to 10, then returning it.
    static int incrementByOneAndMultiplyByTen(int number) {
        return (++number) * 10;
    }
    // using a Function
    static Function<Integer, Integer> addByOneAndThenMultiplyByTen =
            incrementByOneFunction.andThen(multiplyByTenFunction);

    // regular method / function, adding 1 to a number, multiplying the added number to another number the returning it.
    static int setIncrementByOneAndMultiply(int number, int numberToMultiplyBy) {
        return (number + 1) * numberToMultiplyBy;
    }
    // using a BiFunction
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}




