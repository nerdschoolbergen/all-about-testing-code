public final class SmoothieBar {
    private int applesInStock = 0;
    private int orangesInStock = 0;
    private int bananasInStock = 0;

    public Smoothie blend(SmoothieKind smoothieKind) {
        return blend(smoothieKind, 1);
    }

    public Smoothie blend(SmoothieKind smoothieKind, int volumeInDecilitres) {
        int requiredApples = smoothieKind.getRequiredApples() * volumeInDecilitres;
        int requiredOranges = smoothieKind.getRequiredOranges() * volumeInDecilitres;
        int requiredBananas = smoothieKind.getRequiredBananas() * volumeInDecilitres;

        applesInStock -= requiredApples;
        orangesInStock -= requiredOranges;
        bananasInStock -= requiredBananas;
        return new Smoothie(smoothieKind, requiredApples, requiredOranges, requiredBananas);
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
