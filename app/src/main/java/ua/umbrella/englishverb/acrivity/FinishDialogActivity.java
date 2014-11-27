package ua.umbrella.englishverb.acrivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ua.umbrella.englishverb.R;

public class FinishDialogActivity extends Activity implements View.OnClickListener
{

  TextView scope;
  Button btnAgain;
  Button btnExit;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.finish_dialog);

    scope = (TextView) findViewById(R.id.result);
    scope.setText(getIntent().getStringExtra("scope"));
    btnAgain = (Button) findViewById(R.id.button_again);
    btnAgain.setOnClickListener(this);
    btnExit = (Button) findViewById(R.id.button_exit);
    btnExit.setOnClickListener(this);
  }

  @Override
  public void onClick(View v)
  {
    Intent intent = new Intent();
    switch (v.getId())
    {
      case R.id.button_again:
        intent.putExtra("game", "yes");
        setResult(RESULT_OK, intent);
        finish();
        break;
      case R.id.button_exit:
        intent.putExtra("game", "no");
        setResult(RESULT_OK, intent);
        finish();
        break;
    }
  }
}
