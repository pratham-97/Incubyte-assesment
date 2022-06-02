import java.util.regex.Pattern;

public class StringCalculator {
    public static  String		DELIMETER						= ",";
    public static  String		DELIMETER_EXP						= "//.\n(.*)";

    public static int Add(String numbers){
        if(numbers.equals(""))
            return 0;

        if(numbers.contains("-"))
            throw new UnsupportedOperationException("Negative numbers are not allowed ");

            if(numbers.matches(DELIMETER_EXP)){

                if((numbers.charAt(2)!=(numbers.charAt(5))))
                    throw new IllegalArgumentException("Delimeter given "+numbers.charAt(2)+" is not matching with the delimeter used"+numbers.charAt(5));

                DELIMETER = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String numbersList[] =numbers.split(DELIMETER+"|\n");

        return calculate(numbersList);
    }
    private static int calculate(String[] numbersList){
        int total = 0;
        for(String number : numbersList){
                total += Integer.parseInt(number);
        }
        return total;
    }
}
