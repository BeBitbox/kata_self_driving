package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

class SchedulerServiceTest {

    @Test
    void calculateSubmission() {
        Submission submission = new SchedulerService().calculateSubmission(new Planning("minimal_city"));
    }
}