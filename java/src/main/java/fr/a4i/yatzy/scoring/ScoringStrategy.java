package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;

import java.util.List;

public interface ScoringStrategy {

    int score(DiceCombination dices);
}
