package  smoothiemaker;
/**
 * Represents a smoothie that has a kind and is made of a mix of ingredients
 */
public final class Smoothie {
    private final SmoothieKind kind;
    private final int apples;
    private final int oranges;
    private final int bananas;

    public Smoothie(SmoothieKind kind, int apples, int oranges, int bananas) {
        this.kind = kind;
        this.apples = apples;
        this.oranges = oranges;
        this.bananas = bananas;
    }

    public SmoothieKind getKind() {
        return kind;
    }

    public int getApples() {
        return apples;
    }

    public int getOranges() {
        return oranges;
    }

    public int getBananas() {
        return bananas;
    }

    @Override
    public String toString() {
        return "Smoothie: " +
                "kind=" + kind +
                ", apples= " + apples +
                ", oranges= " + oranges +
                ", bananas= " + bananas;
    }
}
