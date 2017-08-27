package com.example.chao.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by chao on 26/08/17.
 */

public class FileHelper {
    private static final int REQUEST_ID_READ_PERMISSION = 100;
    private static final int REQUEST_ID_WRITE_PERMISSION = 200;
    private final String fileName = "collectedData.txt";

    FileHelper(){
    }

//    private boolean askPermission(int requestId, String permissionName){
//        if (android.os.Build.VERSION.SDK_INT >= 23) {
//            int permission = ActivityCompat.checkSelfPermission(this, permissionName);
//
//            if (permission != PackageManager.PERMISSION_GRANTED) {
//                this.requestPermissions(
//                        new String[]{permissionName},
//                        requestId
//                );
//                return false;
//            }
//        }
//        return true;
//    }

    public void askPermissionAndCreateFile(){

//        boolean canCreate = this.askPermission(REQUEST_ID_WRITE_PERMISSION,
//               Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if (canCreate){
            File extStore = Environment.getExternalStorageDirectory();
            String path = extStore.getAbsolutePath() + "/" + fileName;
            Log.i("ExternalStorage", "save to: " + path);

        try {
            File collected_db = new File(path);
            collected_db.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
//        }else
//            Toast.makeText(getApplicationContext(), "canCreate failed", Toast.LENGTH_SHORT).show();
    }

    public void askPermissionAndWriteFile(LinkedList<InputObject> inputpassword_list,
                                           float[] location_values,
                                           float[] sensor_values) {
//        boolean canWrite = this.askPermission(REQUEST_ID_WRITE_PERMISSION,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE);

//        if (canWrite) {
            //Toast.makeText(getApplicationContext(), "canWrite Success",  Toast.LENGTH_SHORT).show();
            this.saveToCsv(inputpassword_list, location_values, sensor_values);
//        }
//        else{
//            Toast.makeText(getApplicationContext(), "canWrite Failed",  Toast.LENGTH_SHORT).show();
//        }
    }

    private void saveToCsv(LinkedList<InputObject> inputpassword_list,
                           float[] location_values,
                           float[] sensor_values){
        //Toast.makeText(getApplicationContext(), "Write Test",  Toast.LENGTH_SHORT).show();

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

//            FileOutputStream fOut = new FileOutputStream(filePath);
//            OutputStreamWriter myOutWrite = new OutputStreamWriter(fOut);
//            myOutWrite.append(collected_data);
//            myOutWrite.close();
//            fOut.close();
//            Toast.makeText(getApplicationContext(), fileName + " saved", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

//    private void askPermissionAndReadFile(){
//        boolean canRead = this.askPermission(REQUEST_ID_READ_PERMISSION,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE);
//
//        if (canRead){
//            this.readCsv();
//        }
//    }
//
//    private void readCsv(){
//        File extStore = Environment.getExternalStorageDirectory();
//        String path = extStore.getAbsolutePath() + "/" + fileName;
//        Log.i("ExternalStorage", "read to： " + path);
//        String s = "";
//        String fileContent = "collected data:";
//        try {
//            File myFile = new File(path);
//            FileInputStream fIn = new FileInputStream(myFile);
//            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
//
//            while ( (s = myReader.readLine()) != null ){
//                fileContent += s + "\n";
//            }
//            myReader.close();
//            this.tv1_display_only.setText(fileContent);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        Toast.makeText(getApplicationContext(), fileContent, Toast.LENGTH_LONG).show();
//    }

}
