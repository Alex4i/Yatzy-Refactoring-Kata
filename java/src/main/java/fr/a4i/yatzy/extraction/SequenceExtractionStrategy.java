package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SequenceExtractionStrategy implements ValueExtractionStrategy {

    private final List<Integer> wantedSequence;

    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        List<Integer> dicesCopy = new ArrayList<>(diceThrow.values());
        boolean matched = wantedSequence.stream()
            .map(dicesCopy::remove)
            .reduce(true, (acc, el) -> acc && el);
        return matched ? new DiceCombination(wantedSequence) : DiceCombination.empty();
    }
}
