package ua.umbrella.englishverb.dao;

import java.util.HashSet;
import java.util.Set;

import ua.umbrella.englishverb.object.Twin;

public class TwinFixture
{
  //---------------------------------
  public static Twin getTwin1()
  {
    return new Twin("english1", "рус11");
  }
  public static Twin getTwin2()
  {
    return new Twin("english1", "рус12");
  }

  //--------------------------------
  public static Twin getTwin3()
  {
    return new Twin("english2", "рус21");
  }
  public static Twin getTwin4()
  {
    return new Twin("english2", "рус22");
  }
  public static Twin getTwin5()
  {
    return new Twin("english2", "рус23");
  }

  //---------------------------------
  public static Twin getTwin6()
  {
    return new Twin("english3", "рус31");
  }
  public static Twin getTwin7()
  {
    return new Twin("english3", "рус32");
  }

  //---------------------------------
  public static Twin getTwin8()
  {
    return new Twin("english4", "рус41");
  }

  //---------------------------------

  public static Twin getTwin9()
  {
    return new Twin("english5", "рус41");
  }
  //---------------------------------

  public static Twin getTwin10()
  {
    return new Twin("english5", "рус51");
  }
  //---------------------------------

  public static Set<Twin> getAllTwins()
  {
    Set<Twin> twinList = new HashSet<Twin>();
    twinList.add(getTwin1());
    twinList.add(getTwin2());
    twinList.add(getTwin3());
    twinList.add(getTwin4());
    twinList.add(getTwin5());
    twinList.add(getTwin6());
    twinList.add(getTwin7());
    twinList.add(getTwin8());
    twinList.add(getTwin9());
    twinList.add(getTwin10());
    return twinList;
  }
}
