package mrp.aplication.controller;

import mrp.aplication.converter.NumberConverters;
import mrp.aplication.exceptions.UnsupportedMathOperationException;
import mrp.aplication.service.MathOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final MathOperation math;
    private static final String NUMERIC_VALUE = "Please set a numeric value!";

    @Autowired
    public MathController(MathOperation math) {
        this.math = math;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (NumberConverters.isInvalid(numberOne) || NumberConverters.isInvalid(numberTwo))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num1 = NumberConverters.convertToDouble(numberOne);
        double num2 = NumberConverters.convertToDouble(numberTwo);
        return math.sum(num1, num2);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double subtraction (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (NumberConverters.isInvalid(numberOne) || NumberConverters.isInvalid(numberTwo))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num1 = NumberConverters.convertToDouble(numberOne);
        double num2 = NumberConverters.convertToDouble(numberTwo);
        return math.subtraction(num1, num2);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double multiplication (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (NumberConverters.isInvalid(numberOne) || NumberConverters.isInvalid(numberTwo))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num1 = NumberConverters.convertToDouble(numberOne);
        double num2 = NumberConverters.convertToDouble(numberTwo);
        return math.multiplication(num1, num2);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double division (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (NumberConverters.isInvalid(numberOne) || NumberConverters.isInvalid(numberTwo))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num1 = NumberConverters.convertToDouble(numberOne);
        double num2 = NumberConverters.convertToDouble(numberTwo);
        return math.division(num1, num2);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double average (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (NumberConverters.isInvalid(numberOne) || NumberConverters.isInvalid(numberTwo))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num1 = NumberConverters.convertToDouble(numberOne);
        double num2 = NumberConverters.convertToDouble(numberTwo);
        return math.average(num1, num2);
    }

    @RequestMapping(value = "/squareRoot/{number}", method= RequestMethod.GET)
    public Double squareRoot (
            @PathVariable(value = "number") String number
    ) throws Exception {

        if (NumberConverters.isInvalid(number))
            throw new UnsupportedMathOperationException(NUMERIC_VALUE);
        double num = NumberConverters.convertToDouble(number);
        return math.squareRoot(num);
    }
}
