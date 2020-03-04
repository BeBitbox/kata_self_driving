package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static be.jcrafters.kata.selfdriving.Ride.RideBuilder.aRide;
import static org.assertj.core.api.Assertions.assertThat;

class SubmissionTest {

    @Test
    void getScore_oneRide_oneBlock() {
        FulfilledRide ride = createRide(0, 0, 1, 0, true);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(1);
    }

    @Test
    void getScore_oneRide_twoBlocks() {
        FulfilledRide ride = createRide(0, 0, 2, 0, true);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(2);
    }

    @Test
    void getScore_oneRide_squareCity() {
        FulfilledRide ride = createRide(8, 8, 4, 4, true);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(8);
    }

    @Test
    void getScore_oneRide_bonusPunctual() {
        FulfilledRide ride = createRide(0, 0, 1, 0, true);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(10);

        assertThat(score).isEqualTo(11);
    }

    @Test
    void getScore_oneRide_noBonusPunctual() {
        FulfilledRide ride = createRide(0, 0, 1, 0, false);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(10);

        assertThat(score).isEqualTo(1);
    }

    @Test
    void getScore_twoRides() {
        FulfilledRide ride1 = createRide(0, 0, 1, 0, false);
        FulfilledRide ride2 = createRide(0, 0, 1, 0, false);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride1, ride2));

        long score = new Submission(assignments).getScore(10);

        assertThat(score).isEqualTo(2);
    }

    @Test
    void getScore_ComplexRides() {
        FulfilledRide ride1 = createRide(0, 0, 1, 0, false);
        FulfilledRide ride2 = createRide(0, 0, 1, 0, false);
        FulfilledRide ride3 = createRide(10, 10, 10, 200, true);
        FulfilledRide ride4 = createRide(8, 8, 2, 2, true);
        List<Set<FulfilledRide>> assignments = List.of(Set.of(ride1, ride2, ride3, ride4));

        long score = new Submission(assignments).getScore(10);

        assertThat(score).isEqualTo(1 + 1 + 200 + 22);
    }

    private FulfilledRide createRide(int a, int b, int x, int y, boolean punctual) {
        return new FulfilledRide(aRide()
                .withStart(Coordinate.of(a, b))
                .withEnd(Coordinate.of(x, y))
                .withEarliestStart(0)
                .withLatestFinish(1)
                .build(), punctual);
    }
}