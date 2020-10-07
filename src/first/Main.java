package first;

import Model.*;

public class Main {

    public static void main(String[] args) {
        //2+3*i + 5−6*i + −2+i + i + -i + -2*i + 33*i + 2+i + 2-i + 2+2*i + 2-2*i + -2+i + -2-i + -2+2*i + -2-2*i + i

        boolean x = ExpressionParser.isValid(args);
        System.out.println("Rezultat :" + x);

        ExpressionParser expressionParser = new ExpressionParser();
        System.out.println(expressionParser.parseExpression(args).toString());
        System.out.println(expressionParser.parseExpression(args).execute());


        ComplexExpression adunare = new AdditionExpression(Operation.ADDITION,new Complex[]{
                new Complex(1,2),new Complex(-3,4),new Complex(-2,-3)});
        System.out.println("Adunare: " + adunare.execute());

        ComplexExpression scadere = new SubstractExpression(Operation.SUBSTRACTION,new Complex[]{
                new Complex(1,2),new Complex(-3,4),new Complex(-2,-3)});
        System.out.println("Scadere: " + scadere.execute());

        ComplexExpression inmultire = new MultiplyExpression(Operation.MULTIPLICATION,new Complex[]{
                new Complex(1,2),new Complex(-3,4),new Complex(-2,-3)});
        System.out.println("Inmultire: " + inmultire.execute());

        ComplexExpression impartire = new DivExpression(Operation.DIVISION,new Complex[]{
               new Complex(-3,4),new Complex(-2,-3)});
        System.out.println("Impartire: " + impartire.execute());

    }
}
