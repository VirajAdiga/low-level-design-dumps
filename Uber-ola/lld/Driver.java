package lld;

public class Driver {
	private String name;
	private boolean avail;
	private RATING rating;

	public Driver(String pName, RATING pRating) {
    		this.name = pName;
    		this.rating = pRating;
    		this.avail = false;
	}

	public void updateAvail(boolean pAvail) {
    		this.avail = pAvail;
	}

	public String getDriverName() {
    		return this.name;
	}

	public RATING getRating() {
    		return this.rating;
	}
}
