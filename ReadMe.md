| Author | Date | Course # | Class Name |
|-----|-----|----|-----|
|GHop11|Dec 8, 2021| CS 4780 | Cryptography & Info Security | 

# Final Notes
#### To understand topics visit FinalTopic.md for a better break down of all covered topics
#### To learn how to run the code read below


## Rabin

#### To run program from the terminal: 
- java Rabin.java p q plaintext ciphertext
- if you don't need either plaintext or cipher text
- - use a 0 to in their respected position


        Examples: 

        // only need to encrypted
        java Rabin.java 43 31 29 0

        // only need to decrypt
        java Rabin.java 43 31 0 784

        // if you need to encrypt and decrypt two un related plaintext and ciphertext
        java Rabin.java 43 31 29 784



---
## ElGamal
#### To run program from the terminal: 
- java ElGamal.java p d e1 r plaintext ciphertext1 ciphertext2
- if you don't need either plaintext or cipher text
- - use a 0 to in their respected position


        Examples: 
    
        // only need to encrypted
        java ElGamal.java 1327 512 5 103 15 0 0

        // only need to decrypt
        java ElGamal.java 1327 512 5 103 0 1298 341

        // if you need to encrypt and decrypt two un related plaintext and ciphertext
        java ElGamal.java 1327 512 5 103 15 1298 341




## RSA 
-  java RSA.java p q e plaintext ciphertext
- if you don't need either plaintext or cipher text
- - Use a 0 to in their respected position
- Based on quiz questions

java RSA.java 19 13 e plaintext ciphertext
        Examples: 

        // only need to encrypted
        java RSA.java 131 241 101 113 0

        // only need to decrypt
        java RSA.java 131 241 101 0 5423

        // if you need to encrypt and decrypt two un related plaintext and ciphertext
        java RSA.java 131 241 101 113 5423


-----


## DSS
-  java DSS.java p q d e0 r plaintext S1 S2
- if you don't need either plaintext or cipher text
- - Use a 0 to in their respected position
- Based on quiz questions


        Examples: 

        // Sign
        java DSS.java 8081 101 61 3 71 5000 0 0
        Results: 
        e1: 6968
        e2: 2038
        S1: 54
        S2: 40


        // verify
        java DSS.java 8081 101 61 3 71 5000 0 0

java DSS.java 743 53 42 5 13 100 200 23 36





------

## Mod
-  java Mod.java argument (num1) (num2)
- - argument: mod or modInverse
    

        mod:
        - java Mod.java mod (num1) (num2)
        - num1 % num2
        - example 1: 27 % 5 = 2
        
        modInverse:
        - java Mod.java modInverse (num1) (num2)
        - example 2:  7^-1 mod 10 = 3


      










-------
