package lowleveldesign.autocomplete;

import java.util.List;

public interface RankingStrategy {

    List<Suggestion> rank(List<Suggestion> suggestions);
}
