package fr.a4i.yatzy;

import fr.a4i.yatzy.extraction.*;
import fr.a4i.yatzy.model.DiceThrow;
import fr.a4i.yatzy.pointscalculator.ExtractingPointsCalculator;
import fr.a4i.yatzy.pointscalculator.PointsCalculator;
import fr.a4i.yatzy.scoring.FixedPointScoringStrategy;
import fr.a4i.yatzy.scoring.SumScoringStrategy;
import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;

@UtilityClass
public class YatzyPoints {

    public int ones(DiceThrow diceThrow) {
        return numberCounter(1).calculatePoints(diceThrow);
    }

    public int twos(DiceThrow diceThrow) {
        return numberCounter(2).calculatePoints(diceThrow);
    }

    public int threes(DiceThrow diceThrow) {
        return numberCounter(3).calculatePoints(diceThrow);
    }

    public int fours(DiceThrow diceThrow) {
        return numberCounter(4).calculatePoints(diceThrow);
    }

    public int fives(DiceThrow diceThrow) {
        return numberCounter(5).calculatePoints(diceThrow);
    }

    public int sixes(DiceThrow diceThrow) {
        return numberCounter(6).calculatePoints(diceThrow);
    }

    public int onePair(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new DuplicateExtractionStrategy(2, Comparator.reverseOrder()), new SumScoringStrategy()).calculatePoints(diceThrow);
    }

    public int twoPairs(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(
            new CompositeValueExtractionStrategy(
                new DuplicateExtractionStrategy(2, Comparator.reverseOrder()),
                new DuplicateExtractionStrategy(2, Comparator.reverseOrder())
            ),
            new SumScoringStrategy()
        ).calculatePoints(diceThrow);
    }

    public int threeOfAKind(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new DuplicateExtractionStrategy(3, Comparator.reverseOrder()), new SumScoringStrategy()).calculatePoints(diceThrow);
    }

    public int fourOfAKind(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new DuplicateExtractionStrategy(4, Comparator.reverseOrder()), new SumScoringStrategy()).calculatePoints(diceThrow);
    }

    public int smallStraight(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new SequenceExtractionStrategy(List.of(1, 2, 3, 4, 5)), new FixedPointScoringStrategy(15)).calculatePoints(diceThrow);
    }

    public int largeStraight(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new SequenceExtractionStrategy(List.of(2, 3, 4, 5, 6)), new FixedPointScoringStrategy(20)).calculatePoints(diceThrow);
    }

    public int fullHouse(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(
            new CompositeValueExtractionStrategy(
                new DuplicateExtractionStrategy(3, Comparator.reverseOrder()),
                new DuplicateExtractionStrategy(2, Comparator.reverseOrder())
            ),
            new SumScoringStrategy()
        ).calculatePoints(diceThrow);
    }

    public int yatzy(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new DuplicateExtractionStrategy(5, Comparator.reverseOrder()), new FixedPointScoringStrategy(50)).calculatePoints(diceThrow);
    }

    public int chance(DiceThrow diceThrow) {
        return new ExtractingPointsCalculator(new AllValueExtractionStrategy(), new SumScoringStrategy()).calculatePoints(diceThrow);
    }

    private PointsCalculator numberCounter(int number) {
        return new ExtractingPointsCalculator(new NumberExtractionStrategy(number), new SumScoringStrategy());
    }

}
