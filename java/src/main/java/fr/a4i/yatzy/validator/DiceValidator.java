package fr.a4i.yatzy.validator;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.lang.String.format;

@UtilityClass
public class DiceValidator {

    private static final Set<Integer> DICE_VALUES = Set.of(1, 2, 3, 4, 5, 6);

    public void validateDice(List<Integer> diceValues) {
        List<Integer> illegalValues = diceValues.stream()
            .filter(v -> Objects.isNull(v) || !DICE_VALUES.contains(v))
            .toList();
        if (!illegalValues.isEmpty()) {
            throw new IllegalArgumentException(format("Illegal dice values: %s", illegalValues));
        }
    }
}
