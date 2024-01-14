package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FixedPointScoringStrategyTest {

    @Mock
    private DiceCombination diceCombination;

    @Test
    void should_return_0_when_dice_combination_is_not_failed() {
        when(diceCombination.isSuccess()).thenReturn(false);
        assertThat(new FixedPointScoringStrategy(8).score(diceCombination)).isZero();
    }

    @Test
    void should_return_fixed_value_when_dice_combination_is_success() {
        when(diceCombination.isSuccess()).thenReturn(true);
        assertThat(new FixedPointScoringStrategy(8).score(diceCombination)).isEqualTo(8);
    }
}