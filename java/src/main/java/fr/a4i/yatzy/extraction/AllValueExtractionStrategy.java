package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;


public class AllValueExtractionStrategy implements ValueExtractionStrategy {
    @Override
    public DiceCombination extract(DiceThrow diceThrow) {
        return new DiceCombination(diceThrow.values());
    }
}
