package lowleveldesign.autocomplete;

import java.util.List;

public class AutocompleteDemo {

    public static void main(String[] args) {

        System.out.println("----------- SCENARIO 1: Frequency-based Ranking -----------");

        AutoCompleteSystem autoCompleteSystem = new AutoCompleteSystem.Builder().
                withMaxSuggestions(10).
                withRankingStrategy(new FrequencyBasedRanking())
                .build();

        // 2. Feed data into the system
        // 'canada' is added most frequently, followed by 'car'
        List<String> dictionary = List.of(
                "car", "cat", "cart", "cartoon", "canada", "candy",
                "car", "canada", "canada", "car", "canada", "canopy", "captain"
        );
        autoCompleteSystem.addWords(dictionary);

        // 3. Get suggestions for a prefix
        String prefix1 = "ca";
        List<String> suggestions1 = autoCompleteSystem.getSuggestions(prefix1);
        System.out.println("Suggestions for '" + prefix1 + "': " + suggestions1);

        String prefix2 = "car";
        List<String> suggestions2 = autoCompleteSystem.getSuggestions(prefix2);
        System.out.println("Suggestions for '" + prefix2 + "': " + suggestions2);


        System.out.println("\n----------- SCENARIO 2: Alphabetical Ranking -----------");

        System.out.println("\n----------- SCENARIO 2: Alphabetical Ranking -----------");

        // 1. Build a new system with the alphabetical strategy
        AutoCompleteSystem autoCompleteSystemByAlpha = new AutoCompleteSystem.Builder().
                withMaxSuggestions(10).
                withRankingStrategy(new AlphabeticalRankingStrategy())
                .build();

        // 2. Feed the same data
        autoCompleteSystemByAlpha.addWords(dictionary);

        // 3. Get suggestions for the same prefix
        List<String> suggestions3 = autoCompleteSystemByAlpha.getSuggestions(prefix1);
        System.out.println("Suggestions for '" + prefix1 + "' (alphabetical): " + suggestions3);





    }
}
