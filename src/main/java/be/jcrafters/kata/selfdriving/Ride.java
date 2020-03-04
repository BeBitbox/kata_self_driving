package be.jcrafters.kata.selfdriving;

import java.util.Objects;

public class Ride {

    private Coordinate start;
    private Coordinate end;
    private int earliestStart;
    private int latestFinish;
    private int id;

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public int getDistance() {
        return Math.abs(end.getX() - start.getX()) + Math.abs(end.getY() - start.getY()) ;
    }

    public static final class RideBuilder {
        private Coordinate start;
        private Coordinate end;
        private int earliestStart;
        private int latestFinish;
        private int id;

        private RideBuilder() {
        }

        public static RideBuilder aRide() {
            return new RideBuilder();
        }

        public RideBuilder withStart(Coordinate start) {
            this.start = start;
            return this;
        }

        public RideBuilder withEnd(Coordinate end) {
            this.end = end;
            return this;
        }

        public RideBuilder withEarliestStart(int earliestStart) {
            this.earliestStart = earliestStart;
            return this;
        }

        public RideBuilder withLatestFinish(int latestFinish) {
            this.latestFinish = latestFinish;
            return this;
        }

        public RideBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public Ride build() {
            Ride ride = new Ride();
            ride.id = this.id;
            ride.earliestStart = this.earliestStart;
            ride.end = this.end;
            ride.start = this.start;
            ride.latestFinish = this.latestFinish;
            return ride;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return id == ride.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ride{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", earliestStart=").append(earliestStart);
        sb.append(", latestFinish=").append(latestFinish);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
