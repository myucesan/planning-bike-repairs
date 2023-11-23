
import java.io.*;
import java.nio.charset.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class MainTest {

    @Test
    public void example() {
        int n = 6;
        int[] starttimes = {0, 6, 3, 1, 8, 3, 1};
        int[] durations =  {0, 1, 5, 2, 3, 3, 4};
        Assertions.assertEquals(3, Main.fixMyBikesPlease(n, starttimes, durations));
    }
}
