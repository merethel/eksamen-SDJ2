package adapterKingdom.mine.kingdom;

import adapterKingdom.mine.Adapter.ArrayList;
import adapterKingdom.mine.Catalogue;
import adapterKingdom.mine.gems.Gem;

public class King implements Runnable
{
  private int min;
  private int max;
  private int priceOfParty;
  private TreasureRoomDoor treasureRoom;
  private String name;
  private ArrayList<Gem> gems;


  public King(TreasureRoomDoor treasureRoom)
  {
    min = 2000;
    max = 5000;
    this.treasureRoom = treasureRoom;
    name = "king";
    gems = new ArrayList<>();
  }

  public void throwParty()
  {
    priceOfParty = (int) (Math.random() * (max - min) + min);
    treasureRoom.acquireWriteAccess(name);
    while (calculateValue()<priceOfParty){
      Gem retrievedGem = treasureRoom.retrieveValuable();
      if(retrievedGem != null)
      {
        gems.add(retrievedGem);
      } else {
        for (int i = 0; i < gems.size(); i++)
        {
          treasureRoom.addValuable(gems.get(i));
        }
        //Instead of removing gems we give him a new empty arraylist.
        gems = new ArrayList<>();
        Catalogue.getInstance().log("Party canceled ;(");
        break;
      }
      if (calculateValue()>= priceOfParty)
      {
        Catalogue.getInstance().log("Parteyyyyy");
        System.out.println(gems + "" + calculateValue());
        gems = new ArrayList<>();
        break;
      }
    }
    treasureRoom.releaseWriteAccess(name);
  }

  public int calculateValue(){
    int counter = 0;
    for (int i = 0; i < gems.size(); i++)
    {
      counter += gems.get(i).getValue();
    }
    return counter;
  }

  @Override public void run()
  {
    while (true){
      try
      {
        Thread.sleep(5000);
        throwParty();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
}
}
