package mine.Adapter; //mine.Adapter - adapting adaptee(ArrayList) to target (BlockingQueue)

import mine.gems.Gem;

public class ListAdapter implements BlockingQueue
{

  private ListADT<Gem> list;

  public ListAdapter()
  {
    list = new ArrayList<>();
  }

  @Override public void enqueue(Gem gem)
  {
    list.add(gem);
  }

  @Override public Gem dequeue()
  {
    return list.remove(0);
  }

  @Override public boolean isEmpty()
  {
    return list.isEmpty();
  }


  @Override public boolean isFull()
  {
    return list.size() >= 10;
  }

  @Override public int size()
  {
    return list.size();
  }

}
