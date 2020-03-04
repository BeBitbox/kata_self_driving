package be.jcrafters.kata.selfdriving;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Submission {
    List<Set<Ride>> rideAssignments;

    public Submission(List<Set<Ride>> rideAssignments) {
        this.rideAssignments = rideAssignments;
    }

    public long getScore(int i) {
        return rideAssignments.stream()
                .flatMap(Collection::stream)
                .mapToLong(Ride::getDistance)
                .max()
                .orElse(0);
    }
}
