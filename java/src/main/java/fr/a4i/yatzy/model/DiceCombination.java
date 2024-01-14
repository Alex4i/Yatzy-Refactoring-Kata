package fr.a4i.yatzy.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record DiceCombination(List<Integer> dices) {
    public DiceCombination(int... array){
        this(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
}
