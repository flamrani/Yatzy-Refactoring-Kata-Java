import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.CategoriesEnum;
import models.Roll;
import services.YatzyService;


public class YatzyTest {
  private YatzyService yatzyService;
  
  @BeforeEach
  public void init() {
	  this.yatzyService = new YatzyService();
  }
  

  @Test
  public void chance_scores_sum_of_all_dice() {
      int expected = 15;
      int actual = yatzyService.calculateScore(new Roll(List.of(2,3,4,5,1)), CategoriesEnum.CHANCE);
      assertEquals(expected, actual);
      assertEquals(16, yatzyService.calculateScore(new Roll(List.of(3,3,4,5,1)), CategoriesEnum.CHANCE));
  }


    @Test 
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = yatzyService.calculateScore(new Roll(List.of(4,4,4,4,4)), CategoriesEnum.YATZY);
        assertEquals(expected, actual);
        assertEquals(50,  yatzyService.calculateScore(new Roll(List.of(6,6,6,6,6)), CategoriesEnum.YATZY));
        assertEquals(0,   yatzyService.calculateScore(new Roll(List.of(6,6,6,6,3)), CategoriesEnum.YATZY));
    }

    @Test 
    public void test_1s() {
        assertTrue(yatzyService.calculateScore(new Roll(List.of(1,2,3,4,5)), CategoriesEnum.ONES) == 1);
        assertEquals(2, yatzyService.calculateScore((new Roll(List.of(1,2,1,4,5))), CategoriesEnum.ONES));
        assertEquals(0, yatzyService.calculateScore(new Roll(List.of(6,2,2,4,5)), CategoriesEnum.ONES));
        assertEquals(4, yatzyService.calculateScore(new Roll(List.of(1,2,1,1,1)), CategoriesEnum.ONES));
    }

    @Test
    public void test_2s() {
        assertEquals(4,  yatzyService.calculateScore(new Roll(List.of(1,2,3,2,6)), CategoriesEnum.TWOS));
        assertEquals(10, yatzyService.calculateScore(new Roll(List.of(2,2,2,2,2)), CategoriesEnum.TWOS));
    }

    @Test
    public void test_threes() {
        assertEquals(6, yatzyService.calculateScore(new Roll(List.of(1,2,3,2,3)), CategoriesEnum.THREES));
        assertEquals(12, yatzyService.calculateScore(new Roll(List.of(2,3,3,3,3)), CategoriesEnum.THREES));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12,  yatzyService.calculateScore(new Roll(List.of(4,4,4,5,5)), CategoriesEnum.FOURS));
        assertEquals(8,   yatzyService.calculateScore(new Roll(List.of(4,4,5,5,5)), CategoriesEnum.FOURS));
        assertEquals(4,   yatzyService.calculateScore(new Roll(List.of(4,5,5,5,5)), CategoriesEnum.FOURS));
    }

    @Test
    public void fives() {
        assertEquals(10, yatzyService.calculateScore(new Roll(List.of(4,4,4,5,5)), CategoriesEnum.FIVES));
        assertEquals(15, yatzyService.calculateScore(new Roll(List.of(4,4,5,5,5)), CategoriesEnum.FIVES));
        assertEquals(20, yatzyService.calculateScore(new Roll(List.of(4,5,5,5,5)), CategoriesEnum.FIVES));
    }

    @Test
    public void sixes_test() {
        assertEquals(0,   yatzyService.calculateScore(new Roll(List.of(4,4,4,5,5)), CategoriesEnum.SIXES));
        assertEquals(6,   yatzyService.calculateScore(new Roll(List.of(4,4,6,5,5)), CategoriesEnum.SIXES));
        assertEquals(18,  yatzyService.calculateScore(new Roll(List.of(6,5,6,6,5)), CategoriesEnum.SIXES));
    }

    @Test
    public void onePair() {
        assertEquals(6,  yatzyService.calculateScore(new Roll(List.of(3,4,3,5,6)), CategoriesEnum.PAIR));
        assertEquals(10, yatzyService.calculateScore(new Roll(List.of(5,3,3,3,5)), CategoriesEnum.PAIR));
        assertEquals(12, yatzyService.calculateScore(new Roll(List.of(5,3,6,6,5)), CategoriesEnum.PAIR));
    }

    @Test
    public void twoPair() {
        assertEquals(16, yatzyService.calculateScore(new Roll(List.of(3,3,5,4,5)), CategoriesEnum.TWO_PAIRS));
        assertEquals(16, yatzyService.calculateScore(new Roll(List.of(3,3,5,5,5)), CategoriesEnum.TWO_PAIRS));
        assertEquals(8,  yatzyService.calculateScore(new Roll(List.of(1,1,2,3,3)), CategoriesEnum.TWO_PAIRS));
        assertEquals(0, yatzyService.calculateScore(new Roll(List.of(1,1,2,3,4)), CategoriesEnum.TWO_PAIRS));
        assertEquals(6, yatzyService.calculateScore(new Roll(List.of(1,1,2,2,2)), CategoriesEnum.TWO_PAIRS));
        assertEquals(0, yatzyService.calculateScore(new Roll(List.of(3,3,3,3,1)), CategoriesEnum.TWO_PAIRS));
    }

    @Test
    public void threeOfAKind() 
    {
        assertEquals(9, yatzyService.calculateScore(new Roll(List.of(3,3,3,4,5)), CategoriesEnum.THREE_OF_A_KIND));
        assertEquals(15,yatzyService.calculateScore(new Roll(List.of(5,3,5,4,5)), CategoriesEnum.THREE_OF_A_KIND));
        assertEquals(9, yatzyService.calculateScore(new Roll(List.of(3,3,3,3,5)), CategoriesEnum.THREE_OF_A_KIND));
        assertEquals(0, yatzyService.calculateScore(new Roll(List.of(3,3,4,5,6)), CategoriesEnum.THREE_OF_A_KIND));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, yatzyService.calculateScore(new Roll(List.of(3,3,3,3,5)), CategoriesEnum.FOUR_OF_A_KIND));
        assertEquals(20, yatzyService.calculateScore(new Roll(List.of(5,5,5,4,5)), CategoriesEnum.FOUR_OF_A_KIND));
      // assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));
        assertEquals(0,  yatzyService.calculateScore(new Roll(List.of(2,2,2,5,5)), CategoriesEnum.FOUR_OF_A_KIND));
        
    }

   @Test
    public void smallStraight() {
        assertEquals(15,  yatzyService.calculateScore(new Roll(List.of(1,2,3,4,5)), CategoriesEnum.SMALL_STRAIGHT));
        assertEquals(15,  yatzyService.calculateScore(new Roll(List.of(2,3,4,5,1)), CategoriesEnum.SMALL_STRAIGHT));
        assertEquals(0,   yatzyService.calculateScore(new Roll(List.of(1,2,2,4,5)), CategoriesEnum.SMALL_STRAIGHT));
        assertEquals(0,   yatzyService.calculateScore(new Roll(List.of(2,3,4,5,6)), CategoriesEnum.SMALL_STRAIGHT));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, yatzyService.calculateScore(new Roll(List.of(6,2,3,4,5)), CategoriesEnum.LARGE_STRAIGHT));
        assertEquals(20, yatzyService.calculateScore(new Roll(List.of(2,3,4,5,6)), CategoriesEnum.LARGE_STRAIGHT));
        assertEquals(0,  yatzyService.calculateScore(new Roll(List.of(1,2,2,4,5)), CategoriesEnum.LARGE_STRAIGHT));
        assertEquals(0,  yatzyService.calculateScore(new Roll(List.of(1,2,3,4,5)), CategoriesEnum.LARGE_STRAIGHT));
    }

    @Test
    public void fullHouse() {
        assertEquals(0, yatzyService.calculateScore(new Roll(List.of(4,4,4,4,4)), CategoriesEnum.FULL_HOUSE));
        assertEquals(18, yatzyService.calculateScore(new Roll(List.of(6,2,2,2,6)), CategoriesEnum.FULL_HOUSE));
        assertEquals(0,  yatzyService.calculateScore(new Roll(List.of(2,3,4,5,6)), CategoriesEnum.FULL_HOUSE));
        assertEquals(0,  yatzyService.calculateScore(new Roll(List.of(2,2,3,3,4)), CategoriesEnum.FULL_HOUSE));
    }
}
