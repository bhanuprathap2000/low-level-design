package lowleveldesign.autocomplete;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabeticalRankingStrategy implements RankingStrategy {
    @Override
    public List<Suggestion> rank(List<Suggestion> suggestions) {

        return suggestions.stream()
                .sorted(Comparator.comparing(Suggestion::getWeight))
                .collect(Collectors.toList());
    }
}
