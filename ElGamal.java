import java.math.BigInteger;

public class ElGamal {

    public static void main(String[] args) {


        // given p, d, e1, r, plaintext, ciphertext1 and ciphertext2
        // (use 0 if not needed for plaintext or ciphertext)
        // KEY GEN
        BigInteger p = new BigInteger(args[0]);
        BigInteger d = new BigInteger(args[1]);
        BigInteger e1 = new BigInteger(args[2]);
        BigInteger r = new BigInteger(args[3]);
        BigInteger plainText = new BigInteger(args[4]);
        BigInteger cipherText1 = new BigInteger(args[5]);
        BigInteger cipherText2 = new BigInteger(args[6]);

        BigInteger e2pow = e1.pow(d.intValue());
        BigInteger e2 = e2pow.mod(p);
        System.out.println("Public Key: (" + e1 + ", " + e2 + ", " + p + ")");
        System.out.println("Private Key: " + d);

        System.out.println("\n");

        // encrypt
        BigInteger c1 = e1.pow(r.intValue()).mod(p);
        BigInteger c2 = (plainText.multiply(e2.pow(r.intValue()))).mod(p);
        System.out.println("CipherText: (" + c1 + ", " + c2 + ")\n");


        // decrypt
        BigInteger plain = (cipherText2.multiply(cipherText1.pow((p.subtract(BigInteger.ONE).subtract(d)).intValue()))).mod(p);
        System.out.println("Plaintext: " + plain);



        // Signature
        // s1 = e1^r mod p
        // s2 = ((M - d x s1)x r^-1 )mod p

        BigInteger s1 = e1.pow(r.intValue()).mod(p);

        BigInteger pMinusOne = p.subtract(BigInteger.ONE);
        BigInteger dS1 = d.multiply(s1);
        BigInteger mMinus_dS1 = plainText.subtract(dS1);
        BigInteger rInverse = r.modInverse(pMinusOne);
        BigInteger s2 = mMinus_dS1.multiply(rInverse).mod(pMinusOne);

        System.out.println("\nSignatures: ");
        System.out.println("S1 = " + s1);
        System.out.println("S2 = " + s2);


        // TODO: need to do the verifying signature
        // e2^s1 x s1^s2 mod p
        // e1^M mod p
        // these are both supose to equal
        }
    }

