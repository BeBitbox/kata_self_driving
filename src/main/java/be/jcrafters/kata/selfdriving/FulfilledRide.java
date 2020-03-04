package be.jcrafters.kata.selfdriving;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FulfilledRide that = (FulfilledRide) o;
        return punctual == that.punctual &&
                Objects.equals(ride, that.ride);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ride, punctual);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FulfilledRide{");
        sb.append("ride=").append(ride);
        sb.append(", punctual=").append(punctual);
        sb.append('}');
        return sb.toString();
    }
}
