package lowleveldesign.autocomplete;

import java.util.List;
import java.util.stream.Collectors;

public class AutoCompleteSystem {

    private final Trie trie;
    private final int maxSuggestions;

    private final RankingStrategy rankingStrategy;

    private AutoCompleteSystem(int maxSuggestions, RankingStrategy rankingStrategy) {
        this.trie = new Trie();
        this.maxSuggestions = maxSuggestions;
        this.rankingStrategy = rankingStrategy;
    }

    public void addWord(String word) {

        trie.insert(word.toLowerCase());
    }

    public void addWords(List<String> words) {
        words.forEach(this::addWord);
    }

    public List<String> getSuggestions(String word) {

        TrieNode trieNode = trie.searchPrefix(word);

        List<Suggestion> suggestions = trie.collectSuggestions(trieNode, word);

        return rankingStrategy.rank(suggestions)
                .stream()
                .limit(maxSuggestions)
                .map(Suggestion::getWord)
                .collect(Collectors.toList());
    }


    public static class Builder {
        private RankingStrategy rankingStrategy = new FrequencyBasedRanking(); // Default strategy
        private int maxSuggestions = 10; // Default limit

        public Builder withRankingStrategy(RankingStrategy strategy) {
            this.rankingStrategy = strategy;
            return this;
        }

        public Builder withMaxSuggestions(int max) {
            this.maxSuggestions = max;
            return this;
        }

        public AutoCompleteSystem build() {
            return new AutoCompleteSystem(maxSuggestions, rankingStrategy);
        }
    }

}
