package fr.a4i.yatzy.pointscalculator;

import fr.a4i.yatzy.extraction.ValueExtractionStrategy;
import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import fr.a4i.yatzy.scoring.ScoringStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExtractingPointsCalculatorTest {

    @Mock
    private ValueExtractionStrategy valueExtractionStrategy;

    @Mock
    private ScoringStrategy scoringStrategy;

    @InjectMocks
    private ExtractingPointsCalculator extractingPointCalculator;

    @Test
    void should_call_scoring_strategy_with_extraction_strategy_output() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 2, 3);
        when(valueExtractionStrategy.extract(diceThrow)).thenReturn(new DiceCombination(1, 1));
        when(scoringStrategy.score(new DiceCombination(1, 1))).thenReturn(3);

        assertThat(extractingPointCalculator.calculatePoints(diceThrow)).isEqualTo(3);
    }
}