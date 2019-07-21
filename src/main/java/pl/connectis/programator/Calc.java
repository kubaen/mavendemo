package pl.connectis.programator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;

public class Calc {

  DescriptiveStatistics stats = new DescriptiveStatistics();

  public void setValues(List<Double> values) {
    stats.clear();
    for (int i = 0; i < values.size(); i++) {
      stats.addValue(values.get(i));
    }
  }

  public double mean() {
    return  stats.getMean();
  }

  public double std(){
    return stats.getStandardDeviation();
  }

  public long sum(long a, long b) {
    return a + b;
  }

  public void clear() {
    stats.clear();
  }

  public boolean isEven(int l){
    if (l % 2 == 0) return true;
    return false;
  }

  public double divide(long a, long b) {
    return (double) a / b;
  }
}
