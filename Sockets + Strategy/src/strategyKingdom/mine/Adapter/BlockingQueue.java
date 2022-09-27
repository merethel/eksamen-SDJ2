package strategyKingdom.mine.Adapter; //Target

import strategyKingdom.mine.gems.Gem;

public interface BlockingQueue
{
  void enqueue(Gem gem);
  Gem dequeue();
  boolean isEmpty();
  boolean isFull();
  int size();
}
