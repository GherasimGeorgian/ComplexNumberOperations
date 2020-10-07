package Model;

public class AdditionExpression extends ComplexExpression{

    public AdditionExpression(Operation operation, Complex[] args){
        super(operation,args);
    }

    @Override
    Complex executeOneOperation(Complex a, Complex b) {
        Complex c = a.adauga(b);
        return c;
    }
    @Override
    public String toString(){
        String expression = new String();
        for(int i=0;i<super.complex_numbers.length;i++){
            if(expression.isEmpty())
                expression = super.complex_numbers[i].toString();
            else
            expression = expression + " + " + super.complex_numbers[i].toString();
        }
        return expression;
    }
}
