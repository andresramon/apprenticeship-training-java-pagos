package org.cokaido.training;

public enum Orientation {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("O");

    private final String orientation;

    Orientation(String orientation) {
        this.orientation = orientation;
    }

    public static Orientation fromValue(String value) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.orientation.equals(value)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid orientation: " + value);
    }

}
