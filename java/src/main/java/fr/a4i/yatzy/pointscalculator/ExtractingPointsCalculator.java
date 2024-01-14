package fr.a4i.yatzy.pointscalculator;

import fr.a4i.yatzy.extraction.ValueExtractionStrategy;
import fr.a4i.yatzy.model.DiceThrow;
import fr.a4i.yatzy.scoring.ScoringStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExtractingPointsCalculator implements PointsCalculator {

    private final ValueExtractionStrategy valueExtractionStrategy;
    private final ScoringStrategy scoringStrategy;

    @Override
    public int calculatePoints(DiceThrow diceThrow) {
        return scoringStrategy.score(valueExtractionStrategy.extract(diceThrow));
    }
}
