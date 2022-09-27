package adapterKingdom.mine.gems;

public class Jewel implements Gem
{
  @Override public String getName()
  {
    return "Jewel";
  }

  @Override public int getValue()
  {
    return 500;
  }

  @Override public String toString(){
    return getName() + ": " + getValue();
  }
}
