package ua.umbrella.englishverb.dao;

import java.util.Set;

import ua.umbrella.englishverb.object.Twin;

public class VerbDao
{
  private VerbDao(){}

  public static final VerbDao verbDao = new VerbDao();
  public static VerbDao getVerbDao()
  {
    return verbDao;
  }

  public Set<Twin> getAllTwins()
  {
    return TwinFixture.getAllTwins();
  }

  public Twin getTwinById(int id)
  {
    switch (id)
    {
      case 1:return TwinFixture.getTwin1();
      case 2:return TwinFixture.getTwin2();
      case 3:return TwinFixture.getTwin3();
      case 4:return TwinFixture.getTwin4();
      case 5:return TwinFixture.getTwin5();
      case 6:return TwinFixture.getTwin6();
      case 7:return TwinFixture.getTwin7();
      case 8:return TwinFixture.getTwin8();
      case 9:return TwinFixture.getTwin9();
      case 10:return TwinFixture.getTwin10();
      default:return null;
    }
  }
}
