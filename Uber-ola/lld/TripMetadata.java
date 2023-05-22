package lld;

public class TripMetadata {
    private Location srcLoc;
    private Location dstLoc;
    private RATING riderRating;
    private RATING driverRating;

    public TripMetadata(Location pSrcLoc, Location pDstLoc, RATING pRiderRating) {
        srcLoc = pSrcLoc;
        dstLoc = pDstLoc;
        riderRating = pRiderRating;
        driverRating = RATING.UNASSIGNED;
    }

    public RATING getRiderRating() {
        return riderRating;
    }

    public RATING getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(RATING pDriverRating) {
        driverRating = pDriverRating;
    }
}
