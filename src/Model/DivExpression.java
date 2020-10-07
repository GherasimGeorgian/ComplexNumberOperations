package Model;

public class DivExpression extends ComplexExpression {
    public DivExpression(Operation operation, Complex[] args){
        super(operation,args);
    }

    @Override
    Complex executeOneOperation(Complex a, Complex b) {
        Complex c = a.imparte(b);
        return c;
    }
    @Override
    public String toString(){
        String expression = new String();
        for(int i=0;i<super.complex_numbers.length;i++){
            expression = expression + "/" + super.complex_numbers[i].toString();
        }
        return expression;
    }
}
