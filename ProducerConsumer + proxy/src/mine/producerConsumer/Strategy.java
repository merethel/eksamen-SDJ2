package mine.producerConsumer;
public interface Strategy
{
  int calculate() throws InterruptedException;
  String toString();
}
