package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FleetScheduleTest {

    @Test
    void minimalCity_getSubmission() {
        Planning pl = new Planning("minimal_city");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(1);
    }

    @Test
    void horizontal_2_getSubmission() {
        Planning pl = new Planning("horizontal_2");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(2);
    }

    @Test
    void horizontal_city_one_ride_shifted() {
        Planning pl = new Planning("horizontal_city_one_ride_shifted");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(2);
    }

    @Test
    void horizontal_right_to_left() {
        Planning pl = new Planning("horizontal_right_to_left");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(1);
    }

    @Test
    void square_city_1_ride() {
        Planning pl = new Planning("square_city_1_ride");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(2);
    }

    @Test
    void horizontal_city_one_ride_bonus() {
        Planning pl = new Planning("horizontal_city_one_ride_bonus");
        FleetSchedule schedule = new FleetSchedule(pl);

        assertThat(schedule.getSubmission()).containsExactly("1 0");
        assertThat(schedule.getScore()).isEqualTo(11);
    }

    @Test
    void horizontal_city_impossible_ride() {
        Planning pl = new Planning("horizontal_city_impossible_ride");
        FleetSchedule schedule = new FleetSchedule(pl);

        // assertThat(schedule.getSubmission()).isEmpty();
        assertThat(schedule.getScore()).isEqualTo(0);
    }
}