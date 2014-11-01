package ua.umbrella.englishverb.acrivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import ua.umbrella.englishverb.R;
import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.service.VerbService;


public class GameActivity extends Activity implements View.OnClickListener
{

  private static final String FORMAT = "%02d:%02d:%03d";
  private VerbService verbService;
  private Twin twin;

  private Button button1;
  private Button button2;
  private Button button3;
  private Button button4;
  private TextView english;
  private TextView score;
  private TextView time;
  private Integer valueScore;

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
    time = (TextView) findViewById(R.id.time);

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
    new CountDownTimer(60000, 10) { // adjust the milli seconds here

      public void onTick(long millisUntilFinished) {
        time.setText(""+String.format(FORMAT,
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
            TimeUnit.MILLISECONDS.toMillis(millisUntilFinished) - TimeUnit.SECONDS.toMillis(
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))));
      }

      public void onFinish() {
        time.setText("done!");
      }
    }.start();
    newLap();
  }

  @Override
  public void onClick(View view)
  {
    if(((Button) view).getText().toString().equals(twin.getRussian()))
    {
      valueScore ++;
      newLap();
      score.setText(valueScore.toString());
    }
  }

  public void newLap()
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
