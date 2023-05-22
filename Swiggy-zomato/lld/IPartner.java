package lld;

public abstract class IPartner {
    protected String name;
    protected Rating rating;

    public IPartner(String pName) {
        name = pName;
        rating = Rating.UNASSIGNED;
    }

    public String getName() {
        return name;
    }

    //public abstract void performKyc();
}

