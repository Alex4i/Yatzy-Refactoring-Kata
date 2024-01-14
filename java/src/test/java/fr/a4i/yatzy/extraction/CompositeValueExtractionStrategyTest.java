package fr.a4i.yatzy.extraction;

import fr.a4i.yatzy.model.DiceCombination;
import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompositeValueExtractionStrategyTest {

    @Mock
    private ValueExtractionStrategy valueExtractor1;

    @Mock
    private ValueExtractionStrategy valueExtractor2;

    @Mock
    private ValueExtractionStrategy valueExtractor3;

    @Test
    void should_return_nothing_when_no_delegates() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 2, 3);
        DiceCombination result = new CompositeValueExtractionStrategy().extract(diceThrow);
        assertThat(result).isEqualTo(DiceCombination.empty());
    }

    @Test
    void should_call_single_delegate_when_only_one() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 2, 3);
        when(valueExtractor1.extract(diceThrow)).thenReturn(new DiceCombination(1));

        DiceCombination result = new CompositeValueExtractionStrategy(valueExtractor1).extract(diceThrow);

        assertThat(result).isEqualTo(new DiceCombination(1));
    }


    @Test
    void should_remove_extracted_value_and_duplicates_between_delegate_calls() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 1, 2, 3);
        when(valueExtractor1.extract(diceThrow)).thenReturn(new DiceCombination(1, 1));
        when(valueExtractor2.extract(new DiceThrow(2, 3))).thenReturn(new DiceCombination(2));

        DiceCombination result = new CompositeValueExtractionStrategy(valueExtractor1, valueExtractor2).extract(diceThrow);

        assertThat(result).isEqualTo(new DiceCombination(1, 1, 2));
    }

    @Test
    void should_return_nothing_when_at_least_one_delegate_returns_nothing() {
        DiceThrow diceThrow = new DiceThrow(1, 1, 1, 2, 3);
        when(valueExtractor1.extract(diceThrow)).thenReturn(new DiceCombination(1, 1));
        when(valueExtractor2.extract(new DiceThrow(2, 3))).thenReturn(DiceCombination.empty());

        DiceCombination result = new CompositeValueExtractionStrategy(valueExtractor1, valueExtractor2).extract(diceThrow);

        verify(valueExtractor3, times(0)).extract(any());
        assertThat(result).isEqualTo(DiceCombination.empty());
    }

}