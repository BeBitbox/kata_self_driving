package be.jcrafters.kata.selfdriving;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class FleetSchedule {
    private final Planning planning;

    public FleetSchedule(Planning planning) {
        this.planning = planning;
    }

    public List<String> getSubmission() {
        return IntStream.of(planning.getFleetSize())
                .mapToObj(taxiNumber -> String.format("%d %d", taxiNumber, getRideNumber()))
                .collect(toList());
    }

    private int getRideNumber() {
        return planning.getRides().size() - 1;
    }

    public int getScore() {
        return planning.getRides().stream()
                .mapToInt(ride -> ride.getDistance() + planning.getBonus())
                .max()
                .orElse(0);
    }
}
