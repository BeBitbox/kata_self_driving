package be.jcrafters.kata.selfdriving;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Submission {
    List<Set<FulfilledRide>> rideAssignments;

    public Submission(List<Set<FulfilledRide>> rideAssignments) {
        this.rideAssignments = rideAssignments;
    }

    public long getScore(int i) {
        return rideAssignments.stream()
                .flatMap(Collection::stream)
                .mapToLong(fulfilledRide -> fulfilledRide.getScore(i))
                .max()
                .orElse(0);
    }

}
