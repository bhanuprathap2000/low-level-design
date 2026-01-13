package lowleveldesign.bloomfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BloomFilterDemo {

    static int bitSetSize = 10000;
    static int numOfHashFunctions = 2;

    static int expectedInsertions = 1000;


    public static void main(String[] args) {


        List<HashStrategy> hashStrategyList = List.of(
                HashStrategyFactory.create(HashType.FNV1A),
                HashStrategyFactory.create(HashType.DJB2)
        );


        BloomFilter filter = new BloomFilter.Builder()
                .withBitSetSize(bitSetSize)
                .withNumberOfHashFunctions(numOfHashFunctions)
                .withHashStrategies(hashStrategyList)
                .build();

        filter.add("Bhanu");

        boolean present =  filter.mayContain("Gowthami");

        System.out.println(present);

        // --- 4. Add elements to the filter ---
        System.out.println("\n--- Adding elements to the filter ---");
        List<String> insertedElements = new ArrayList<>();
        for (int i = 0; i < expectedInsertions; i++) {
            String element = "user" + i + "@example.com";
            insertedElements.add(element);
            filter.add(element);
        }
        System.out.println(expectedInsertions + " elements have been added.");

        // --- 5. Test for presence (no false negatives) ---
        System.out.println("\n--- Verifying no false negatives ---");
        boolean hasFalseNegatives = false;
        for (String element : insertedElements) {
            if (!filter.mayContain(element)) {
                System.err.println("FALSE NEGATIVE DETECTED FOR: " + element);
                hasFalseNegatives = true;
                break;
            }
        }
        if (!hasFalseNegatives) {
            System.out.println("Success! No false negatives found. All inserted elements were detected.");
        }

        // --- 6. Test for false positives ---
        System.out.println("\n--- Testing for false positives ---");
        int testSetSize = 10000;
        int falsePositivesCount = 0;
        for (int i = 0; i < testSetSize; i++) {
            String randomElement = UUID.randomUUID().toString();
            if (filter.mayContain(randomElement)) {
                falsePositivesCount++;
            }
        }
        System.out.println("Number of false positives found: " + falsePositivesCount + " out of " + testSetSize + " random items.");
    }


}