package adapterKingdom.mine.producerConsumer;

public class FastWorker implements Strategy
{

  @Override public int calculate() throws InterruptedException
  {
    Thread.sleep(2000);
    return (int)(Math.random()*(3-1)+1);
  }

  public String toString(){
    return "Fast worker";
  }
}
