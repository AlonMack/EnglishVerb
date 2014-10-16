package ua.umbrella.englishverb.object;

public class Twin
{
  private String english;
  private String russian;

  public Twin()
  {
  }

  public Twin(String english, String russian)
  {
    this.english = english;
    this.russian = russian;
  }

  public String getEnglish()
  {
    return english;
  }

  public void setEnglish(String english)
  {
    this.english = english;
  }

  public String getRussian()
  {
    return russian;
  }

  public void setRussian(String russian)
  {
    this.russian = russian;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Twin twin = (Twin) o;

    return english.equals(twin.english) && russian.equals(twin.russian);
  }

  @Override
  public int hashCode()
  {
    int result = english.hashCode();
    result = 31 * result + russian.hashCode();
    return result;
  }
}
