package adapterKingdom.mine.producerConsumer; //MONITOR CLASS

import adapterKingdom.mine.Adapter.ArrayList;
import adapterKingdom.mine.Catalogue;
import adapterKingdom.mine.gems.Gem;
import adapterKingdom.mine.kingdom.TreasureRoomDoor;

public class GemTransporter implements Runnable
{
  private ArrayList<Gem> transportStorage;
  private GemDeposit gemDeposit;
  private int min;
  private int max;
  private int random;
  private TreasureRoomDoor guard;
  private String name;

  public GemTransporter(GemDeposit gemDeposit, TreasureRoomDoor guard)
  {
    transportStorage = new ArrayList<>();
    this.gemDeposit = gemDeposit;
    min = 1;
    max = 5;
    this.guard = guard;
    name = "transporter";
  }

  @Override public void run()
  {
    while(true){
      try
      {
        consume();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      transportStorage = new ArrayList<>();
    }

  }

  public void consume() throws InterruptedException
  {
    Gem gem;
    while (true)
    {
      Thread.sleep(5000);
      random = (int) (Math.random() * (max - min) + min);
      if (random>gemDeposit.size()){
        random=gemDeposit.size();
      }

      for (int i = 0; i < random; i++)
      {
        gem = gemDeposit.removeGem();
        Catalogue.getInstance().log("-----Gem Transporter removed a : " + gem.getName() + "-----");
        transportStorage.add(gem);
      }
      guard.acquireWriteAccess(name);
      for (int i = 0; i < transportStorage.size(); i++)
      {
        guard.addValuable(transportStorage.get(i));
      }
      guard.releaseWriteAccess(name);
    }
  }


}