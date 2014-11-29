package ua.umbrella.englishverb.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import ua.umbrella.englishverb.R;

public class FinishDialog extends Dialog implements View.OnClickListener
{

  TextView result;
  Button buttonAgain;
  Button buttonExit;
  GameActivity activity;
  Intent intent;

  public FinishDialog(Context context)
  {
    super(context);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.dialog_finish);
    activity = (GameActivity) context;
    intent = activity.getIntent();

    result = (TextView) findViewById(R.id.result);

    buttonAgain = (Button) findViewById(R.id.button_again);
    buttonAgain.setOnClickListener(this);
    buttonExit = (Button) findViewById(R.id.button_exit);
    buttonExit.setOnClickListener(this);
    result.setText(((GameActivity)context).getScore().getText().toString());
  }

  @Override
  public void onClick(View v)
  {
    switch (v.getId())
    {
      case R.id.button_again:
        activity.setValueScore(0);
        activity.getScore().setText("0");
        activity.startTimer();
        activity.newLap();
        dismiss();
        break;
      case R.id.button_exit:
        onBackPressed();
        break;
    }
  }

  @Override
  public void onBackPressed()
  {
    super.onBackPressed();
    activity.finish();
    dismiss();
  }
}
