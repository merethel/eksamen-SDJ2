package strategyKingdom.mine.producerConsumer;


public class SlowWorker implements Strategy
{
  @Override public int calculate() throws InterruptedException
  {
    Thread.sleep(10000);
    return (int)(Math.random()*(6-3)+3);
  }

  public String toString(){
    return "Slow worker";
  }

}
