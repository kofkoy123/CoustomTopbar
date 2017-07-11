package com.lzr.coustomtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Topbar.OnButtomClickListener{

    private Topbar mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopbar = (Topbar) findViewById(R.id.topbar);
        mTopbar.setOnButtomClickListener(this);
    }

    @Override
    public void onLeftClick(View v) {
        Toast.makeText(this,"返回",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRightClick(View v) {
        Toast.makeText(this,"更多",Toast.LENGTH_SHORT).show();
    }
}
