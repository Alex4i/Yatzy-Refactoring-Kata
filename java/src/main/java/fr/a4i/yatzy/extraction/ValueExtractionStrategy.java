package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;

import java.util.List;

public interface ValueExtractionStrategy {

    DiceCombination extract(DiceThrow diceThrow);
}
