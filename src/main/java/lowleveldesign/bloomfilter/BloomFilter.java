package lowleveldesign.bloomfilter;

import java.util.BitSet;
import java.util.List;

public class BloomFilter {

    private final BitSet bitSet;

    private final int bitSetSize;

    private final int numberOfHashFunctions;

    private List<HashStrategy> hashStrategyList;

    private BloomFilter(Builder builder){
        bitSet  = new BitSet(builder.bitSetSize);
        bitSetSize = builder.bitSetSize;
        numberOfHashFunctions = builder.numberOfHashFunctions;
        hashStrategyList = builder.hashStrategyList;
    }

    public void add(String input){

        for(HashStrategy hashStrategy:hashStrategyList){

            long hash = hashStrategy.hash(input);
            int index = (int)(Math.abs(hash) % bitSetSize);
            bitSet.set(index);
        }

    }

    public boolean mayContain(String input){

        boolean isLikelyPresent= true;
        for(HashStrategy hashStrategy:hashStrategyList){
            long hash = hashStrategy.hash(input);
            int index = (int)(Math.abs(hash) % bitSetSize);
            isLikelyPresent = isLikelyPresent && bitSet.get(index);
        }

        return isLikelyPresent;
    }



    public static class Builder{
        private int bitSetSize;

        private int numberOfHashFunctions;

        private List<HashStrategy> hashStrategyList;


        public Builder withBitSetSize(int bitSetSize){

            this.bitSetSize = bitSetSize;
            return this;
        }

        public Builder withNumberOfHashFunctions(int numberOfHashFunctions){
            this.numberOfHashFunctions = numberOfHashFunctions;
            return this;
        }

        public Builder withHashStrategies(List<HashStrategy> hashStrategyList){
            this.hashStrategyList = hashStrategyList;
            return this;
        }

        public BloomFilter build(){

            if(bitSetSize<=0) throw new IllegalArgumentException("bitSetSize should be greater than zero");

            if(numberOfHashFunctions<=0) throw new IllegalArgumentException("numberOfHashFunctions should be greater than zero");

            if(hashStrategyList == null || hashStrategyList.isEmpty()) throw new IllegalArgumentException("Atleast one hashStrategy should be there");

            return new BloomFilter(this);

        }


    }
}
