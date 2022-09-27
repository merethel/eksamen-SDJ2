package strategyKingdom.mine.producerConsumer;

public class DumbWorker implements Strategy
{

  @Override public int calculate() throws InterruptedException
  {
    Thread.sleep(10000);
    return (int)(Math.random()*(3-1)+1);
  }
}
