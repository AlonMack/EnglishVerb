package ua.umbrella.englishverb.service;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ua.umbrella.englishverb.dao.VerbDao;
import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.object.Verb;

public class VerbService
{
  private static final VerbService verbService = new VerbService();
  private static VerbDao verbDao;
  Set<Twin> twins;
  private int size = 0;

  private VerbService()
  {
  }

  public static VerbService getVerbService(Context context)
  {
    verbDao = VerbDao.getVerbDao(context);
    return verbService;
  }

  public Set<Verb> getAllVerbs()
  {
    Set<Verb> verbList = new HashSet<Verb>();
    if (null == twins)
      twins = getAllTwins();
    for (Twin twin : twins)
    {
      boolean isExist = false;
      for (Verb verb : verbList)
        if (verb.getEnglish().equals(twin.getEnglish()))
        {
          verb.addRussian(twin.getRussian());
          isExist = true;
        }
      if (!isExist)
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
    if (size == 0)
      size = getAllTwins().size();
    return verbDao.getTwinById(1 + new Random().nextInt(size));
  }

  public Verb getVerbByEnglish(String english)
  {
    for (Verb verb : getAllVerbs())
      if (english.equals(verb.getEnglish()))
        return verb;

    return null;
  }

  public Set<String> getAllRussianWords()
  {
    Set<Twin> twinSet = getAllTwins();
    Set<String> russians = new HashSet<String>();
    for (Twin twin : twinSet)
      russians.add(twin.getRussian());
    return russians;
  }

  public List<String> getRussianWordsForChapter(Twin correctTwin)
  {
    String english = correctTwin.getEnglish();
    List<String> russians = new ArrayList<String>();
    Twin twin;
    while (russians.size() < 4)
    {
      twin = getTwin();
      if (!twin.getEnglish().equals(english) && !russians.contains(twin.getRussian()))
        russians.add(twin.getRussian());
    }
    int rand = new Random().nextInt(russians.size());
    russians.set(rand, correctTwin.getRussian());
    return russians;
  }

  public Set<Twin> getAllTwins()
  {
    return verbDao.getAllTwins();
  }
}
