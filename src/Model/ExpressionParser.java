package Model;

public class ExpressionParser {
    ExpressionFactory expF = ExpressionFactory.getInstance();

    public ComplexExpression parseExpression(String[] args){
        Operation operation = null;
        Complex[] complex_nrs = new Complex[args.length/2 + 1];

        if(args[1].equals("+")){
            operation = Operation.ADDITION;
        }
        else  if(args[1].equals("-")){
            operation = Operation.SUBSTRACTION;
        }
        else  if(args[1].equals("*")){
            operation = Operation.MULTIPLICATION;
        }
        else  if(args[1].equals("/")){
            operation = Operation.DIVISION;
        }

        int pos = 0;

        for(int i=0;i<args.length;i++) {
            if(i%2 == 0) {
                // vreificam daca este i sau -i
                if(!(args[i].matches(".*\\d.*"))){
                    //daca nu contine cifre

                    if(args[i].length() == 1){
                       complex_nrs[pos] = new Complex(0,1);
                       pos++;
                    }

                    if(args[i].length() == 2){
                        complex_nrs[pos] = new Complex(0,-1);
                        pos++;
                    }

                }
                else if(Utils.isInteger(args[i].replace("*i",""))){
                    //verificam daca este doar partea imaginara de tipul numar*i sau -numar*i
                    double imag = Double.parseDouble(args[i].replace("*i",""));
                    complex_nrs[pos] = new Complex(0,imag);
                    pos++;

                }
                else if(Character.isDigit(args[i].charAt(0))){

                    if(args[i].contains("+")){
                        String[] parts = args[i].split("\\+");

                        double real = Double.parseDouble(parts[0]);
                        double imag;
                        if(parts[1].length() == 1){
                            imag = 1;
                        }
                        else{
                            imag =  Double.parseDouble(parts[1].replace("*i",""));
                        }
                        complex_nrs[pos] = new Complex(real,imag);
                        pos++;
                    }
                    else{
                        String[] parts = args[i].split("-");

                        double real = Double.parseDouble(parts[0]);
                        double imag;
                        if(parts[1].length() == 1){
                            imag = -1;
                        }
                        else{
                            imag =  Double.parseDouble("-" + parts[1].replace("*i",""));
                        }
                        complex_nrs[pos] = new Complex(real,imag);
                        pos++;
                    }
                }
                else if(args[i].startsWith("-")){
                    //expresie care incepe cu -number
                    if(Utils.countOccurrences(args[i],'-') == 2) {
                        String[] parts = args[i].split("-");

                        double real = Double.parseDouble("-" + parts[1]);
                        double imag;
                        if(parts[2].length() == 1){
                            imag = -1;
                        }
                        else{
                            imag =  Double.parseDouble("-" + parts[2].replace("*i",""));
                        }
                        complex_nrs[pos] = new Complex(real,imag);
                        pos++;
                    }
                    else{
                        String[] parts = args[i].split("\\+");

                        double real = Double.parseDouble(parts[0]);

                        double imag;
                        if(parts[1].length() == 1){
                            imag = 1;
                        }
                        else{
                            imag =  Double.parseDouble(parts[1].replace("*i",""));
                        }
                        complex_nrs[pos] = new Complex(real,imag);
                        pos++;
                    }
                }
            }
        }

        return expF.createExpression(operation,complex_nrs);
    }
    public static boolean isValid(String[] args){
        Operation Currentoperation = null;
        Operation operation = null;

        if(args[1].equals("+")){
            operation = Operation.ADDITION;
        }
        else  if(args[1].equals("-")){
            operation = Operation.SUBSTRACTION;
        }
        else  if(args[1].equals("*")){
            operation = Operation.MULTIPLICATION;
        }
        else  if(args[1].equals("/")){
            operation = Operation.DIVISION;
        }
        else return false;


        for(int i=0;i<args.length;i++){
            if(i%2 != 0){
                if(args[i].equals("+")){
                    Currentoperation = Operation.ADDITION;
                }
                else  if(args[i].equals("-")){
                    Currentoperation = Operation.SUBSTRACTION;
                }
                else  if(args[i].equals("*")){
                    Currentoperation = Operation.MULTIPLICATION;
                }
                else  if(args[i].equals("/")){
                    Currentoperation = Operation.DIVISION;
                }
                if(operation != Currentoperation){
                    return false;
                }
            }

        }
        return true;
    }
}
