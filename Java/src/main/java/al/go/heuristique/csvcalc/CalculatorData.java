package al.go.heuristique.csvcalc;

import java.util.List;
import java.util.Objects;

public class CalculatorData {
    private List<Integer> numbersToCompute;
    private Character operator;

    public CalculatorData(List<Integer> numbersToCompute, Character operator) {
        this.numbersToCompute = numbersToCompute;
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorData that = (CalculatorData) o;
        return Objects.equals(numbersToCompute, that.numbersToCompute) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(numbersToCompute);
        result = 31 * result + Objects.hashCode(operator);
        return result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numbersToCompute=" + numbersToCompute +
                ", operator=" + operator +
                '}';
    }

    public List<Integer> getNumbersToCompute() {
        return numbersToCompute;
    }

    public void setNumbersToCompute(List<Integer> numbersToCompute) {
        this.numbersToCompute = numbersToCompute;
    }

    public Character getOperator() {
        return operator;
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }
}
