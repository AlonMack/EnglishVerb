package ua.umbrella.englishverb.object;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class VerbFixture
{
  public static Verb getVerb1()
  {
    return new Verb("english1", Sets.newHashSet("рус11"));
  }
  public static Verb getVerb2()
  {
    return new Verb("english2", Sets.newHashSet("рус21", "рус22"));
  }

  public static Verb getVerb3()
  {
    return new Verb("english3", Sets.newHashSet("рус31", "рус32", "рус33"));
  }
}
