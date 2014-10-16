package ua.umbrella.englishverb.object;

import java.util.HashSet;
import java.util.Set;

public class Verb
{
  private String english = "";
  private Set<String> russianList = new HashSet<String>();

  public Verb()
  {
  }

  public Verb(String english, Set<String> russianList)
  {
    this.english = english;
    this.russianList = russianList;
  }

  public String getEnglish()
  {
    return english;
  }

  public void setEnglish(String english)
  {
    this.english = english;
  }

  public Set<String> getRussianList()
  {
    return russianList;
  }

  public void setRussianList(Set<String> russianList)
  {
    this.russianList = russianList;
  }

  public void addRussian(String russian)
  {
    getRussianList().add(russian);
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Verb verb = (Verb) o;

    return english.equals(verb.english) && russianList.equals(verb.russianList);
  }

  @Override
  public int hashCode()
  {
    int result = english.hashCode();
    result = 31 * result + russianList.hashCode();
    return result;
  }
}
