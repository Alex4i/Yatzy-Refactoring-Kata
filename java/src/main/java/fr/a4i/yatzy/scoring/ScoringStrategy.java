package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;

public interface ScoringStrategy {

    int score(DiceCombination dices);
}
