package com.example.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityforresult.util.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    //1
    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(this);
    }

    //2
    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, Constants.START_SECOND_ACTIVITY);
    }

    //3
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startSecondActivity();
                break;
            default:
                break;
        }
    }

    //4
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.START_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK) {
                tvTitle.setText(data.getStringExtra(Constants.RESULTADO));
            }
            if(resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
