package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceExtractionStrategyTest {
    @Test
    void should_return_nothing_when_sequence_not_found() {
        DiceThrow input = new DiceThrow(1, 2, 3);
        DiceCombination result = new SequenceExtractionStrategy(List.of(1, 2, 3, 4)).extract(input);

        assertThat(result.dices()).isEmpty();
    }

    @Test
    void should_return_nothing_when_sequence_with_multiple_occurence_not_found() {
        DiceThrow input = new DiceThrow(1, 2, 3);
        DiceCombination result = new SequenceExtractionStrategy(List.of(1, 1, 2)).extract(input);

        assertThat(result.dices()).isEmpty();
    }

    @Test
    void should_return_sequence_when_sequence_found() {
        DiceThrow input = new DiceThrow(1, 1, 2, 3);
        DiceCombination result = new SequenceExtractionStrategy(List.of(1, 1, 3)).extract(input);

        assertThat(result.dices()).containsExactly(1, 1, 3);
    }

    @Test
    void should_return_sequence_when_sequence_with_multiple_occurence_found() {
        DiceThrow input = new DiceThrow(1, 2, 3);
        DiceCombination result = new SequenceExtractionStrategy(List.of(1, 2)).extract(input);

        assertThat(result.dices()).containsExactly(1, 2);
    }
}