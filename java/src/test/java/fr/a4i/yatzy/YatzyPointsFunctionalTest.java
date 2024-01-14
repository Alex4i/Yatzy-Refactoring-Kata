package fr.a4i.yatzy;

import fr.a4i.yatzy.model.DiceThrow;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyPointsFunctionalTest {

    @Test
    void onesTest(){
        assertThat(YatzyPoints.ones(new DiceThrow(2,3,4,5,6))).isZero();
        assertThat(YatzyPoints.ones(new DiceThrow(1,1,2,3,4))).isEqualTo(2);
    }

    @Test
    void twosTest(){
        assertThat(YatzyPoints.twos(new DiceThrow(1,3,4,5,6))).isZero();
        assertThat(YatzyPoints.twos(new DiceThrow(2,2,2,3,4))).isEqualTo(6);
    }

    @Test
    void threesTest(){
        assertThat(YatzyPoints.threes(new DiceThrow(1,2,4,5,6))).isZero();
        assertThat(YatzyPoints.threes(new DiceThrow(3,3,3,3,4))).isEqualTo(12);
    }

    @Test
    void foursTest(){
        assertThat(YatzyPoints.fours(new DiceThrow(1,2,3,5,6))).isZero();
        assertThat(YatzyPoints.fours(new DiceThrow(3,3,3,4,4))).isEqualTo(8);
    }

    @Test
    void fivesTest(){
        assertThat(YatzyPoints.fives(new DiceThrow(1,2,3,4,6))).isZero();
        assertThat(YatzyPoints.fives(new DiceThrow(3,3,5,5,5))).isEqualTo(15);
    }

    @Test
    void sixesTest(){
        assertThat(YatzyPoints.sixes(new DiceThrow(1,2,3,4,2))).isZero();
        assertThat(YatzyPoints.sixes(new DiceThrow(6,6,3,6,6))).isEqualTo(24);
    }

    @Test
    void onePairTest(){
        assertThat(YatzyPoints.onePair(new DiceThrow(1,2,3,4,5))).isZero();
        assertThat(YatzyPoints.onePair(new DiceThrow(3,6,6,6,6))).isEqualTo(12);
        assertThat(YatzyPoints.onePair(new DiceThrow(3,4,3,5,6,4))).isEqualTo(8);
    }

    @Test
    void twoPairsTest(){
        assertThat(YatzyPoints.twoPairs(new DiceThrow(1,2,3,4,5))).isZero();
        assertThat(YatzyPoints.twoPairs(new DiceThrow(6,6,3,6,6))).isZero();
        assertThat(YatzyPoints.twoPairs(new DiceThrow(3,4,4,5,5))).isEqualTo(18);
    }

    @Test
    void threeOfAKindTest(){
        assertThat(YatzyPoints.threeOfAKind(new DiceThrow(1,2,3,4,5))).isZero();
        assertThat(YatzyPoints.threeOfAKind(new DiceThrow(2,2,3,3,6))).isZero();
        assertThat(YatzyPoints.threeOfAKind(new DiceThrow(3,3,3,5,5))).isEqualTo(9);
    }

    @Test
    void fourOfAKindTest(){
        assertThat(YatzyPoints.fourOfAKind(new DiceThrow(1,2,3,4,5))).isZero();
        assertThat(YatzyPoints.fourOfAKind(new DiceThrow(3,5,5,5,5))).isEqualTo(20);
    }

    @Test
    void smallStraightTest(){
        assertThat(YatzyPoints.smallStraight(new DiceThrow(3,5,5,5,5))).isZero();
        assertThat(YatzyPoints.smallStraight(new DiceThrow(1,2,3,4,5))).isEqualTo(15);
    }

    @Test
    void largeStraightTest(){
        assertThat(YatzyPoints.largeStraight(new DiceThrow(3,5,5,5,5))).isZero();
        assertThat(YatzyPoints.largeStraight(new DiceThrow(2,3,4,5,6))).isEqualTo(20);
    }

    @Test
    void fullHouseTest(){
        assertThat(YatzyPoints.fullHouse(new DiceThrow(3,5,5,5,5))).isZero();
        assertThat(YatzyPoints.fullHouse(new DiceThrow(1,1,1,2,2))).isEqualTo(7);
        assertThat(YatzyPoints.fullHouse(new DiceThrow(3,3,5,5,5))).isEqualTo(21);
    }

    @Test
    void chanceTest(){
        assertThat(YatzyPoints.chance(new DiceThrow(3,5,5,5,5))).isEqualTo(23);
        assertThat(YatzyPoints.chance(new DiceThrow(1,2,3,4,5))).isEqualTo(15);
        assertThat(YatzyPoints.chance(new DiceThrow(3,3,5,5,5))).isEqualTo(21);
    }


    @Test
    void yatzyTest(){
        assertThat(YatzyPoints.yatzy(new DiceThrow(3,5,5,5,5))).isZero();
        assertThat(YatzyPoints.yatzy(new DiceThrow(1,1,1,1,1))).isEqualTo(50);
        assertThat(YatzyPoints.yatzy(new DiceThrow(5,5,5,5,5))).isEqualTo(50);
    }


}