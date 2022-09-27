package adapterKingdom.mine;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue
{
  private File logFile;
  private static Catalogue instance;
  private static Lock lock;

  private Catalogue()
  {
    logFile = new File("catalogue.txt");
  }
  static {
    lock = new ReentrantLock();
  }

  public static Catalogue getInstance(){
    if (instance == null){ //lazy instantiation
      synchronized (lock)
      {
        if (instance==null){
          instance = new Catalogue();
        }
      }
    }
    return instance;
  }

  public void log(String txt){
    try
    {
      Writer out = new BufferedWriter(new FileWriter(logFile,true));
      System.out.println(txt);
      out.append(txt + "\n");
      out.flush();
      out.close();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
