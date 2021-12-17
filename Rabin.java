import java.math.BigInteger;

public class Rabin {


    public static void main(String[] args) {
        // java Rabin.java p q plaintext ciphertext
        // if its only for plaintext just use 0 for ciphertext
        // if its only for ciphertext just use 0 for plaintext

        BigInteger p = new BigInteger(args[0]);
        BigInteger q = new BigInteger(args[1]);
        BigInteger plain = new BigInteger(args[2]);
        BigInteger cipher = new BigInteger(args[3]);
        BigInteger n = p.multiply(q);


        System.out.println("p: " + p.toString());
        System.out.println("n: " + n.toString());

        BigInteger newCipher = plain.pow(2);
        BigInteger cipherResults = newCipher.mod(n);

        System.out.println("cipher text: " + cipherResults.toString());


        BigInteger p1 = p.add(BigInteger.ONE);
        BigInteger q1 = q.add(BigInteger.ONE);
        BigInteger pD4 = p1.divide(new BigInteger("4"));
        BigInteger qD4 = q1.divide(new BigInteger("4"));

        System.out.println("pD4: " + pD4.toString());
        System.out.println("qD4: " + qD4.toString());

        BigInteger a1 = cipher.pow(pD4.intValue());
        BigInteger a1ModP = a1.mod(p);
        BigInteger a1N = a1.negate();
        BigInteger a2NModP = a1N.mod(p);

        BigInteger b1 = cipher.pow(qD4.intValue());
        BigInteger b1ModP = b1.mod(q);
        BigInteger b1N = b1.negate();
        BigInteger b2NModP = b1N.mod(q);



        System.out.println("\nRemainders before Chinese Remainder Theorem");
        System.out.println("a1: " + a1ModP);
        System.out.println("a2: " + a2NModP);
        System.out.println("b1: " + b1ModP);
        System.out.println("b2: " + b2NModP);

        System.out.println("\nPossible results for p1-p4");

        chineseRem(a1ModP, p, b1ModP, q);
        chineseRem(a1ModP, p, b2NModP, q);
        chineseRem(a2NModP, p, b1ModP, q);
        chineseRem(a2NModP, p, b2NModP, q);
    }


    public static void chineseRem(BigInteger a, BigInteger mod1, BigInteger b, BigInteger mod2) {
        // find N by taking all mods and multiplying them
        BigInteger N = mod1.multiply(mod2);

        // Find Ni... by taking N and dividing it by the respected mod
        BigInteger Ni1 = N.divide(mod1);
        BigInteger Ni2 = N.divide(mod2);

        // get the inverse Ni... % mod...
        BigInteger x1 = Ni1.modInverse(mod1);
        BigInteger x2 = Ni2.modInverse(mod2);


        // get product of all of them
        BigInteger biNiXi1 = a.multiply(Ni1).multiply(x1);
        BigInteger biNiXi2 = b.multiply(Ni2).multiply(x2);

        // add all of them together
        BigInteger add = biNiXi1.add(biNiXi2);
        BigInteger results = add.mod(N);
        System.out.println("a,b " + results.toString());

    }

}




























//        System.out.println("a: " + a);
//                System.out.println("b: " + b);
//                System.out.println("mod1: " + mod1);
//                System.out.println("mod2: " + mod2);