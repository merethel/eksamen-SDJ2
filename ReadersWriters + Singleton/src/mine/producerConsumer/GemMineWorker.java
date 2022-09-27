package mine.producerConsumer;

import mine.Catalogue;
import mine.GemMine;
import mine.gems.Gem;

public class GemMineWorker implements Runnable
{
  private Strategy strategy;
  private GemDeposit gemDeposit;

  public GemMineWorker(Strategy strategy, GemDeposit gemDeposit)
  {
    this.strategy = strategy;
    this.gemDeposit = gemDeposit;
  }

  @Override public void run()
  {
    while (true){
      try
      {
        produce();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  public synchronized void produce() throws InterruptedException
  {
    while (true) {
      Gem gem = GemMine.generateGem(strategy.calculate());

      gemDeposit.addGem(gem);
      Catalogue.getInstance().log(strategy + " found a " + gem.getName() + " with value " + gem.getValue());
    }
  }
}
