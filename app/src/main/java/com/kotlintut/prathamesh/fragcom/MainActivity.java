package com.kotlintut.prathamesh.fragcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.MessageReader{

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(findViewById(R.id.contain)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            BlankFragment frag=new BlankFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.contain,frag,null).commit();
        }
    }

    @Override
    public void message(String m) {

        tv=(TextView)findViewById(R.id.tv);
        tv.setText(m);
    }
}
