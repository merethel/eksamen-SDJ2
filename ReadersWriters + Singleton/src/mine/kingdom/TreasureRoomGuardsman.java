package mine.kingdom;

import mine.gems.Gem;

import java.util.List;

public class TreasureRoomGuardsman implements TreasureRoomDoor
{
  private TreasureRoom treasureRoom;
  private int activeReaders;
  private int activeWriters;
  private int waitingWriters;
  private int waitingReaders;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
    waitingWriters = 0;
    waitingReaders = 0;
    activeReaders = 0;
    activeWriters = 0;
  }

  @Override public void acquireReadAccess(String actorName)
  {
      waitingReaders++;
      while (activeWriters > 0 || waitingWriters > 0)
      {
        try
        {
          wait();
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    treasureRoom.acquireReadAccess(actorName);
    waitingReaders--;
    activeReaders++;
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
  {
    waitingWriters++;
    while (activeReaders>0 || activeWriters>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    treasureRoom.acquireWriteAccess(actorName);
    waitingWriters--;
    activeWriters++;
  }

  @Override public void releaseReadAccess(String actorName)
  {
    activeReaders--;
    if(activeReaders==0){
      notify();
    }
    treasureRoom.releaseReadAccess(actorName);
  }

  @Override public synchronized void releaseWriteAccess(String actorName)
  {
    activeWriters--;
    if(activeWriters==0 && waitingWriters>0){
      notify();
    }
    else{
    notifyAll();
    }
    treasureRoom.releaseWriteAccess(actorName);
  }

  @Override public Gem retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(Gem v)
  {
    treasureRoom.addValuable(v);
  }


  @Override public List<Gem> lookAtAllGems()
  {
    try
    {
      Thread.sleep(4000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return treasureRoom.lookAtAllGems();
  }
}
