package pl.connectis.programator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {

  public static void main(String[] args) {
    DescriptiveStatistics stats = new DescriptiveStatistics();

    // Add some values
    for (int i = 1; i <= 5; i++) {
      stats.addValue(i);
    }

// Compute some statistics
    double mean = stats.getMean();
    double std = stats.getStandardDeviation();
    double median = stats.getPercentile(50);

    System.out.println(std);
  }
}
