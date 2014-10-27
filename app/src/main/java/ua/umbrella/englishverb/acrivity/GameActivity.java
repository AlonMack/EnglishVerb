package ua.umbrella.englishverb.acrivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ua.umbrella.englishverb.R;
import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.service.VerbService;


public class GameActivity extends Activity implements View.OnClickListener
{
  VerbService verbService;
  Twin twin;

  Button button1;
  Button button2;
  Button button3;
  Button button4;
  TextView english;
  TextView score;
  Integer valueScore;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    verbService = VerbService.getVerbService(this);

    english = (TextView) findViewById(R.id.english);
    score = (TextView) findViewById(R.id.score);

    button1 = (Button) findViewById(R.id.russian1);
    button2 = (Button) findViewById(R.id.russian2);
    button3 = (Button) findViewById(R.id.russian3);
    button4 = (Button) findViewById(R.id.russian4);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    valueScore = 0;
    score.setText(valueScore.toString());
    newChapter();
  }

  @Override
  public void onClick(View view)
  {
    if(((Button) view).getText().toString().equals(twin.getRussian()))
    {
      valueScore ++;
      newChapter();
      score.setText(valueScore.toString());
    }
  }

  public void newChapter()
  {
    twin = verbService.getTwin();
    english.setText(twin.getEnglish());
    List<String> russians = verbService.getRussianWordsForChapter(twin);
    button1.setText(russians.get(0));
    button2.setText(russians.get(1));
    button3.setText(russians.get(2));
    button4.setText(russians.get(3));
  }
}
