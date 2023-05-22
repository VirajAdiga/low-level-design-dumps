package lld;

class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetadata metaData) {
        System.out.println("Based on default strategy, price is 100");
        return 100.0;
    }
}
