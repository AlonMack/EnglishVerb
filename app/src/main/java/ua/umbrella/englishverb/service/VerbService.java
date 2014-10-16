package ua.umbrella.englishverb.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ua.umbrella.englishverb.dao.VerbDao;
import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.object.Verb;
public class VerbService
{
  VerbDao verbDao = new VerbDao();

  public static VerbService getVerbService()
  {
    return new VerbService();
  }

  public Set<Verb> getAllVerbs()
  {
    Set<Verb> verbList = new HashSet<Verb>();
    for (Twin twin : verbDao.getAllTwins())
    {
      boolean yes = false;
      for (Verb verb : verbList)
        if (verb.getEnglish().equals(twin.getEnglish()))
        {
          verb.addRussian(twin.getRussian());
          yes = true;
        }
      if(! yes)
      {
        Verb verb = new Verb();
        verb.setEnglish(twin.getEnglish());
        verb.addRussian(twin.getRussian());
        verbList.add(verb);
      }
    }
    return verbList;
  }

  public Twin getTwin()
  {
    return verbDao.getTwin();
  }
}
