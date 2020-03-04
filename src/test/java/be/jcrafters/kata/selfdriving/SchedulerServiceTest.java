package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SchedulerServiceTest {

    @Test
    void calculateSubmission_minimal() {
        var planning = new Planning("minimal_city");

        Submission submission = new SchedulerService().calculateSubmission(planning);

        assertThat(submission.rideAssignments).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).containsExactly(new FulfilledRide(Ride.RideBuilder.aRide().withId(0).build(), true));
    }

    @Test
    void calculateSubmission_notPunctual() {
        var planning = new Planning("minimal_city_not_punctual");

        Submission submission = new SchedulerService().calculateSubmission(planning);

        assertThat(submission.rideAssignments).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).containsExactly(new FulfilledRide(Ride.RideBuilder.aRide().withId(0).build(), false));
    }

    @Test
    void calculateSubmission_notEnoughSteps() {
        var planning = new Planning("horizontal_city_not_enough_steps");

        Submission submission = new SchedulerService().calculateSubmission(planning);

        assertThat(submission.rideAssignments).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).isEmpty();
    }

    @Test
    void calculateSubmission_shiftedPunctual() {
        var planning = new Planning("horizontal_city_shifted_punctual");

        Submission submission = new SchedulerService().calculateSubmission(planning);

        assertThat(submission.rideAssignments).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).hasSize(1);
        assertThat(submission.rideAssignments.get(0)).containsExactly(new FulfilledRide(Ride.RideBuilder.aRide().withId(0).build(), true));
    }
}