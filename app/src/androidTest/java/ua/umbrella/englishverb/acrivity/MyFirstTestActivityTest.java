package ua.umbrella.englishverb.acrivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import ua.umbrella.englishverb.R;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MyFirstTestActivityTest
    extends ActivityInstrumentationTestCase2<GameActivity>
{
  private GameActivity mFirstTestActivity;
  private TextView mFirstTestText;

  public MyFirstTestActivityTest()
  {
    super(GameActivity.class);
  }

  @Override
  protected void setUp() throws Exception
  {
    super.setUp();
    mFirstTestActivity = getActivity();
    mFirstTestText = (TextView) mFirstTestActivity.findViewById(R.id.english);
  }

  public void testPreconditions()
  {
    assertNotNull("mFirstTestActivity is null", mFirstTestActivity);
    assertNotNull("mFirstTestText is null", mFirstTestText);
  }

  public void testMyFirstTestTextView_labelText()
  {
    final String expected = mFirstTestActivity.getString(R.string.hello_world);
    final String actual = mFirstTestText.getText().toString();
    assertEquals(expected, actual);
  }
}