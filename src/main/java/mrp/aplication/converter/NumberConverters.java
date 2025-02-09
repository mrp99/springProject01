package mrp.aplication.converter;

import mrp.aplication.exceptions.UnsupportedMathOperationException;

public class NumberConverters {
    private static final String MSG_ERROR = "Please set a numeric value";
    private static final String MSG_NULL_VALUE = "Not accept value of null!";

    public static boolean isInvalid(String strNumber) {
        return isNull(strNumber) || !isNumericFormat(strNumber);
    }

    public static boolean isNull(String strNumber) {
        return strNumber == null;
    }

    public static boolean isNumericFormat(String strNumber) {
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            throw new IllegalArgumentException(MSG_NULL_VALUE);
        } try {
            return Double.parseDouble(strNumber.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException(MSG_ERROR);
        }
    }
}
