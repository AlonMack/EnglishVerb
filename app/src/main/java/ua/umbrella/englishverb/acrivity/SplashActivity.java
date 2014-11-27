package ua.umbrella.englishverb.acrivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import ua.umbrella.englishverb.R;

public class SplashActivity extends Activity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    final Intent intent = new Intent(this, MainActivity.class);
    Thread logoTimer = new Thread()
    {
      public void run()
      {
        try
        {
          int logoTimer = 0;
          while (logoTimer < 5000)
          {
            sleep(100);
            logoTimer = logoTimer + 100;
          }
          startActivity(intent);
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        } finally
        {
          finish();
        }
      }
    };
    logoTimer.start();
  }
}
