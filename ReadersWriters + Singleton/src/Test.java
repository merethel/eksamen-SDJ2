import mine.producerConsumer.GemDeposit;
import mine.kingdom.*;
import mine.producerConsumer.GemTransporter;
import mine.producerConsumer.*;

public class Test
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new GemDeposit();
    Strategy slowWorker = new SlowWorker();
    Strategy fastWorker = new FastWorker();
    Strategy dumbWorker = new DumbWorker();
    TreasureRoomDoor treasureRoom = new TreasureRoom();
    TreasureRoomDoor guard = new TreasureRoomGuardsman((TreasureRoom) treasureRoom);
    GemMineWorker worker1 = new GemMineWorker(fastWorker,gemDeposit);
    GemMineWorker worker2 = new GemMineWorker(slowWorker,gemDeposit);
    GemMineWorker worker3 = new GemMineWorker(dumbWorker,gemDeposit);
    GemTransporter gemTransporter = new GemTransporter(gemDeposit, guard);
    GemTransporter gemTransporter1 = new GemTransporter(gemDeposit, guard);

    Accountant accountant = new Accountant(guard);
    King king = new King(guard);


    Thread t1 = new Thread(worker1);
    Thread t2 = new Thread(worker2);
    Thread t3 = new Thread(worker3);
    Thread t4 = new Thread(gemTransporter);
    Thread t5 = new Thread(accountant);
    Thread t6 = new Thread(king);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();

  }
}
