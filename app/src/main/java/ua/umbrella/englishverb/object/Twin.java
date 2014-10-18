package ua.umbrella.englishverb.object;

public class Twin
{
  private int id;
  private String english;
  private String russian;

  public Twin()
  {
  }

  public Twin(int id, String english, String russian)
  {
    this.id = id;
    this.english = english;
    this.russian = russian;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
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

    return id == twin.id && english.equals(twin.english) && russian.equals(twin.russian);
  }

  @Override
  public int hashCode()
  {
    int result = english.hashCode();
    result = 31 * result + russian.hashCode();
    result = 31 * result + id;
    return result;
  }
}
