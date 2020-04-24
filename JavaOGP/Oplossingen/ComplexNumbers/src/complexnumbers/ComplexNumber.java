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

    public ComplexNumber(String tekst) throws NoComplexNumberNotation {
        try {
            if (!tekst.contains("i")) {
                try {
                    b = 0;
                    a = Double.parseDouble(tekst);
                } catch (NumberFormatException e) {
                    throw new NoComplexNumberNotation(tekst);
                }
            } else {
                if (tekst.charAt(tekst.length() - 1) != 'i') {
                    throw new NoComplexNumberNotation(tekst);
                }
                try {
                    // eerst proberen we of er alleen een imaginair deel staat;
                    // maar dan moeten we eerst uitsluiten dat er enkel "i" of "-i" staat.
                    a = 0;
                    if (tekst.equals("i")) {
                        b = 1;
                    } else if (tekst.equals("-i")) {
                        b = -1;
                    } else {
                        b = Double.parseDouble(tekst.substring(0, tekst.length() - 1));
                    }
                } catch (NumberFormatException e) {
                    // nu staat er a+bi of -a+bi of -a-bi of a-bi
                    String[] gesplitst = tekst.split("[+]");
                    String reeel;
                    String imaginair;
                    if (gesplitst.length == 2) {
                        reeel = gesplitst[0];
                        imaginair = gesplitst[1].substring(0, gesplitst[1].length() - 1);
                    } else {
                        String tekst2 = gesplitst[0];
                        int positieMinteken = tekst2.lastIndexOf("-");
                        reeel = tekst2.substring(0, positieMinteken);
                        imaginair = tekst2.substring(positieMinteken, tekst2.length() - 1);
                    }
                    try {
                        a = Double.parseDouble(reeel);
                        b = Double.parseDouble(imaginair);
                    } catch (NumberFormatException ex) {
                        throw new NoComplexNumberNotation(tekst);
                    }
                }
            }
        } catch (Exception e) {
            throw new NoComplexNumberNotation(tekst);
        }
    }

    public double getModulus() {
        return Math.sqrt(a * a + b * b);
    }

    public int getArgumentInGraden() {
        return (int) (Math.atan2(b, a) * 180 / Math.PI);
    }

    public void vermeerderMet(ComplexNumber ander) {
        this.a += ander.a;
        this.b += ander.b;
    }

    public ComplexNumber som(ComplexNumber ander) {
        return new ComplexNumber(this.a + ander.a, this.b + ander.b);
    }

    public ComplexNumber product(ComplexNumber ander) {
        return new ComplexNumber(this.a * ander.a - this.b * ander.b, this.a * ander.b + this.b * ander.a);
    }

    public static ComplexNumber sommatie(ComplexNumber... andere) {
        ComplexNumber resultaat = new ComplexNumber();
        for (ComplexNumber cn : andere) {
            resultaat.vermeerderMet(cn);
        }
        return resultaat;
    }

    public ComplexNumber gedeeldDoor(double noemer) {
        return new ComplexNumber(this.a / noemer, this.b / noemer);
    }

    // equals: 
    // modulus moet op 0.001 gelijk zijn; (Let op: volgens afspraak wordt er afgekapt, niet afgerond)
    // graden moeten exact gelijk zijn (ints)
    // reden: we willen straks ook vergelijken via modulus en argument, in plaats van reeel en imaginair deel
    @Override
    public int hashCode() {
        int hash = 7;
        // voorgestelde code:
        // hash = 53 * hash + (int) (Double.doubleToLongBits(this.getModulus()) ^ (Double.doubleToLongBits(this.getModulus()) >>> 32));
        // aangepast, omdat er gesteld wordt dat modulus op 0.001 gelijk moet zijn:

        // Opgelet! OF we gaan voor een hashcode getallen 'ruimer' als gelijk bestempelen dan voor de equals
        // OF we ronden eerst getallen af voor we ze vergelijken.
        // Dat laatste is wat er gebeurt als we de voorgestelde code beschouwen.
        hash = 53 * hash + (int) (1000 * (this.getModulus()));
        hash = 53 * hash + this.getArgumentInGraden();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        // IDENTIEK dezelfde redenering gebruiken als bij hashCode,
        // anders klopt het niet!!!
        // Of de voorgestelde code gebruiken met omzetting doubleToLongBits.
        if ((int) (1000 * this.getModulus()) - (int) (1000 * other.getModulus()) != 0) {
            return false;
        }
        if (this.getArgumentInGraden() != other.getArgumentInGraden()) {
            return false;
        }
        return true;
    }

    // gebruik de documentatie https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
    // zo weet je snel welke excepties opgeworpen moeten worden.
    @Override
    public int compareTo(Object o) {
        if (o.equals(null)) {
            throw new NullPointerException();
        }
        if (!(o instanceof ComplexNumber)) {
            throw new ClassCastException();
        }
        ComplexNumber ander = (ComplexNumber) o;
        if (Math.abs((int) (1000 * this.getModulus()) - (int) (1000 * ander.getModulus())) >= 1) {
            return (int) (1000 * this.getModulus()) - (int) (1000 * ander.getModulus());
        }
        return this.getArgumentInGraden() - ander.getArgumentInGraden();
        // of gebruik Double.doubleToLongBits(this.getModulus()) != Double.doubleToLongBits(other.getModulus())
        // als je dat ook deed in equals en hashcode!!!
    }
    // wat als je toch wil kunnen vergelijken met reele getallen (doubles)?
    // pas aan!

    @Override
    public String toString() {
        String reeelDeel = "";
        String imaginairDeel = "";
        if (Math.abs(a) >= 0.001) {
            reeelDeel = String.format("%.3f", a);
        }
        if (Math.abs(b) >= 0.001) {
            imaginairDeel = String.format("%.3f", b);
        }
        String resultaat = reeelDeel;
        if (b >= 0.001) {
            if (resultaat.equals("")) {
                resultaat = imaginairDeel + "i";
            } else {
                resultaat += "+" + imaginairDeel + "i";
            }
        } else if (b <= -0.001) {
            resultaat += imaginairDeel + "i";
        }
        if (resultaat.equals("")) {
            resultaat = "0.000";
        }
        return resultaat;
    }

}
