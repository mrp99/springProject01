package mrp.aplication.controllers;

import mrp.aplication.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private static final String  MSG_ERROR = "Please set a numeric value";
    private static final String MSG_NULL_VALUE = "Not accept value of null!";
    private static final String MSG_ZERO_VALUE = "Não é possível dividir por zero!";
    private static final String MSG_NEGATIVE_VALUE = "Não é possível calcular a raiz quadrada de um número negativo!";

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(isInvalid(numberOne) || isInvalid(numberTwo)) throw new UnsupportedMathOperationException(MSG_ERROR);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(isInvalid(numberOne) || isInvalid(numberTwo)) throw new UnsupportedMathOperationException(MSG_ERROR);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(isInvalid(numberOne) || isInvalid(numberTwo)) throw new UnsupportedMathOperationException(MSG_ERROR);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(isInvalid(numberOne) || isInvalid(numberTwo)) throw new UnsupportedMathOperationException(MSG_ERROR);
        double num1 = convertToDouble(numberOne);
        double num2 = convertToDouble(numberTwo);
        if (num1 == 0 && num2 == 0)  throw new UnsupportedMathOperationException(MSG_ZERO_VALUE);
        return num1 / num2;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(isInvalid(numberOne) || isInvalid(numberTwo)) throw new UnsupportedMathOperationException(MSG_ERROR);
        double num1 = convertToDouble(numberOne);
        double num2 = convertToDouble(numberTwo);
        return (num1 + num2) / 2;
    }

    @RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) {
        if(isInvalid(number)) throw new UnsupportedMathOperationException(MSG_ERROR);
        if (convertToDouble(number) < 0) throw new UnsupportedMathOperationException(MSG_NEGATIVE_VALUE);
        return Math.sqrt(convertToDouble(number));
    }

    private boolean isInvalid(String strNumber) {
        return isNull(strNumber) || !isNumericFormat(strNumber);
    }

    private boolean isNull(String strNumber) {
        return strNumber == null;
    }

    private boolean isNumericFormat(String strNumber) {
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            throw new IllegalArgumentException(MSG_NULL_VALUE);
        } try {
            return Double.parseDouble(strNumber.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException(MSG_ERROR);
        }
    }
}
