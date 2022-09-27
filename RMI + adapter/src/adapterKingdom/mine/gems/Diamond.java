package adapterKingdom.mine.gems;

public class Diamond implements Gem
{
  @Override public String getName()
  {
    return "Diamond";
  }

  @Override public int getValue()
  {
    return 1000;
  }
  @Override public String toString(){
    return getName() + ": " + getValue();
  }
}
