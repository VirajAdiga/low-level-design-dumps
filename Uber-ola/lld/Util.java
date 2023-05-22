package lld;

public class Util {
    public static String ratingToString(RATING pRating) {
        return switch (pRating) {
            case ONE_STAR -> "one star";
            case TWO_STARS -> "two stars";
            case THREE_STARS -> "three stars";
            case FOUR_STARS -> "four stars";
            case FIVE_STARS -> "five stars";
            default -> "invalid rating";
        };
    }

    public static boolean isHighRating(RATING pRating) {
        return pRating == RATING.FOUR_STARS || pRating == RATING.FIVE_STARS;
    }
}
