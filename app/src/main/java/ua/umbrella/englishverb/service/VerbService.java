package ua.umbrella.englishverb.service;

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
  private static VerbDao verbDao;

  private VerbService(){}

  private static final VerbService verbService = new VerbService();

  public static VerbService getVerbService()
  {
    verbDao = VerbDao.getVerbDao();
    return verbService;
  }

  public Set<Verb> getAllVerbs()
  {
    Set<Verb> verbList = new HashSet<Verb>();
    for (Twin twin : verbDao.getAllTwins())
    {
      boolean isExist = false;
      for (Verb verb : verbList)
        if (verb.getEnglish().equals(twin.getEnglish()))
        {
          verb.addRussian(twin.getRussian());
          isExist = true;
        }
      if(! isExist)
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
    int size = getAllVerbs().size();
    return verbDao.getTwinById(1+new Random().nextInt(size));
  }

  public Verb getVerbByEnglish(String english)
  {
    for (Verb verb : getAllVerbs())
      if(english.equals(verb.getEnglish()))
       return verb;

    return null;
  }

  public Set<String> getAllRussianWords()
  {
    Set<Verb> verbSet = getAllVerbs();
    Set<String> russians = new HashSet<String>();
    for (Verb verb : verbSet)
      russians.addAll(verb.getRussianList());
    return russians;
  }

  public List<String> getRussianWordsForChapter(Twin twin)
  {
    String english = twin.getEnglish();
    List<String> russians = new ArrayList<String>();
    for (Verb verb : getAllVerbs())
      if (! verb.getEnglish().equals(english))
        russians.addAll(verb.getRussianList());
    int rand = new Random().nextInt(russians.size());
    russians.set(rand, twin.getRussian());
    return russians;
  }

  public boolean isCorrectVariant(String english, String russian)
  {
    Verb verb = getVerbByEnglish(english);

    return verb.getRussianList().contains(russian);
  }
}
