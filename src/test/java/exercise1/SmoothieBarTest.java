package exercise1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieBarTest {
    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertEquals(SmoothieKind.OrangeAndAppleSmoothie, smoothie.getKind());
    }
}
