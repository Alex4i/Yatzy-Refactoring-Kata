package fr.a4i.yatzy.validator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiceValidatorTest {

    @Test
    void should_throw_when_null_value() {
        List<Integer> input = new ArrayList<>();
        input.add(null);
        input.add(6);
        assertThatThrownBy(() -> DiceValidator.validateDice(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Illegal dice values: [null]");
    }

    @Test
    void should_throw_when_value_not_in_dice_values() {
        List<Integer> input = List.of(0, 6, 9);
        assertThatThrownBy(() -> DiceValidator.validateDice(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Illegal dice values: [0, 9]");
    }

    @Test
    void should_not_throw_when_value_in_dice_values() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> DiceValidator.validateDice(input));
    }

}