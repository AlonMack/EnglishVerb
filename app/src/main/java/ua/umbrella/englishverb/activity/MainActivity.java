package ua.umbrella.englishverb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ua.umbrella.englishverb.R;

public class MainActivity extends Activity implements View.OnClickListener
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button gameButton = (Button) findViewById(R.id.game);
    gameButton.setOnClickListener(this);

    Button settingButton = (Button) findViewById(R.id.setting);
    settingButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v)
  {
    switch (v.getId())
    {
      case R.id.game:
        startActivity(new Intent(this, GameActivity.class));
        break;
      case R.id.setting:
        startActivity(new Intent(this, SettingActivity.class));
        break;
    }
  }
}
