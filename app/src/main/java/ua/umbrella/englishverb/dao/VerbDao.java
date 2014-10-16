package ua.umbrella.englishverb.dao;

import java.util.Set;

import ua.umbrella.englishverb.object.Twin;

public class VerbDao
{
  public Set<Twin> getAllTwins()
  {
    return TwinFixture.getAllTwins();
  }

  public Twin getTwin()
  {
    return TwinFixture.getTwin1();
  }
}
