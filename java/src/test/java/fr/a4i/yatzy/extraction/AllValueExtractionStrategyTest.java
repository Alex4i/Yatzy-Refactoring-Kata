package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllValueExtractionStrategyTest {

    @Test
    void should_return_all_values() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 2, 3, 4);
        DiceCombination result = new AllValueExtractionStrategy().extract(diceThrow);

        assertThat(result.dices()).containsExactly(1, 1, 2, 3, 4);
    }

}