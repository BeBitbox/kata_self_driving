package be.jcrafters.kata.selfdriving;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static be.jcrafters.kata.selfdriving.Ride.RideBuilder.aRide;
import static java.util.stream.Collectors.toList;

public class Planning {

    private final int rows;
    private final int columns;
    private final int fleetSize;
    private final int numberOfSteps;
    private final int bonus;
    private final int numberOfRides;
    private final List<Ride> rides;

    public Planning(String name) {
        List<String> strings = readInputFile(name);
        String headerLine = strings.get(0);
        String[] headerVariables = headerLine.split(" ");

        rows = Integer.parseInt(headerVariables[0]);
        columns = Integer.parseInt(headerVariables[1]);
        fleetSize = Integer.parseInt(headerVariables[2]);
        numberOfSteps = Integer.parseInt(headerVariables[3]);
        bonus = Integer.parseInt(headerVariables[4]);
        numberOfRides = Integer.parseInt(headerVariables[5]);

        rides = strings.stream()
                .skip(1)
                .map(this::toRide)
                .collect(toList());
    }

    private List<String> readInputFile(String name) {
        try {
            URL resource = Planning.class.getResource("/" + name + ".in");
            return Files.readAllLines(Path.of(resource.toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Ride toRide(String s) {
        String[] rideLine = s.split(" ");
        int startX = Integer.parseInt(rideLine[0]);
        int startY = Integer.parseInt(rideLine[1]);
        int endX = Integer.parseInt(rideLine[2]);
        int endY = Integer.parseInt(rideLine[3]);
        int earliestStart = Integer.parseInt(rideLine[4]);
        int latestFinish = Integer.parseInt(rideLine[5]);

        return aRide()
                .withStart(Coordinate.of(startX, startY))
                .withEnd(Coordinate.of(endX, endY))
                .withEarliestStart(earliestStart)
                .withLatestFinish(latestFinish)
                .build();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public int getBonus() {
        return bonus;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public List<Ride> getRides() {
        return rides;
    }
}
