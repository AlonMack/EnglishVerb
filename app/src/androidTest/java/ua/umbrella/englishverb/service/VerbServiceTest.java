package ua.umbrella.englishverb.service;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

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

  VerbService verbService;

  @Override
  protected void setUp() throws Exception
  {
     verbService = VerbService.getVerbService();
  }

  public void test_getAllVerbs_size()
  {
    assertEquals(5, verbService.getAllVerbs().size() );
  }

  public void test_getAllVerbs_russianList_is_not_empty()
  {
    for (Verb verb : verbService.getAllVerbs())
       assertTrue(verb.getRussianList().size() > 0);
  }

  public void test_getTwinById()
  {
    Twin twin = verbService.getTwin();
    assertNotNull(twin);
    assertNotNull(twin.getEnglish());
    assertNotNull(twin.getRussian());
  }

  public void test_getVerbByEnglish()
  {
    Verb verb = verbService.getVerbByEnglish("english1");
    assertEquals(new Verb("english1", Sets.newHashSet("рус11", "рус12")), verb);
  }

  public void test_getAllRussianWords()
  {
    Set<String> russianSet = verbService.getAllRussianWords();
    assertEquals(Sets.newHashSet("рус11", "рус12","рус21", "рус22", "рус23", "рус31", "рус32", "рус41", "рус51"), russianSet);
  }

  public void test_check_divers_position_for_true_word()
  {
    Twin twin = verbService.getTwin();
    List<String> russianList1= verbService.getRussianWordsForChapter(twin);

    List<String> russianList2 = verbService.getRussianWordsForChapter(twin);

    List<String> russianList3 = verbService.getRussianWordsForChapter(twin);

    List<String> russianList4 = verbService.getRussianWordsForChapter(twin);
    assertFalse(russianList1.equals(russianList2)
            && russianList3.equals(russianList2)
            && russianList1.equals(russianList4)
    );
  }

  public void test_is_correct_variant()
  {
    assertTrue(verbService.isCorrectVariant("english1", "рус11"));
    assertFalse(verbService.isCorrectVariant("english1", "рус21"));
  }

  public void test_getAllTwins()
  {
//    assertEquals(Sets.newHashSet(new Twin()), verbService.getAllTwins());
  }

//  public void test_get_new_chapter_if_word_is_true()
//  {
//    fail();
//  }
//
//  public void test_not_get_new_chapter_if_word_is_false()
//  {
//    fail();
//  }
//
//  public void test_check_single_correct_word()
//  {
//    fail();
//  }
//
//  public void test_check_twice_id_without_gaps()
//  {
//    fail();
//  }
}
