package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NumberExtractionStrategy implements ValueExtractionStrategy {

    private final Integer wantedNumber;

    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        return new DiceCombination(diceThrow.values()
            .stream()
            .filter(i -> i.equals(wantedNumber))
            .toList());
    }
}
