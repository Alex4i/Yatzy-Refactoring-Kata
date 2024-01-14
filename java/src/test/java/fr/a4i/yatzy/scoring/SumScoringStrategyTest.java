package fr.a4i.yatzy.scoring;

import fr.a4i.yatzy.model.DiceCombination;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SumScoringStrategyTest {

    @Mock
    private DiceCombination diceCombination;

    @Test
    void should_return_sum_from_dice_combination() {
        when(diceCombination.sum()).thenReturn(18);

        assertThat(new SumScoringStrategy().score(diceCombination)).isEqualTo(18);
    }

}