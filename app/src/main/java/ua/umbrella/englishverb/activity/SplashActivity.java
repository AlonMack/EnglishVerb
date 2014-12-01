package ua.umbrella.englishverb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import ua.umbrella.englishverb.R;
import ua.umbrella.englishverb.service.VerbService;

public class SplashActivity extends Activity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
  }

  @Override
  protected void onStart()
  {
    super.onStart();
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(1000);
          VerbService verbService = VerbService.getVerbService(SplashActivity.this);
          verbService.getAllTwins();
          startApp();
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();

  }

  private void startApp()
  {
    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
    startActivity(intent);
    finish();
  }
}
