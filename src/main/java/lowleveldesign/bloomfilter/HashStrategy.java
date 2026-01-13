package lowleveldesign.bloomfilter;

public interface HashStrategy {

    long hash(String input);
}
