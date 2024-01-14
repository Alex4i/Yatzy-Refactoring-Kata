package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateExtractionStrategyTest {
    @Test
    void should_return_nothing_when_not_enough_duplicate_found() {
        DiceThrow diceThrow = new DiceThrow(3, 3, 4);
        DiceCombination result = new DuplicateExtractionStrategy(3, Comparator.naturalOrder()).extract(diceThrow);

        assertThat(result.dices()).isEmpty();
    }

    @Test
    void should_return_n_times_value_when_n_occurence_found() {
        DiceThrow diceThrow = new DiceThrow(3, 3, 4);
        DiceCombination result = new DuplicateExtractionStrategy(2, Comparator.naturalOrder()).extract(diceThrow);

        assertThat(result.dices()).containsExactly(3, 3);
    }

    @Test
    void should_return_n_times_value_when_more_than_n_occurence_found() {
        DiceThrow diceThrow = new DiceThrow(3, 3, 3, 4);
        DiceCombination result = new DuplicateExtractionStrategy(2, Comparator.naturalOrder()).extract(diceThrow);

        assertThat(result.dices()).containsExactly(3, 3);
    }

    @Test
    void should_return_value_according_to_comparator_when_multiple_satisfying_duplicate_found() {
        DiceThrow diceThrow = new DiceThrow(4, 4, 5, 5, 5);
        DiceCombination result = new DuplicateExtractionStrategy(2, Comparator.naturalOrder()).extract(diceThrow);

        assertThat(result.dices()).containsExactly(4, 4);
    }
}