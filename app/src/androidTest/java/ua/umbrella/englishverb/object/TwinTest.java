package ua.umbrella.englishverb.object;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TwinTest extends ApplicationTestCase<Application>
{
  public TwinTest()
  {
    super(Application.class);
  }

  public void test_getEnglish_in_twin()
  {
    assertEquals("english1", TwinFixture.getTwin1().getEnglish());
  }

  public void test_getRussian()
  {
    assertEquals("рус11", TwinFixture.getTwin1().getRussian());
  }

  public void test_getId()
  {
    assertEquals(1, TwinFixture.getTwin1().getId());
  }

  public void test_equals()
  {
    Twin twin = TwinFixture.getTwin1();
    assertTrue(TwinFixture.getTwin1().equals(new Twin(twin.getId(), twin.getEnglish(), twin.getRussian())));
  }
}
