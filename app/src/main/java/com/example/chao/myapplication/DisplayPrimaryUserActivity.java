package com.example.chao.myapplication;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DisplayPrimaryUserActivity extends AppCompatActivity {

    public static final int password_len = 4;

    LinkedList<Integer> inputpassword_list = new LinkedList<>();
    LinkedList<Integer> storedpassword_list = new LinkedList<>();

    // for sensor
    SensorManager mSensorManger;
    TextView tv1;
    List mList;

    SensorEventListener sensor_event_listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            tv1.setText("x: " + values[0] + "\ny: " + values[1] + "\nz: " + values[2]);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_primary_user);

        Button button0 = (Button)findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button reset_button = (Button)findViewById(R.id.reset_button);

        button0.setOnClickListener(new clickListener());
        button1.setOnClickListener(new clickListener());
        button2.setOnClickListener(new clickListener());
        button3.setOnClickListener(new clickListener());
        button4.setOnClickListener(new clickListener());
        button5.setOnClickListener(new clickListener());
        button6.setOnClickListener(new clickListener());
        button7.setOnClickListener(new clickListener());
        button8.setOnClickListener(new clickListener());
        button9.setOnClickListener(new clickListener());
        reset_button.setOnClickListener(new clickListener());
    }

    @Override
    protected void onStart(){
        super.onStart();

        // for sensor
        tv1 = (TextView) findViewById(R.id.sensor_view);
        mSensorManger = (SensorManager) getSystemService(SENSOR_SERVICE);
        mList = mSensorManger.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (mList.size() > 0){
            mSensorManger.registerListener(sensor_event_listener, (Sensor) mList.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error No Accelerometer", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onStop(){
        if (mList.size() > 0){
            mSensorManger.unregisterListener(sensor_event_listener);
        }
        super.onStop();
    }

    public class clickListener implements View.OnClickListener {
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button0:
                    Integer i0 = new Integer(0);
                    processPassword(i0);
                    break;
                case R.id.button1:
                    Integer i1 = new Integer(1);
                    processPassword(i1);
                    break;
                case R.id.button2:
                    Integer i2 = new Integer(2);
                    processPassword(i2);
                    break;
                case R.id.button3:
                    Integer i3 = new Integer(3);
                    processPassword(i3);
                    break;
                case R.id.button4:
                    Integer i4 = new Integer(4);
                    processPassword(i4);
                    break;
                case R.id.button5:
                    Integer i5 = new Integer(5);
                    processPassword(i5);
                    break;
                case R.id.button6:
                    Integer i6 = new Integer(6);
                    processPassword(i6);
                    break;
                case R.id.button7:
                    Integer i7 = new Integer(7);
                    processPassword(i7);
                    break;
                case R.id.button8:
                    Integer i8 = new Integer(8);
                    processPassword(i8);
                    break;
                case R.id.button9:
                    Integer i9 = new Integer(9);
                    processPassword(i9);
                    break;
                case R.id.reset_button:
                    if (storedpassword_list.size() != 0){
                        storedpassword_list.clear();
                        inputpassword_list.clear();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void processPassword(Integer input_integer){
        boolean wrong_flag = false;
        // this password has not stored
        if (storedpassword_list.size() != password_len){
            storedpassword_list.add(input_integer);
        }else{
            inputpassword_list.add(input_integer);
            // verify this inputpassword_list
            // TODO: monitor and collect user input habits
            if (inputpassword_list.size() == password_len){
                Iterator<Integer> input_it = inputpassword_list.iterator();
                Iterator<Integer> store_it = storedpassword_list.iterator();

                while (input_it.hasNext() && store_it.hasNext()){
                    if (input_it.next().intValue() != store_it.next().intValue()){
                        Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                        wrong_flag = true;
                        break;
                    }
                }
                // password correct
                if (!wrong_flag){
                    Intent unlockIntent = new Intent();
                    unlockIntent.setClass(DisplayPrimaryUserActivity.this, UnlockActivity.class);
                    DisplayPrimaryUserActivity.this.startActivity(unlockIntent);
                }
                inputpassword_list.clear();
            }
        }
    }
}


