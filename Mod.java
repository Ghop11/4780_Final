import java.math.BigInteger;

public class Mod {

    public static void main(String[] args) {

        // find -26 mod 15   -26 15
        // find inverse of 8 in Z11  8 11
        BigInteger num1 = new BigInteger(args[1]);
        BigInteger num2 = new BigInteger(args[2]);

        if (args[0].equals("mod")){
            System.out.println( num1 + " mod " + num2 + " = " + num1.mod(num2));
        }
        else if (args[0].equals("modInverse")){
            System.out.println(num1 + " modInverse " + num2 + " = " + num1.modInverse(num2));
        } else {
            BigInteger num3 = new BigInteger(args[3]);
            System.out.println(num1.pow(num2.intValue()).mod(num3));
            System.out.println(num1.modPow(num2, num3));
        }
    }

}
