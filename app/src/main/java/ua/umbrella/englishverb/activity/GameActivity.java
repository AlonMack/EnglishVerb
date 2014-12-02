package ua.umbrella.englishverb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import ua.umbrella.englishverb.R;
import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.service.VerbService;

public class GameActivity extends Activity implements View.OnClickListener
{
  private static final String FORMAT = "%02d:%02d:%01d";
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
  private CountDownTimer countDownTimer;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    ActivityUtils.runActivity(this, R.layout.activity_game);

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
    startTimer();
    newLap();
  }

  @Override
  public void onClick(final View view)
  {
    LinearLayout mainScreen = (LinearLayout) findViewById(R.id.main_screen);
    int childrenCount = mainScreen.getChildCount();
    for (int i = 0; i < childrenCount; i++)
      mainScreen.getChildAt(i).setClickable(false);
    if (((Button) view).getText().toString().equals(twin.getRussian()))
    {
      view.setBackgroundResource(R.drawable.splash_screen);
      valueScore++;
      score.setText(valueScore.toString());
    } else
    {
      valueScore--;
      score.setText(valueScore.toString());
    }
    newLap();
    for (int i = 0; i < childrenCount; i++)
      mainScreen.getChildAt(i).setClickable(true);
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      public void run() {
        view.setBackgroundResource(R.drawable.standard_bg);
      }
    }, 500);
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

  @Override
  public void onBackPressed()
  {
    super.onBackPressed();
    countDownTimer.cancel();
  }

  public void startTimer()
  {
    countDownTimer = new CountDownTimer(6000, 10)
    {

      @Override
      public void onTick(long millisUntilFinished)
      {
        time.setText("" + String.format(FORMAT,
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
            TimeUnit.MILLISECONDS.toMillis(millisUntilFinished) / 100 - TimeUnit.SECONDS.toMillis(
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)) / 100));
      }

      @Override
      public void onFinish()
      {
        FinishDialog finishDialog = new FinishDialog(GameActivity.this);
        finishDialog.setCanceledOnTouchOutside(false);
        finishDialog.show();
      }
    }.start();
  }

  public TextView getScore()
  {
    return score;
  }

  public void setValueScore(Integer valueScore)
  {
    this.valueScore = valueScore;
  }
}
