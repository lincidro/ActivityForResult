package com.example.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.activityforresult.util.Constants;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAccept;
    EditText etTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    //1
    private void initView() {
        etTitle = findViewById(R.id.et_title);
        btnAccept = findViewById(R.id.btn_accept);

        btnAccept.setOnClickListener(this);
    }

    //2
    private void sendData(String title) {
        Intent intent = new Intent();
        intent.putExtra(Constants.RESULTADO, title);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    //3
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accept:
                String title = etTitle.getText().toString();
                sendData(title);
                break;
            default:
                break;
        }
    }
}
