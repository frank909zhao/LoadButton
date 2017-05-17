package com.frank.statusbuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.frank.loadbutton.LoadButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LoadButton mLoadButton;
    Button mBtnSuccessed,mBtnError,mBtnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadButton = (LoadButton) findViewById(R.id.btn_status);
        mBtnSuccessed = (Button) findViewById(R.id.btn_test_successed);
        mBtnError = (Button) findViewById(R.id.btn_test_error);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnError.setOnClickListener(this);
        mBtnSuccessed.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);

        mLoadButton.setListenner(new LoadButton.LoadListenner() {
            @Override
            public void onClick(boolean isSuccessed) {
                if ( isSuccessed ) {
                    Toast.makeText(MainActivity.this,"加载成功",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"加载失败",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void needLoading() {
                Toast.makeText(MainActivity.this,"重新下载",Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_test_successed:
                mLoadButton.loadSuccessed();
                break;

            case R.id.btn_test_error:
                mLoadButton.loadFailed();
                break;
            case R.id.btn_reset:
                mLoadButton.reset();
                break;

            default:
                break;
        }
    }
}
