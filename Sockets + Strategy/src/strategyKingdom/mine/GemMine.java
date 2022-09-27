package strategyKingdom.mine;

import adapterKingdom.mine.gems.*;
import strategyKingdom.mine.gems.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GemMine
{
  private static Map<String, Gem> gems;
  private static Lock lock;

  private GemMine()
  {
    lock = new ReentrantLock();
  }

  static
  {
    gems = new ConcurrentHashMap<>();
    gems.put("Cow", new Cow());
    gems.put("Diamond", new Diamond());
    gems.put("Gold Nugget", new GoldNugget());
    gems.put("Jewel", new Jewel());
    gems.put("Wooden Coin", new WoodenCoin());
  }

  public static Gem getInstance(String key)
  {
    return gems.get(key);
  }

  public static Gem generateGem(int random){
    Gem gem = null;
    switch (random){
      case 1:
        gem = getInstance("Wooden Coin");
        break;

      case 2:
        gem = getInstance("Cow");
        break;

      case 3:
        gem = getInstance("Gold Nugget");
        break;

      case 4:
        gem = getInstance("Jewel");
        break;

      case 5:
        gem = getInstance("Diamond");
        break;

      default:
    }
    return gem;
  }
}

