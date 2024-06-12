package model;

public enum Coin {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private final double value;

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
