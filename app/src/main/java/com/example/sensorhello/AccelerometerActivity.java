package com.example.sensorhello;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Surface;
import android.widget.ImageView;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView xText, yText, zText, statusText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        //Creates the sensor manager
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Creates sensor
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Create sensor listener
        mSensorManager.registerListener(this, mAccelerometer,mSensorManager.SENSOR_DELAY_NORMAL);
        xText = (TextView)findViewById(R.id.x);
        yText = (TextView)findViewById(R.id.y);
        zText = (TextView)findViewById(R.id.z);
        statusText = (TextView)findViewById(R.id.status);

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if(event.values[1] >= 9){
            statusText.setText("Vrid nedåt!");
        } else if(event.values[1] > 4 && event.values[1] < 8){
            statusText.setText("Du sitter helt PERFEKT!");
        } else if(event.values[1] < 3){
            statusText.setText("Vrid uppåt!");
        }

    }

}
