package be.jcrafters.kata.selfdriving;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlanningTest {

    @Test
    void minimalCity_testGrid() {
        Planning planning = new Planning("minimal_city");

        assertThat(planning.getRows()).isEqualTo(1);
        assertThat(planning.getColumns()).isEqualTo(2);
        assertThat(planning.getFleetSize()).isEqualTo(1);
        assertThat(planning.getNumberOfRides()).isEqualTo(1);
        assertThat(planning.getBonus()).isEqualTo(0);
        assertThat(planning.getNumberOfSteps()).isEqualTo(1);
    }

    @Test
    void minimalCity_testRide() {
        Planning planning = new Planning("minimal_city");
        assertThat(planning.getRides()).hasSize(1);
        Ride ride = planning.getRides().get(0);
        assertThat(ride.getStart().getX()).isEqualTo(0);
        assertThat(ride.getStart().getY()).isEqualTo(0);
        assertThat(ride.getEnd().getX()).isEqualTo(1);
        assertThat(ride.getEnd().getY()).isEqualTo(0);
        assertThat(ride.getEarliestStart()).isEqualTo(0);
        assertThat(ride.getLatestFinish()).isEqualTo(1);
    }

    @Test
    void minimalCity_() {
        Planning planning = new Planning("minimal_city");
    }


}