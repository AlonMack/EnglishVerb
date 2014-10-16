package ua.umbrella.englishverb.service;

import android.app.Application;
import android.test.ApplicationTestCase;

import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.object.Verb;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class VerbServiceTest extends ApplicationTestCase<Application>
{
  public VerbServiceTest()
  {
    super(Application.class);
  }

  VerbService verbService = VerbService.getVerbService();

  public void test_getAllVerbs_size()
  {
    assertEquals(5, verbService.getAllVerbs().size() );
  }

  public void test_getAllVerbs_russianList_is_not_empty()
  {
    for (Verb verb : verbService.getAllVerbs())
       assertTrue(verb.getRussianList().size() > 0);
  }

  public void test_getPair_one_english_one_russian()
  {
    Twin twin = verbService.getTwin();
    assertEquals("english1", twin.getEnglish());
    assertEquals("рус11", twin.getRussian());
  }
}
