package be.jcrafters.kata.selfdriving;

public class FulfilledRide {
    private final Ride ride;
    private final boolean punctual;

    public FulfilledRide(Ride ride, boolean punctual) {
        this.ride = ride;
        this.punctual = punctual;
    }

    public Ride getRide() {
        return ride;
    }

    public boolean isPunctual() {
        return punctual;
    }

    long getScore(int bonusValue) {
        int bonus = isPunctual() ? bonusValue : 0;
        return ride.getDistance() + bonus;
    }
}
