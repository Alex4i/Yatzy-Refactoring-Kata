package fr.a4i.yatzy.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.a4i.yatzy.model.DiceCombination.merge;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiceCombinationTest {

    @Test
    void should_validate_dice_values_on_construction() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(null);
        input.add(0);
        input.add(2);
        input.add(7);
        assertThatThrownBy(() -> new DiceCombination(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isFailed_should_be_true_when_empty_values() {
        DiceCombination diceCombination = new DiceCombination();
        assertThat(diceCombination.isFailed()).isTrue();
        assertThat(diceCombination.isSuccess()).isFalse();
    }

    @Test
    void isFailed_should_be_false_when_not_empty_values() {
        DiceCombination diceCombination = new DiceCombination(1);
        assertThat(diceCombination.isFailed()).isFalse();
        assertThat(diceCombination.isSuccess()).isTrue();
    }

    @Test
    void merge_should_have_value_from_all_combination() {
        DiceCombination diceCombination1 = new DiceCombination(1, 2, 2);
        DiceCombination diceCombination2 = new DiceCombination(2, 5, 4);
        DiceCombination diceCombination3 = new DiceCombination(1);
        assertThat(merge(List.of(diceCombination1, diceCombination2, diceCombination3)).dices())
            .containsExactlyInAnyOrder(1, 2, 2, 2, 5, 4, 1);

    }
}