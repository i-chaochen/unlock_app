package com.example.chao.myapplication;

/**
 * Created by chao on 01/06/17.
 */

public class InputObject {
    int inputDigit;
    float[] touch_location;
    float[] sensor_location;

    InputObject(int inputDigit, float[] touch_location, float[] sensor_location){
        this.inputDigit = inputDigit;
        this.touch_location = touch_location;
        this.sensor_location = sensor_location;
    }

    public int getInputDigit() {
        return this.inputDigit;
    }

    public void setInputDigit(int inputDigit) {
        this.inputDigit = inputDigit;
    }

    public float[] getTouch_location() {
        return touch_location;
    }

    public void setTouch_location(float[] touch_location) {
        this.touch_location = touch_location;
    }

    public float[] getSensor_location() {
        return sensor_location;
    }

    public void setSensor_location(float[] sensor_location) {
        this.sensor_location = sensor_location;
    }

}
