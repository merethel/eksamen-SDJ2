package adapterKingdom.mine.Adapter; //Target

import adapterKingdom.mine.gems.Gem;

public interface BlockingQueue
{
  void enqueue(Gem gem);
  Gem dequeue();
  boolean isEmpty();
  boolean isFull();
  int size();
}
