package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
public class SequenceExtractionStrategy implements ValueExtractionStrategy {

    private final List<Integer> wantedSequence;

    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        // TODO : better for performances with HashSet but this will not work if the wanted sequence contains the same number multiple times
        return new HashSet<>(diceThrow.values()).containsAll(wantedSequence) ? new DiceCombination(wantedSequence) : DiceCombination.empty();
    }
}
