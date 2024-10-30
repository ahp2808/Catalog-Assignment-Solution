import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.math.BigInteger;

public class Poly_Soln {

    public static void main(String[] args) {

        try {
            // Load and parse JSON data from the file
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("testCase1.json"));

            // Calculate the constant term
            BigInteger constantTerm = calculateConstantTerm(rootNode);
            System.out.println("The constant term c is: " + constantTerm);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BigInteger calculateConstantTerm(JsonNode data) {
        // Extract the number of roots (k)
        JsonNode keysNode = data.get("keys");
        int k = keysNode.get("k").asInt();

        // Collect roots in decimal form
        BigInteger product = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            JsonNode rootNode = data.get(String.valueOf(i));
            int base = rootNode.get("base").asInt();
            String value = rootNode.get("value").asText();
            BigInteger decimalValue = new BigInteger(value, base); // Convert to decimal
            product = product.multiply(decimalValue); // Calculate the product of roots
        }

        // Adjust the sign of the constant term 'c' based on k (odd or even)
        BigInteger constantTerm = (k % 2 == 0) ? product : product.negate();
        return constantTerm;
    }
}