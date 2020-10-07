package Model;

public class Complex {
    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    private double real,imag;
    public Complex(){
        real=0;
        imag=0;
    }
    public Complex(double r,double i){
        this.real = r;
        this.imag= i;
    }
    public Complex adauga(Complex a){
        return new Complex(a.real + this.real,a.imag+ this.imag);
    }

    public Complex scade(Complex a){
        return new Complex( this.real - a.real, this.imag - a.imag);
    }
    public Complex inmultire(Complex a){

        double _real = a.real*this.real - a.imag*this.imag;
        double _imaginary = a.real*this.imag + a.imag*this.real;
        return new Complex(_real,_imaginary);
    }
    public Complex imparte(Complex a){

        Complex output = a.inmultire(this.conjugatul());
        double div = Math.pow(this.mod(),2);
        return new Complex(output.real/div,output.imag/div);
    }
    public double mod()
    {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imag,2));
    }
    public Complex conjugatul()
    {
        return new Complex(this.real,-this.imag);
    }
    @Override
    public String toString(){
        return getReal() + "+" + getImag() + "i";
    }
}
