package ua.umbrella.englishverb.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import ua.umbrella.englishverb.R;
import ua.umbrella.englishverb.dao.DbHelper;
import ua.umbrella.englishverb.dao.SettingDao;
import ua.umbrella.englishverb.object.Setting;
import ua.umbrella.englishverb.service.SettingService;
import ua.umbrella.englishverb.service.VerbService;

public class SettingActivity extends Activity
{
  private TextView email;
  private Spinner mainWord;
  private Spinner time;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    ActivityUtils.runActivity(this, R.layout.activity_setting);
    email = (TextView) findViewById(R.id.account_email);
//    mainWord = (Spinner) findViewById(R.id.spinner_main_word);
    time = (Spinner) findViewById(R.id.spinner_time);
  }

  @Override
  protected void onStart()
  {
    super.onStart();
    SettingService settingService = SettingService.getSettingService(this);
    Setting setting = settingService.getSetting();
    email.setText(setting.getEmail());
//    mainWord.setSelection(setting.getMainWord());
    time.setSelection(setting.getTime());
  }

  @Override
  protected void onPause()
  {
    super.onPause();
    SettingService settingService = SettingService.getSettingService(this);
    Setting setting = new Setting();
    setting.setEmail(email.getText().toString());
//    setting.setMainWord(mainWord.getSelectedItemPosition());
    setting.setTime(time.getSelectedItemPosition());
    settingService.updateSetting(setting);
  }
}
