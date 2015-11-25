package net.gfdz.com.counttime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputEt;
    private Button btnGetTime,btnStart,btnStop;
    private TextView time;
    private int  i=0;
    private Timer timer=null;
    private TimerTask tt;
    private Handler mHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time.setText(msg.arg1+"");
            startTime();
        }
    };


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
              time.setText(inputEt.getText());
              i=Integer.parseInt(inputEt.getText().toString());
              break;
          case R.id.btnStart:
              startTime();
              break;
          case R.id.btnStop:
              StopTime();
              break;
      }
    }
    public void startTime(){
        timer=new Timer();
        tt=new TimerTask() {
            @Override
            public void run() {
                i--;
                Message msg=mHandler.obtainMessage();
                msg.arg1=i;
                mHandler.sendMessage(msg);

            }
        };
        timer.schedule(tt,1000);
    }
    public void StopTime(){
      timer.cancel();
    }
}
