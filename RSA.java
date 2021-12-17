import java.math.BigInteger;

public class RSA {


    public static void main(String[] args) {

        // p q e plaintext ciphertext
        BigInteger p = new BigInteger(args[0]);
        BigInteger q = new BigInteger(args[1]);
        BigInteger e = new BigInteger(args[2]);
        BigInteger plaintext = new BigInteger(args[3]);
        BigInteger ciphertext = new BigInteger(args[4]);

        // TODO: Part 2 --> Compute n = pq
        //  use BigInteger class methods .multiply()
        BigInteger n = p.multiply(q);

        // TODO: Part 3 --> (p-1) * (q-1)
        //  use BigInteger class methods
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // TODO: Part 4 --> choose e | 1 < e < O(n)
        //  create a helper method and pass in O(n)
        //  already have e --------


        // TODO: Part 5 --> d = e^(-1*O)
        //  use BigInteger class methods .modInverse(O)
        BigInteger d = e.modInverse(phi);

        String publicKeyE = e.toString();
        String publicKeyN = n.toString();
        String privateKeyD = d.toString();
        String privateKeyN = n.toString();



        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        System.out.println("phi: " + phi);
        System.out.println("e: " + e);

        System.out.println("\nPublic Key e = " + publicKeyE + " n = " + publicKeyN);
        System.out.println("Private Key d = " + privateKeyD + " n = " + privateKeyN);




        // encrypt C=P^e mod n
        BigInteger cipher = plaintext.pow(e.intValue()).mod(n);
        System.out.println("\nCiphertext: " + cipher);

        // decrypt C^d mod n = P
        BigInteger plain = ciphertext.pow(d.intValue()).mod(n);
        System.out.println("Plaintext: " + plain);

    }
}
