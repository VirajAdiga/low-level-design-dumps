package lld;

public class RatingBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetadata pTripMetaData) {
        double price = Util.isHighRating(pTripMetaData.getRiderRating()) ? 55.0 : 65.0;
        System.out.println("Based on " + Util.ratingToString(pTripMetaData.getRiderRating()) + " rider rating, " +
                "price of the trip is " + price);
        return price;
    }
}

