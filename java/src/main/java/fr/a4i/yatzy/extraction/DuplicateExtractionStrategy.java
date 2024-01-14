package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
public class DuplicateExtractionStrategy implements ValueExtractionStrategy {

    private final int wantedOccurence;
    private final Comparator<Integer> valueComparator;

    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        Optional<Integer> foundValue = new HashSet<>(diceThrow.values())
            .stream()
            .sorted(valueComparator)
            .filter(value -> Collections.frequency(diceThrow.values(), value) >= wantedOccurence)
            .findFirst();

        return new DiceCombination(
            foundValue.map(v -> Collections.nCopies(wantedOccurence, v))
                .orElse(Collections.emptyList())
        );
    }
}
