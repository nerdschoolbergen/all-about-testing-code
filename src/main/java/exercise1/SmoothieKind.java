package exercise1;

/**
 * Defines different kinds of smoothies and the ingredients required
 */
public enum SmoothieKind {
    OrangeAndAppleSmoothie(2, 2, 0),
    BananaAndAppleSmoothie(0, 2, 1),
    OrangeAndBananaSmoothie(3, 0, 1);

    private final int requiredOranges;
    private final int requiredApples;
    private final int requiredBananas;

    SmoothieKind(int requiredOranges, int requiredApples, int requiredBananas) {
        this.requiredOranges = requiredOranges;
        this.requiredApples = requiredApples;
        this.requiredBananas = requiredBananas;
    }

    public int getRequiredOranges() {
        return requiredOranges;
    }

    public int getRequiredApples() {
        return requiredApples;
    }

    public int getRequiredBananas() {
        return requiredBananas;
    }
}
