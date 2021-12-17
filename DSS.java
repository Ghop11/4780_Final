import java.math.BigInteger;

public class DSS {


    public static void main(String[] args) {

        // java DSS.java p q d e0 r plaintext S1 S2
        BigInteger p = new BigInteger(args[0]);
        BigInteger q = new BigInteger(args[1]);
        BigInteger d = new BigInteger(args[2]);
        BigInteger e0 = new BigInteger(args[3]);
        BigInteger r = new BigInteger(args[4]);
        BigInteger plainText = new BigInteger(args[5]);
        BigInteger S1 = new BigInteger(args[6]);
        BigInteger S2 = new BigInteger(args[7]);


        // find e1 = e0^(p−1)/q mod p
        BigInteger exp = p.subtract(BigInteger.ONE).divide(q);
        BigInteger e1 = e0.pow(exp.intValue()).mod(p);

        // find e2  =  e1^d  mod  p
        BigInteger e2 = e1.pow(d.intValue()).mod(p);

        System.out.println("e1: " + e1);
        System.out.println("e2: " + e2);

        // find (e1^r mod p ) mod q
        BigInteger s1 = (e1.pow(r.intValue()).mod(p)).mod(q);

        // find ((h(M) + dS1) x r^-1) mod q
        BigInteger dS1 = d.multiply(s1);
        BigInteger s2Par = plainText.add(dS1);
        BigInteger rInverse = r.modInverse(q);
        BigInteger s2 = s2Par.multiply(rInverse).mod(q);


        System.out.println("S1: " + s1);
        System.out.println("S2: " + s2);


        // TODO: need to do the verifying signature
        //  V = (e1^(MxS2^-1) x e2^(S1xS2^-1) mod p) mod q
        //  V === S1 ; it is verified

        BigInteger s2ModInverse = S2.modInverse(q);
        BigInteger exp1 = plainText.multiply(s2ModInverse);
        BigInteger part1 = e1.modPow(exp1, p);
        BigInteger exp2 = S1.multiply(s2ModInverse);

        BigInteger part2 = e2.modPow(exp2, p);


        BigInteger firstMod = part1.multiply(part2).mod(p);
        BigInteger secondMod = firstMod.mod(q);


        System.out.println("Verify: S1 needs to equal verified results");
        System.out.println("Verify: V = " + secondMod + " ; S1 = " + S1);
    }

}
