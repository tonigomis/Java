import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by toni on 09/11/16.
 */
public class multipicaMatriuE11Test {
    @Test
    public void testMultiplicaMatriu() throws Exception {
        int[][] expectedArray = {{30, -26, 10}, {36, -31, 14}, {42, -36, 18}};
        int[][] resultArray = {{30, -26, 10}, {36, -31, 14}, {42, -36, 18}};
        Assert.assertArrayEquals(expectedArray, resultArray);

    }
}