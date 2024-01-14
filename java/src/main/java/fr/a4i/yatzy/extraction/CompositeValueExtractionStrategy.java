package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fr.a4i.yatzy.model.DiceCombination.empty;
import static fr.a4i.yatzy.model.DiceCombination.merge;

@RequiredArgsConstructor
public class CompositeValueExtractionStrategy implements ValueExtractionStrategy {

    private final List<ValueExtractionStrategy> delegates;

    public CompositeValueExtractionStrategy(ValueExtractionStrategy... delegates) {
        this.delegates = Arrays.asList(delegates);
    }

    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        List<Integer> diceValuesCopy = new ArrayList<>(diceThrow.values());
        List<DiceCombination> extractedLists = delegates.stream()
            .map(extractor -> {
                DiceCombination extractedValues = extractor.extract(new DiceThrow(diceValuesCopy));
                diceValuesCopy.removeAll(extractedValues.dices());
                return extractedValues;
            })
            .takeWhile(DiceCombination::isSuccess)
            .toList();
        return extractedLists.size() == delegates.size() ? merge(extractedLists) : empty();
    }
}
