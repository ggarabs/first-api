package ggarabs.first_api.math;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SimpleMath {
    public Double sum(Double firstOperator, Double secondOperator) {
        return firstOperator + secondOperator;
    }

    public Double subtraction(Double firstOperator, Double secondOperator) {
        return firstOperator - secondOperator;
    }

    public Double multiplication(Double firstOperator, Double secondOperator) {
        return firstOperator * secondOperator;
    }

    public Double division(Double firstOperator, Double secondOperator) {
        return firstOperator / secondOperator;
    }

}
