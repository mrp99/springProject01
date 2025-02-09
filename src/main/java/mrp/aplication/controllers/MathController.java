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

        @RequestMapping(
                value = "/sum/{numberOne}/{numberTwo}",
                method= RequestMethod.GET
        )
        public Double sum(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) {
            if(isInvalid(numberOne) || isInvalid(numberTwo)) {
                throw new UnsupportedMathOperationException(MSG_ERROR);
            }
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
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

    private boolean isInvalid(String strNumber) {
        return isNull(strNumber) || !isNumericFormat(strNumber);
    }

    private boolean isNull(String strNumber) {
        return strNumber == null;
    }

    private boolean isNumericFormat(String strNumber) {
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
