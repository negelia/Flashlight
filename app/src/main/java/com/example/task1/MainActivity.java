package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bFlash;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        bFlash = findViewById(R.id.b1);
        flashClass = new FlashClass(this);

    }
    public void onClickFlash(View view)
    {
        if(flashClass.isFlash_status())
        {
            flashClass.flashOff();
            bFlash.setText("On");
            bFlash.setBackgroundResource(R.drawable.circle_green);

        }
        else
        {
            flashClass.flashOn();
            bFlash.setText("Off");
            bFlash.setBackgroundResource(R.drawable.circle_red);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_status())
        {
            flashClass.flashOff();
        }
    }
}