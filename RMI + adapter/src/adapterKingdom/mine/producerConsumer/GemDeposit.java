package adapterKingdom.mine.producerConsumer;

import adapterKingdom.mine.Adapter.BlockingQueue;
import adapterKingdom.mine.Adapter.ListAdapter;
import adapterKingdom.mine.gems.Gem;

public class GemDeposit //Sockets.client i adapter pattern og monitor i consumer/producer
{
  private BlockingQueue queue;
  private final Object FULL_QUEUE;
  private final Object EMPTY_QUEUE;


  public GemDeposit()
  {
    queue = new ListAdapter();
    FULL_QUEUE = new Object();
    EMPTY_QUEUE = new Object();
  }

  public synchronized void addGem(Gem gem){
    while (isFull())
    {
      try
      {
        this.waitOnFull();
      }
      catch (InterruptedException e)
      {
        break;
      }
    }
    queue.enqueue(gem);
    notifyAllForEmpty();
  }

  public Gem removeGem(){
    while (isEmpty())
    {
      try
      {
        this.waitOnEmpty();
      }
      catch (InterruptedException e)
      {
        break;
      }
    }
    Gem gem = queue.dequeue();
    notifyAllForFull();
    return gem;
  }

  public boolean isEmpty(){
    return queue.isEmpty();
  }

  public boolean isFull(){
    return queue.isFull();
  }

  public void waitOnFull() throws InterruptedException {
    synchronized (FULL_QUEUE) {
      FULL_QUEUE.wait();
    }
  }

  public void notifyAllForFull() {
    synchronized (FULL_QUEUE) {
      FULL_QUEUE.notifyAll();
    }
  }

  public void waitOnEmpty() throws InterruptedException {
    synchronized (EMPTY_QUEUE) {
      EMPTY_QUEUE.wait();
    }
  }

  public void notifyAllForEmpty() {
    synchronized (EMPTY_QUEUE) {
      EMPTY_QUEUE.notify();
    }
  }

  public int size(){
    return queue.size();
  }


}
