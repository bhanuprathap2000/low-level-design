package lowleveldesign.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Map<Character,TrieNode> children = new HashMap<>();

    private int frequency;

    private boolean endOfWord;


    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency(){
        frequency++;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
