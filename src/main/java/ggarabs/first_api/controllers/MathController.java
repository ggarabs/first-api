package ggarabs.first_api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ggarabs.first_api.exception.DivisionByZeroException;
import ggarabs.first_api.exception.UnsupportedMathOperationException;
import ggarabs.first_api.math.SimpleMath;
import ggarabs.first_api.request.converters.NumberConverter;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{firstOperator}/{secondOperator}")
    public Double sum(@PathVariable("firstOperator") String firstOperator,
            @PathVariable("secondOperator") String secondOperator) throws Exception {
        if (!NumberConverter.isNumeric(firstOperator) || !NumberConverter.isNumeric(secondOperator))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double firstNumber = NumberConverter.convertToDouble(firstOperator);
        Double secondNumber = NumberConverter.convertToDouble(secondOperator);
        return math.sum(firstNumber, secondNumber);
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{firstOperator}/{secondOperator}")
    public Double subtraction(@PathVariable("firstOperator") String firstOperator,
            @PathVariable("secondOperator") String secondOperator) {
        if (!NumberConverter.isNumeric(firstOperator) || !NumberConverter.isNumeric(secondOperator))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        Double firstNumber = NumberConverter.convertToDouble(firstOperator);
        Double secondNumber = NumberConverter.convertToDouble(secondOperator);

        return math.subtraction(firstNumber, secondNumber);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{firstOperator}/{secondOperator}")
    public Double multiplication(@PathVariable("firstOperator") String firstOperator,
            @PathVariable("secondOperator") String secondOperator) {
        if (!NumberConverter.isNumeric(firstOperator) || !NumberConverter.isNumeric(secondOperator))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        Double firstNumber = NumberConverter.convertToDouble(firstOperator);
        Double secondNumber = NumberConverter.convertToDouble(secondOperator);

        return math.multiplication(firstNumber, secondNumber);
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{firstOperator}/{secondOperator}")
    public Double division(@PathVariable("firstOperator") String firstOperator,
            @PathVariable("secondOperator") String secondOperator) {
        if (!NumberConverter.isNumeric(firstOperator) || !NumberConverter.isNumeric(secondOperator))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        Double numerator = NumberConverter.convertToDouble(firstOperator);
        Double denominator = NumberConverter.convertToDouble(secondOperator);

        if (denominator.equals(Double.valueOf(0)))
            throw new DivisionByZeroException("Pleaset set a non-zero value as denominator");

        return math.division(numerator, denominator);
    }
}
