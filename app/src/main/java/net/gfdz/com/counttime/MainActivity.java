package net.gfdz.com.counttime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputEt;
    private Button btnGetTime,btnStart,btnStop;
    private TextView time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
   private void initView(){
       inputEt= (EditText) findViewById(R.id.inputTime);
       btnGetTime= (Button) findViewById(R.id.btnGetTime);
       btnGetTime.setOnClickListener(this);
       btnStart= (Button) findViewById(R.id.btnStart);
       btnStart.setOnClickListener(this);
       btnStop= (Button) findViewById(R.id.btnStop);
       btnStop.setOnClickListener(this);
       time= (TextView) findViewById(R.id.tvtime);
   }
    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.btnGetTime:
              time.setText(inputEt.getText().toString());
              break;
          case R.id.btnStart:
              break;
          case R.id.btnStop:
              break;
      }
    }
}
