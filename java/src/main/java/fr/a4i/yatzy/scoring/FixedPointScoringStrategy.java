package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FixedPointScoringStrategy implements ScoringStrategy {

    private final int fixedPoint;


    @Override
    public int score(DiceCombination combination) {
        return combination.isSuccess() ? fixedPoint : 0;
    }
}
