package ua.umbrella.englishverb.object;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.google.common.collect.Sets;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class VerbTest extends ApplicationTestCase<Application>
{
  public VerbTest()
  {
    super(Application.class);
  }

  public void test_getEnglish_in_verb()
  {
    assertEquals("english1", VerbFixture.getVerb1().getEnglish());
  }

  public void test_getRussian()
  {
    assertEquals(Sets.newHashSet("рус21", "рус22"), VerbFixture.getVerb2().getRussianList());
  }

  public void test_equals()
  {
    Verb verb = VerbFixture.getVerb1();
    assertTrue(VerbFixture.getVerb1().equals(new Verb(verb.getEnglish(), verb.getRussianList())));
  }
}
