package strategyKingdom.mine.gems;

public class GoldNugget implements Gem
{
  @Override public String getName()
  {
    return "Gold Nugget";
  }

  @Override public int getValue()
  {
    return 50;
  }

  @Override public String toString(){
    return getName() + ": " + getValue();
  }
}
