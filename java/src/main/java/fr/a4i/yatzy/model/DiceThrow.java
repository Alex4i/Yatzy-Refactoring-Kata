package fr.a4i.yatzy.model;

import fr.a4i.yatzy.validator.DiceValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record DiceThrow(List<Integer> values) {

    public DiceThrow {
        DiceValidator.validateDice(values);
    }

    public DiceThrow(int... array) {
        this(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
}
