package fr.a4i.yatzy.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record DiceCombination(List<Integer> dices) {
    public DiceCombination(int... array){
        this(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    public static DiceCombination empty(){
        return new DiceCombination(Collections.emptyList());
    }

    public static DiceCombination merge(List<DiceCombination> diceCombinations){
        return new DiceCombination(
            diceCombinations.stream()
                .flatMap(diceCombination -> diceCombination.dices().stream())
                .toList()
        );
    }

    public boolean isFailed(){
        return dices.isEmpty();
    }

    public boolean isSuccess(){
        return !isFailed();
    }
}
