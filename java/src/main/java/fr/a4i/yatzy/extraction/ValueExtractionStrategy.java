package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;

public interface ValueExtractionStrategy {

    DiceCombination extract(DiceThrow diceThrow);
}
