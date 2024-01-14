package fr.a4i.yatzy.model;

import fr.a4i.yatzy.validator.DiceValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public record DiceCombination(List<Integer> dices) {

    public DiceCombination{
        DiceValidator.validateDice(dices);
    }
    public DiceCombination(int... array){
        this(Arrays.stream(array).boxed().toList());
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

    public int sum(){
        return dices.stream().mapToInt(i -> i).sum();
    }

    public boolean isFailed(){
        return dices.isEmpty();
    }

    public boolean isSuccess(){
        return !isFailed();
    }
}
