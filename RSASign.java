import java.math.BigInteger;

public class RSASign {

    public static void main(String[] args) {

        BigInteger key1 = new BigInteger(args[0]);
        BigInteger key2mod = new BigInteger(args[1]);
        BigInteger plaintext = new BigInteger(args[2]);
        BigInteger ciphertext = new BigInteger(args[3]);

        // encrypt C=P^e mod n
        BigInteger cipher = plaintext.pow(key1.intValue()).mod(key2mod);
        System.out.println("\nCiphertext: " + cipher);

        // decrypt C^d mod n = P
        BigInteger plain = ciphertext.pow(key1.intValue()).mod(key2mod);
        System.out.println("Plaintext: " + plain);



        // TODO: need to do the verifying signature
    }



}
