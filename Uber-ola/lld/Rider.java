package lld;

public class Rider {
    private String name;
    private RATING rating;

    public Rider(String pName, RATING pRating) {
        name = pName;
        rating = pRating;
    }

    public String getRiderName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }
}
