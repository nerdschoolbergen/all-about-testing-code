package  smoothiemaker;
/**
 * A smoothie bar that can blend smoothies and keeps track of the stock of ingredients.
 */
public final class SmoothieBar {
    private int applesInStock = 0;
    private int orangesInStock = 0;
    private int bananasInStock = 0;

    public Smoothie blend(SmoothieKind smoothieKind) {
        return blend(smoothieKind, 1);
    }

    public Smoothie blend(SmoothieKind smoothieKind, int size) {
        if(size < 1) {
            throw new IllegalArgumentException();
        }

        int requiredApples = smoothieKind.getRequiredApples() * size;
        int requiredOranges = smoothieKind.getRequiredOranges() * size;
        int requiredBananas = smoothieKind.getRequiredBananas() * size;

        if(requiredApples > applesInStock || requiredOranges > orangesInStock || requiredBananas > bananasInStock) {
            throw new IllegalStateException();
        }

        applesInStock -= requiredApples;
        orangesInStock -= requiredOranges;
        bananasInStock -= requiredBananas;
        return new Smoothie(smoothieKind, requiredApples, requiredOranges, requiredBananas);
    }

    public void restockApples(int apples) {
        if(apples < 1) {
            throw new IllegalArgumentException();
        }
        applesInStock += apples;
    }

    public void restockOranges(int oranges) {
        if(oranges < 1) {
            throw new IllegalArgumentException();
        }
        orangesInStock += oranges;
    }

    public void restockBananas(int bananas) {
        if(bananas < 1) {
            throw new IllegalArgumentException();
        }
        bananasInStock += bananas;
    }

    public int getApplesInStock() {
        return applesInStock;
    }

    public int getOrangesInStock() {
        return orangesInStock;
    }

    public int getBananasInStock() {
        return bananasInStock;
    }
}
