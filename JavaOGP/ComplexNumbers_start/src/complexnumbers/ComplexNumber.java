package complexnumbers;

/**
 *
 * @author tiwi
 */
public class ComplexNumber implements Comparable {

    private double a;
    private double b;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public ComplexNumber(double a){
        
    }
    
    public ComplexNumber(String s) throws NoComplexNumberNotation{
         try {
            if (s.equals("i")) {
                a = 0;
                b = 1;
            } else if (s.equals("-i")) {
                a = 0;
                b = -1;
            } else {

                if (s.indexOf("+") > 0) {
                    int index = s.indexOf("+");
                    a = Double.parseDouble(s.substring(0, index));
                    b = Double.parseDouble(s.substring(index + 1, s.length() - 1));
                } else if (s.indexOf("-") > 0) {
                    int index = s.indexOf("-");
                    a = Double.parseDouble(s.substring(0, index));
                    b = Double.parseDouble(s.substring(index + 1, s.length() - 1)) * -1;
                }else if(s.indexOf("-") == 0 && s.indexOf("-",1) > 0){
                    int index = s.indexOf("-",1);
                    a= Double.parseDouble(s.substring(0,index));
                    b = Double.parseDouble(s.substring(index+1,s.length()-1));
                    System.out.println("in if voor " + s);
                }else if (s.indexOf("-") == 0) {
                    int lengte = s.length();
                    String st = s.substring(1);
                    if (s.charAt(lengte - 1) == 'i') {
                        a = 0;
                        b = Double.parseDouble(st.substring(0, lengte - 2)) * -1;
                    } else {
                        a = Double.parseDouble(st) * -1;
                        b = 0;
                    }
                } else {
                    int lengte = s.length();
                    if (s.charAt(lengte - 1) == 'i') {
                        a = 0;
                        b = Double.parseDouble(s.substring(0, lengte - 1));
                    } else {
                        a = Double.parseDouble(s);
                        b = 0;
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new NoComplexNumberNotation();
        }

    }

    public double getModulus() {
        return Math.sqrt(a * a + b * b);
    }

    public int getArgumentInGraden() {
        return (int) (Math.atan2(b, a) * 180 / Math.PI);
    }
    
    public void vermeerderMet(ComplexNumber cn){
        a += cn.getReeel();
        b += cn.getImag();
    }
    
    public ComplexNumber som(ComplexNumber cn){
        this.vermeerderMet(cn);
        return this;
    }
    
    public static ComplexNumber sommatie(ComplexNumber... numbers){
        ComplexNumber sommatie = new ComplexNumber();
        for(ComplexNumber cn: numbers){
            sommatie.vermeerderMet(cn);
        }
        return sommatie;
    }
    
    public ComplexNumber gedeeldDoor(int i){
        this.a /= 3;
        this.b /= 3;
        return this;
    }
    
    public ComplexNumber product(ComplexNumber cn){
        double term1 = this.a * cn.getReeel();
        ComplexNumber term2 = new ComplexNumber(0,this.b * cn.getReeel());
        ComplexNumber term3 = new ComplexNumber(0,this.a * cn.getImag());
        double term4 = -(this.b * cn.getImag());
        term1 += term4;
        term2.vermeerderMet(term3);
        this.a = term1;
        this.b = term2.getImag();
        return this;
    }
    
    public double getReeel(){
        return a;
    }
    
    public double getImag(){
        return b;
    }
    
    // deze code is NIET goed; pas aan!
    @Override
    public String toString() {
        String reeel = "";
        String imag = "";
        
        if(Math.abs(a)>=0.001){
            reeel = String.format("%.3f",a);
        }
        if(Math.abs(b)>=0.001){
            imag = String.format("%.3f",b);
        }
        String res = reeel;
        if(b>=0.001){
            if(res.equals("")){
                res = imag + "i";
            }
            else {
                res += "+"+imag+"i";
            }
        }
        else if(b<=-0.001){
            res += imag +"i";
        }
        if(res.equals("")){
            res = "0.000";
        }
        return res;
    }
    
    @Override
    public int compareTo(Object obj) {
        if(obj.equals(null)){
            throw new NullPointerException();
        }
        if(!(obj instanceof ComplexNumber)) {
            throw new ClassCastException();
        }
        ComplexNumber ander = (ComplexNumber) obj;
        if(Math.abs((int) (1000 * this.getModulus()) - (int) (1000 * ander.getModulus())) >= 1){
            return (int) (1000 * this.getModulus()) - (int) (1000 * ander.getModulus());
        }
        return this.getArgumentInGraden() - ander.getArgumentInGraden();
    }
    
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if((int) (1000 * this.getModulus()) - (int) (1000 * other.getModulus()) != 0) {
            return false;
        }
        if (this.getArgumentInGraden() != other.getArgumentInGraden()) {
            return false;
        }
        return true;
    }
    
    @Override 
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (1000 * this.getModulus());
        hash = 53 * hash + this.getArgumentInGraden();
        return hash;
    }

    /*
    // vul de parameterlijst aan, de rest van de hoofding blijft ongewijzigd
    public static ComplexNumber sommatie(...) {
        // ...
    }
    */


}
