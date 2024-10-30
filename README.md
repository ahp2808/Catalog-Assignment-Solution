# Catalog-Assignment-Solution

Steps to run the code:
1. In your IDE, add the Classpath of lib folder.
               OR
   ADD the contents of the lib folder in the LIBRARIES of your IDE
     
2. Run the java code for test case 1, and change the string value(in parenthesis after "new File") in the line 16th to testCase2:
       Line 16th in Poly_Soln.java
       JsonNode rootNode = mapper.readTree(new File("testCase1.json"));

Steps to solve the Problem:
1. We will use the following formula to compute the Constant:
    c=  (−r_1 )(−r_2 )⋯(−r_k )
 => c = (−1)^k (r_1 * r_2 *.. * r_k )

2. Using the Base with Values given in the json format, we will compute the r values.
3. For the test case 1, we have
     k=3, 𝑐 = −(4 * 7 * 12)
      c = −336
