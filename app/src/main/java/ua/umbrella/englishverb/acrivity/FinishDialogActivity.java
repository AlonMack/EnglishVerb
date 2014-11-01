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
  Button btnOK;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.finish_dialog);

    scope = (TextView) findViewById(R.id.result);
    scope.setText(getIntent().getStringExtra("scope"));
    btnOK = (Button) findViewById(R.id.button_again);
    btnOK.setOnClickListener(this);
  }

  @Override
  public void onClick(View v)
  {
    Intent intent = new Intent();
    intent.putExtra("name", "yes");
    setResult(RESULT_OK, intent);
    finish();
  }
}
