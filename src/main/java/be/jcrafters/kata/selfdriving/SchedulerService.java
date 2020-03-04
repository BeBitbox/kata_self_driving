package be.jcrafters.kata.selfdriving;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SchedulerService {

    public SchedulerService() {
    }

    public Submission calculateSubmission(Planning planning) {
        Set<FulfilledRide> fulfilledRides = planning.getRides().stream()
                .map(ride -> new FulfilledRide(ride, canBePunctual(ride)))
                .collect(Collectors.toSet());
        return new Submission(List.of(fulfilledRides));
    }

    boolean canBePunctual(Ride ride) {
        return ride.getStart().getX() == 0 && ride.getStart().getY() == 0 ;
    }
}
