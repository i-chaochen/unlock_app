package com.example.chao.myapplication;


import android.content.Intent;
import android.Manifest;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;

import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DisplayPrimaryUserActivity extends AppCompatActivity {

    public static final int password_len = 4;

    LinkedList<InputObject> inputpassword_list = new LinkedList<>();
    LinkedList<InputObject> storedpassword_list = new LinkedList<>();

    // for sensor
    SensorManager mSensorManger;
//    TextView tv1_display_only;
    List mList;
    public static float[] sensor_values = new float[3];
    public float[] location_values = new float[2];

    //FileHelper fileHelper = new FileHelper();

    SensorEventListener sensor_event_listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            sensor_values = event.values;
            //fileHelper.askPermissionAndWriteFile(inputpassword_list, location_values, sensor_values);
            //askPermissionAndWriteFile();
            // display only
            //tv1_display_only.setText("\nlocation_x: " + location_values[0] +
            //                        "\nlocation_y: " + location_values[1] +
            //                        "\nsensor_x: " + sensor_values[0] +
            //                        "\nsensor_y: " + sensor_values[1] +
            //                        "\nsensor_z: " + sensor_values[2]);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };

    // for saving csv file
    private static final int REQUEST_ID_WRITE_PERMISSION = 200;
    private final String fileName = "collectedData.txt";

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


        button0.setOnTouchListener(new ButtonTouchListener());
        button1.setOnTouchListener(new ButtonTouchListener());
        button2.setOnTouchListener(new ButtonTouchListener());
        button3.setOnTouchListener(new ButtonTouchListener());
        button4.setOnTouchListener(new ButtonTouchListener());
        button5.setOnTouchListener(new ButtonTouchListener());
        button6.setOnTouchListener(new ButtonTouchListener());
        button7.setOnTouchListener(new ButtonTouchListener());
        button8.setOnTouchListener(new ButtonTouchListener());
        button9.setOnTouchListener(new ButtonTouchListener());
        reset_button.setOnTouchListener(new ButtonTouchListener());

        //Button readButton = (Button) findViewById(R.id.button_read);
        //readButton.setOnTouchListener(new ButtonTouchListener());

        askPermissionAndCreateFile();
//        fileHelper.askPermissionAndCreateFile();

    }

    @Override
    protected void onStart(){
        super.onStart();

        // for sensor
        //tv1_display_only = (TextView) findViewById(R.id.sensor_view);
        mSensorManger = (SensorManager) getSystemService(SENSOR_SERVICE);
        mList = mSensorManger.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (mList.size() > 0){
            mSensorManger.registerListener(sensor_event_listener, (Sensor) mList.get(0),
                                            SensorManager.SENSOR_DELAY_NORMAL);
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

    public class ButtonTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent event){
            switch (view.getId()){
                case R.id.button0:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_0 = new InputObject(0, location_values, sensor_values);
                        processInputObj(io_0);
                    }
                    break;

                case R.id.button1:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_1 = new InputObject(1, location_values, sensor_values);
                        processInputObj(io_1);
                    }
                    break;

                case R.id.button2:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_2 = new InputObject(2, location_values, sensor_values);
                        processInputObj(io_2);
                    }
                    break;

                case R.id.button3:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_3 = new InputObject(3, location_values, sensor_values);
                        processInputObj(io_3);
                    }
                    break;

                case R.id.button4:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_4 = new InputObject(4, location_values, sensor_values);
                        processInputObj(io_4);
                    }
                    break;

                case R.id.button5:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_5 = new InputObject(5, location_values, sensor_values);
                        processInputObj(io_5);
                    }
                    break;

                case R.id.button6:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_6 = new InputObject(6, location_values, sensor_values);
                        processInputObj(io_6);
                    }
                    break;

                case R.id.button7:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_7 = new InputObject(7, location_values, sensor_values);
                        processInputObj(io_7);
                    }
                    break;

                case R.id.button8:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_8 = new InputObject(8, location_values, sensor_values);
                        processInputObj(io_8);
                    }
                    break;

                case R.id.button9:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        InputObject io_9 = new InputObject(9, location_values, sensor_values);
                        processInputObj(io_9);
                    }
                    break;

                case R.id.reset_button:
                    location_values[0] = event.getX();
                    location_values[1] = event.getY();

                    if (event.getAction() == MotionEvent.ACTION_DOWN && storedpassword_list.size() != 0){
                        storedpassword_list.clear();
                        inputpassword_list.clear();
                    }
                    break;

//                case R.id.button_read:
//                    if (event.getAction() == MotionEvent.ACTION_DOWN){
//                        askPermissionAndReadFile();
//                    }
//                    break;

                default:
                    break;
            }
            return true;
        }
    }

    private void processInputObj(InputObject inputObject){
        boolean wrong_flag = false;
        if (storedpassword_list.size() != password_len){
            storedpassword_list.add(inputObject);
            askPermissionAndWriteFile();
        }else{
            inputpassword_list.add(inputObject);
            askPermissionAndWriteFile();
            // verify this input password
            if (inputpassword_list.size() == password_len){
                Iterator<InputObject> input_it = inputpassword_list.iterator();
                Iterator<InputObject> store_it = storedpassword_list.iterator();

                while (input_it.hasNext() && store_it.hasNext()){
                    if (input_it.next().getInputDigit() != store_it.next().getInputDigit()){
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

    private boolean askPermission(int requestId, String permissionName){
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            int permission = ActivityCompat.checkSelfPermission(this, permissionName);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(
                        new String[]{permissionName},
                        requestId
                );
                return false;
            }
        }
        return true;
    }

    private void askPermissionAndWriteFile() {
        boolean canWrite = this.askPermission(REQUEST_ID_WRITE_PERMISSION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (canWrite) {
            this.saveToCsv();
        }else{
            Toast.makeText(getApplicationContext(), "canWrite Failed",  Toast.LENGTH_SHORT).show();
        }
    }

    private void askPermissionAndCreateFile(){
        boolean canCreate = this.askPermission(REQUEST_ID_WRITE_PERMISSION,
                             Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (canCreate){
            File extStore = Environment.getExternalStorageDirectory();
            String path = extStore.getAbsolutePath() + "/" + fileName;
            Log.i("ExternalStorage", "save to: " + path);

            try {
                File collected_db = new File(path);
                collected_db.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }else
            Toast.makeText(getApplicationContext(), "canCreate failed", Toast.LENGTH_SHORT).show();
    }

    private void saveToCsv(){

        Calendar curr_cal = Calendar.getInstance();
        File extStore = Environment.getExternalStorageDirectory();

        FileWriter fw = null;
        BufferedWriter bw = null;

        // ==> /storage/emulated/0/collectedData.csv
        String filePath = extStore.getAbsolutePath() + "/" + fileName;
        Log.i("ExternalStorage", "save to: " + filePath);

        String collected_data = curr_cal.get(Calendar.HOUR) + "," + curr_cal.get(Calendar.MINUTE) + ","
                              + curr_cal.get(Calendar.SECOND) + "," + curr_cal.get(Calendar.MILLISECOND) + ","
                              + inputpassword_list.size() + "," + location_values[0] + "," + location_values[1] + ","
                              + sensor_values[0] + "," + sensor_values[1] + "," + sensor_values[2] + "\n";

        try {
            fw = new FileWriter(filePath, true);
            bw = new BufferedWriter(fw);

            bw.write(collected_data);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
    }
}


