package ua.umbrella.englishverb.activity;

import android.app.Activity;
import android.os.Bundle;

import ua.umbrella.englishverb.R;

public class SettingActivity extends Activity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    ActivityUtils.runActivity(this, R.layout.activity_setting);
  }
}
