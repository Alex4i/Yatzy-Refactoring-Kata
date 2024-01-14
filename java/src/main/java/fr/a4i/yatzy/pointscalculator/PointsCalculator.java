package fr.a4i.yatzy.pointscalculator;

import fr.a4i.yatzy.model.DiceThrow;

public interface PointsCalculator {

    int calculatePoints(DiceThrow diceThrow);
}
