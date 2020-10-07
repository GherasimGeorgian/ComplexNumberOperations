package Model;

import Model.Operation;
import Model.Complex;
public abstract class ComplexExpression {
    Operation operation;
    Complex[] complex_numbers;

    public ComplexExpression(Operation operation, Complex[] args){
        this.operation = operation;
        this.complex_numbers = args;
    }

    abstract Complex executeOneOperation(Complex a, Complex b);

    public final Complex execute(){
        Complex total = null;
        for(int i=0;i<complex_numbers.length;i++){
            if(total == null){
                total = complex_numbers[0];
            }
            else
            total = executeOneOperation(total,complex_numbers[i]);
        }
        return total;
    }

    @Override
    public String toString(){
        String expression = new String();
        for(int i=0;i<complex_numbers.length;i++){
            expression = expression + "," + complex_numbers[i].toString();
        }
        return expression;
    }
}
