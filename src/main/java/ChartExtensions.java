import org.apache.commons.math3.random.EmpiricalDistribution;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.slf4j.LoggerFactory;

public class ChartExtensions {

    public static enum BIN_TYPE {
        MEAN, SUM
    }

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ChartExtensions.class);

    public static double[] binData(final double[] data, final int binCount) {
        return binData(data, binCount, BIN_TYPE.MEAN);
    }

    public static double[] binData(final double[] data, final int binCount, final BIN_TYPE binType) {

        final double[] result = new double[binCount];
        final EmpiricalDistribution distribution = new EmpiricalDistribution(binCount);
        distribution.load(data);

        int i = 0;
        for (final SummaryStatistics stats : distribution.getBinStats()) {
            switch (binType) {
                case SUM:
                    result[i++] = stats.getSum();
                    break;
                default:
                    result[i++] = stats.getMean();
                    break;
            }
        }

        return result;

    }
}
