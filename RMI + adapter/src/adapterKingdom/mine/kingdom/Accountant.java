package adapterKingdom.mine.kingdom;

import adapterKingdom.mine.Catalogue;

public class Accountant implements Runnable
{
  private TreasureRoomDoor guard;
  private String name;

  public Accountant(TreasureRoomDoor guard)
  {
    this.guard=guard;
    name = "Accountant";
  }

  @Override public void run()
  {
    while (true){
      try
      {
        guard.acquireReadAccess(name);
        Catalogue.getInstance().log("Accountant counted the valuables and found: " + guard.lookAtAllGems());
        guard.releaseReadAccess(name);
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
