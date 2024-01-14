package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NumberExtractionStrategyTest {

    @Test
    void should_return_nothing_when_number_not_found() {
        DiceThrow input = new DiceThrow(1, 1, 2, 3);
        DiceCombination result = new NumberExtractionStrategy(4).extract(input);

        assertThat(result.dices()).isEmpty();
    }

    @Test
    void should_return_all_occurence_of_number_when_found() {
        DiceThrow input = new DiceThrow(1, 1, 2, 3);
        DiceCombination result = new NumberExtractionStrategy(1).extract(input);

        assertThat(result.dices()).containsExactly(1, 1);
    }
}