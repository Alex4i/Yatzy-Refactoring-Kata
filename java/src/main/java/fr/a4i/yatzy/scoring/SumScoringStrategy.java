package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;

public class SumScoringStrategy implements ScoringStrategy{
    @Override
    public int score(DiceCombination values) {
        return values.sum();
    }
}
