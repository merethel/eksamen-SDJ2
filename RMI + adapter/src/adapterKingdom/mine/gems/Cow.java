package adapterKingdom.mine.gems;

public class Cow implements Gem
{
  @Override public String getName()
  {
    return "Cow";
  }

  @Override public int getValue()
  {
    return 10; //dens mælk er meget værd!
  }

  @Override public String toString(){
    return getName() + ": " + getValue();
  }

}
