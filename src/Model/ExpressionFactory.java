package Model;

public class ExpressionFactory {

    //create an object of SingleObject
    private static ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory(){}


    public static ExpressionFactory getInstance(){
        return instance;
    }

    public ComplexExpression createExpression(Operation operation, Complex[] args){

         if(operation == Operation.ADDITION){
             return new AdditionExpression(operation,args);
         }
         if(operation == Operation.SUBSTRACTION){
            return new SubstractExpression(operation,args);
         }
         if(operation == Operation.MULTIPLICATION){
             return new MultiplyExpression(operation,args);
         }
        if(operation == Operation.DIVISION){
            return new DivExpression(operation,args);
        }
        return new ComplexExpression(operation,args) {
            @Override
            Complex executeOneOperation(Complex a, Complex b) {
                return null;
            }
        };
    }

}
