import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s;
        System.out.print("Input: ");
        while (!scan.hasNext("quit")){
            s=scan.nextLine();
            System.out.println(prepear(s));
            System.out.print("Input: ");
        }
        System.out.println("Power off");
    }
    public static String prepear(String s){
        String stemp="";
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){stemp=stemp+" "+s.charAt(i);}
            if(s.charAt(i)=='('){stemp=stemp+s.charAt(i)+" ";}
            if(s.charAt(i)!='(' && s.charAt(i)!=')'){stemp=stemp+s.charAt(i);}}
        return getans(stemp);
    }
    public static String getans(String s){
        char[] ch = s.toCharArray();
        int mark=0,lbask=0,rbask=0;
        for(int i =1;i<ch.length;i++){
            if((ch[i]=='+' ||ch[i]=='-' ||ch[i]=='*' || ch[i]==':')&&(ch[i-1]=='+' ||ch[i-1]=='-' ||ch[i-1]=='*' || ch[i-1]==':')){mark=1;}
            if((ch[i-1]=='/')&&(ch[i]=='0')){mark=2;}
            if(ch[i-1]=='('){lbask++;}
            if(ch[i-1]==')'){rbask++;}
        }
        if(ch[ch.length-1]=='('){lbask++;}
        if(ch[ch.length-1]==')'){rbask++;}
        if(rbask!=lbask){mark=1;}
        switch (mark){
            case 0:{return("Answer: "+count(s));}
            case 1:{return("Incorrect input");}
            case 2:{return("Division by zero");}
        }
        return "unexpected error";
    }
    public static Fraction count(String input_sting) {
        String[] elements = transform(input_sting.split(" "));
        for (String elem : elements){System.out.print(elem+" ");}
        Fraction[] eleents_queune = new Fraction[elements.length];
        int cur = -1;
        for (String element : elements) {
            if (isopr(element)) {
                Fraction operand2 = eleents_queune[cur--];
                Fraction operand1 = eleents_queune[cur--];
                switch (element) {
                    case "+":
                        eleents_queune[++cur] = operand1.add(operand2);
                        break;
                    case "-":
                        eleents_queune[++cur] = operand1.subtract(operand2);
                        break;
                    case "*":
                        eleents_queune[++cur] = operand1.multiply(operand2);
                        break;
                    case ":":
                        eleents_queune[++cur] = operand1.divide(operand2);
                        break;
                }
            } else {
                eleents_queune[++cur] = new Fraction(element);
            }
        }
        return eleents_queune[cur];
    }
    public static String[] transform(String[] elements) {
        String transformed = "";
        String[] queue = new String[elements.length];
        int cur = -1;
        for (String element : elements) {
            if (isopr(element)) {
                while (cur >= 0 && pas(element) <= pas(queue[cur])) {
                    transformed=transformed+""+queue[cur--]+" ";
                }
                queue[++cur] = element;
            } else if (element.equals("(")) {
                queue[++cur] = element;
            } else if (element.equals(")")) {
                while (!queue[cur].equals("(")) {
                    transformed=transformed+""+queue[cur--]+" ";
                }
                cur--;
            } else {
                transformed=transformed+""+element+" ";
            }
        }
        while (cur >= 0) {
            transformed=transformed+""+queue[cur--]+" ";
        }
        return transformed.trim().split(" ");
    }
    public static boolean isopr(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals(":");
    }
    public static int pas(String str) {
        switch (str) {
            case "+":
            case "-":
                return 1;
            case "*":
            case ":":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
    public static class Fraction {
        private int numerator;
        private int denominator;
        public Fraction(String fraction) {
            String[] parts = fraction.split("/");
            this.numerator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);
        }
        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        public Fraction add(Fraction other) {
            int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }
        public Fraction subtract(Fraction other) {
            int newNumerator = this.numerator * other.denominator - this.denominator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }
        public Fraction multiply(Fraction other) {
            int newNumerator = this.numerator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }
        public Fraction divide(Fraction other) {
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }
        public Fraction simplify() {
            int rdc = reduction(numerator, denominator);
            if (numerator*denominator>0){return new Fraction(numerator / rdc, denominator / rdc);}
            else {return new Fraction(numerator / abs(rdc),denominator / abs(rdc));}

        }
        private int reduction(int a, int b) {
            return b == 0 ? a : reduction(b, a % b);
        }
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}