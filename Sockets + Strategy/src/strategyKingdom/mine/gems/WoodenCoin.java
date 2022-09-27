package strategyKingdom.mine.gems;

public class WoodenCoin implements Gem
{
  @Override public String getName()
  {
    return "Wooden Coin";
  }

  @Override public int getValue()
  {
    return 1;
  }

  @Override public String toString(){
    return getName() + ": " + getValue();
  }
}
