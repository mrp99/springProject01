package mrp.aplication.service;

import org.springframework.stereotype.Service;

@Service
public class MathOperation {

    private static final String NULL_NUMBER = "Os números não podem ser nulos.";
    private static final String  NEGATIVE_NUMBER = "Não é possível calcular a raiz quadrada de um número negativo.";

    public Double sum(Double numberOne, Double numberTwo) {
        if (numberOne == null || numberTwo == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        if (numberOne == null || numberTwo == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        if (numberOne == null || numberTwo == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo)  {
        if (numberOne == null || numberTwo == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) {
        if (numberOne == null || numberTwo == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        if (number == null)
            throw new IllegalArgumentException(NULL_NUMBER);
        if (number < 0)
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        return Math.sqrt(number);
    }
}
