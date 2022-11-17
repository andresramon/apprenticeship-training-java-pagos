package org.cokaido.training;

public enum Orientation {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("O");

    private final String value;

    Orientation(String value) {
        this.value = value;
    }

    public static Orientation fromValue(String value) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.value.equals(value)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid orientation: " + value);
    }

    public String getValue() {
        return value;
    }
}
