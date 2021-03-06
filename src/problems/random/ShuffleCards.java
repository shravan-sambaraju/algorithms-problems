package problems.random;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle-in other words, each of
 * the 52! permutations of the deck has to be equally likely. Assume that you are given a random
 * number generator which is perfect.
 */
import static common.utils.UtilMethods.intArrayToString;

class ShuffleCards {

  private static int rand(int lower, int higher) {
    return lower + (int) (Math.random() * (higher - lower + 1));
  }

  private static int[] shuffleArrayRecursively(int[] cards, int i) {
    if (i == 0) {
      return cards;
    }

    shuffleArrayRecursively(cards, i - 1);
    int k = rand(0, i);

    int temp = cards[k];
    cards[k] = cards[i];
    cards[i] = temp;

    return cards;
  }

  private static void shuffleArrayIteratively(int[] cards) {
    for (int i = 0; i < cards.length; i++) {
      int k = rand(0, i);
      int temp = cards[k];
      cards[k] = cards[i];
      cards[i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(intArrayToString(cards));
    shuffleArrayIteratively(cards);
    System.out.println(intArrayToString(cards));
  }
}
