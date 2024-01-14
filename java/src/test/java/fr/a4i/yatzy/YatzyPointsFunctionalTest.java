package fr.a4i.yatzy;

import fr.a4i.yatzy.model.DiceThrow;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;


class YatzyPointsFunctionalTest {

    private static Iterable<Case> cases() {
        return List.of(
            new Case("ones1",YatzyPoints::ones, new DiceThrow(2, 3, 4, 5, 6), 0),
            new Case("ones2", YatzyPoints::ones,new DiceThrow(1, 1, 2, 3, 4), 2),

            new Case("twos1", YatzyPoints::twos,new DiceThrow(1,3,4,5,6), 0),
            new Case("twos2", YatzyPoints::twos,new DiceThrow(2,2,2,3,4), 6),

            new Case("threes1", YatzyPoints::threes,new DiceThrow(1,2,4,5,6), 0),
            new Case("threes2", YatzyPoints::threes,new DiceThrow(3,3,3,3,4), 12),

            new Case("fours1", YatzyPoints::fours,new DiceThrow(1,2,3,5,6), 0),
            new Case("fours2", YatzyPoints::fours,new DiceThrow(3,3,3,4,4), 8),

            new Case("fives1", YatzyPoints::fives,new DiceThrow(1,2,3,4,6), 0),
            new Case("fives2", YatzyPoints::fives,new DiceThrow(3,3,5,5,5), 15),

            new Case("sixes1", YatzyPoints::sixes,new DiceThrow(1,2,3,4,2), 0),
            new Case("sixes2", YatzyPoints::sixes,new DiceThrow(6,6,3,6,6), 24),

            new Case("onePair1", YatzyPoints::onePair,new DiceThrow(1,2,3,4,5), 0),
            new Case("onePair2", YatzyPoints::onePair,new DiceThrow(3,6,6,6,6), 12),
            new Case("onePair3", YatzyPoints::onePair,new DiceThrow(3,4,3,5,4), 8),

            new Case("twoPairs1", YatzyPoints::twoPairs,new DiceThrow(1,2,3,4,5), 0),
            new Case("twoPairs2", YatzyPoints::twoPairs,new DiceThrow(6,6,3,6,6), 0),
            new Case("twoPairs3", YatzyPoints::twoPairs,new DiceThrow(3,4,4,5,5), 18),

            new Case("threeOfAKind1", YatzyPoints::threeOfAKind,new DiceThrow(1,2,3,4,5), 0),
            new Case("threeOfAKind2", YatzyPoints::threeOfAKind,new DiceThrow(2,2,3,3,6), 0),
            new Case("threeOfAKind3", YatzyPoints::threeOfAKind,new DiceThrow(3,3,3,5,5), 9),

            new Case("fourOfAKind1", YatzyPoints::fourOfAKind,new DiceThrow(1,2,3,4,5), 0),
            new Case("fourOfAKind2", YatzyPoints::fourOfAKind,new DiceThrow(3,5,5,5,5), 20),

            new Case("smallStraight1", YatzyPoints::smallStraight,new DiceThrow(3,5,5,5,5), 0),
            new Case("smallStraight1", YatzyPoints::smallStraight,new DiceThrow(1,2,3,4,5), 15),

            new Case("largeStraight1", YatzyPoints::largeStraight,new DiceThrow(3,5,5,5,5), 0),
            new Case("largeStraight2", YatzyPoints::largeStraight,new DiceThrow(2,3,4,5,6), 20),

            new Case("fullHouse1", YatzyPoints::fullHouse,new DiceThrow(3,5,5,5,5), 0),
            new Case("fullHouse2", YatzyPoints::fullHouse,new DiceThrow(1,1,1,2,2), 7),
            new Case("fullHouse3", YatzyPoints::fullHouse,new DiceThrow(3,3,5,5,5), 21),

            new Case("chance1", YatzyPoints::chance,new DiceThrow(3,5,5,5,5), 23),
            new Case("chance2", YatzyPoints::chance,new DiceThrow(1,2,3,4,5), 15),
            new Case("chance2", YatzyPoints::chance,new DiceThrow(3,3,5,5,5), 21),

            new Case("yatzy1", YatzyPoints::yatzy,new DiceThrow(3,5,5,5,5), 0),
            new Case("yatzy2", YatzyPoints::yatzy,new DiceThrow(1,1,1,1,1), 50),
            new Case("yatzy3", YatzyPoints::yatzy,new DiceThrow(5,5,5,5,5), 50)
        );
    };

    @ParameterizedTest
    @MethodSource("cases")
    void test(Case aCase){
        assertThat(aCase.countingMethod.apply(aCase.input)).isEqualTo(aCase.result);
    }


    @Value
    private static class Case {
        String name;
        Function<DiceThrow,Integer> countingMethod;
        DiceThrow input;
        Integer result;

        @Override
        public String toString() {
            return name;
        }
    }
}