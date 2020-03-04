package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static be.jcrafters.kata.selfdriving.Ride.RideBuilder.aRide;
import static org.assertj.core.api.Assertions.assertThat;

class SubmissionTest {

    @Test
    void getScore_oneRide_oneBlock() {
        Ride ride = createRide(0, 0, 1, 0);
        List<Set<Ride>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(1);
    }

    @Test
    void getScore_oneRide_twoBlocks() {
        Ride ride = createRide(0, 0, 2, 0);
        List<Set<Ride>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(2);
    }

    @Test
    void getScore_oneRide_squareCity() {
        Ride ride = createRide(8, 8, 4, 4);
        List<Set<Ride>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(0);

        assertThat(score).isEqualTo(8);
    }

    @Test
    void getScore_oneRide_bonus() {
        Ride ride = createRide(0, 0, 1, 0);
        List<Set<Ride>> assignments = List.of(Set.of(ride));

        long score = new Submission(assignments).getScore(10);

        assertThat(score).isEqualTo(11);
    }

    private Ride createRide(int a, int b, int x, int y) {
        return aRide()
                .withStart(Coordinate.of(a, b))
                .withEnd(Coordinate.of(x, y))
                .withEarliestStart(0)
                .withLatestFinish(1)
                .build();
    }
}