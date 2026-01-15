package lowleveldesign.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;


        for (char c : word.toCharArray()) {

            current = current.getChildren().computeIfAbsent(c, ch -> new TrieNode());

        }

        current.setEndOfWord(true);
        current.incrementFrequency();
    }

    public TrieNode searchPrefix(String word) {

        TrieNode current = root;


        for (char c : word.toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return null;
            }
            current = node;

        }

        return current;

    }

    public List<Suggestion> collectSuggestions(TrieNode trieNode, String word) {

        List<Suggestion> suggestions = new ArrayList<>();

        collect(trieNode, word, suggestions);

        return suggestions;
    }

    private void collect(TrieNode trieNode, String prefix, List<Suggestion> suggestions) {

        if (trieNode.isEndOfWord()) {

            suggestions.add(new Suggestion(
                    prefix,
                    trieNode.getFrequency()
            ));
        }

        for (Character ch : trieNode.getChildren().keySet()) {

            collect(trieNode.getChildren().get(ch), prefix + ch, suggestions);
        }

    }
}
