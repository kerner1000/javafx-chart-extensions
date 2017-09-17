import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChartExtensionsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test01() {
        final double[] data = new double[]{1, 2, 3, 4, 5, 6};

        final int averageOverElementCnt = 2;
        final int binCnt = data.length / averageOverElementCnt;

        final double[] binnedData = ChartExtensions.binData(data, binCnt);

        assertThat(binnedData.length, is(3));
        assertThat(binnedData[0], is(1.5d));
        assertThat(binnedData[1], is(3.5d));
        assertThat(binnedData[2], is(5.5d));

    }

    @Test
    public void test02() {
        final double[] data = new double[]{1, 2, 3, 4, 5, 6, 7};

        final int averageOverElementCnt = 2;
        final int binCnt = data.length / averageOverElementCnt;

        final double[] binnedData = ChartExtensions.binData(data, binCnt);

        assertThat(binnedData.length, is(3));
        assertThat(binnedData[0], is(2d));
        assertThat(binnedData[1], is(4.5d));
        assertThat(binnedData[2], is(6.5d));

    }
}