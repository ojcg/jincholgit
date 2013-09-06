package com.example.androidradiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup = null;
    private TextView message = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        message = (TextView)findViewById(R.id.message);
        btn = (Button)findViewById(R.id.btn);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == View.NO_ID) {
                    message.setText("선택된 아이템 없음");
                } else {
                	RadioButton radioButton=(RadioButton)findViewById(checkedId);
                    message.setText("선택된 라디오버튼 ID : " + radioButton.getText());
                }
            }
        });

        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                radioGroup.clearCheck();
            }
        });
    }

}

