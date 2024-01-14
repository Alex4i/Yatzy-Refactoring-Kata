package fr.a4i.yatzy.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiceThrowTest {

    @Test
    void should_validate_dice_values_on_construction() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(null);
        input.add(0);
        input.add(2);
        input.add(7);
        assertThatThrownBy(() -> new DiceThrow(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}