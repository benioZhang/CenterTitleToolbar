package com.benio.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToolbar = toolbar;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.btn_notitle).setOnClickListener(this);
        findViewById(R.id.btn_showtitle).setOnClickListener(this);
        findViewById(R.id.btn_title).setOnClickListener(this);
        findViewById(R.id.btn_subtitle).setOnClickListener(this);
        findViewById(R.id.btn_title_color).setOnClickListener(this);
        findViewById(R.id.btn_title_appearance).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static final String TAG = "MainActivity";

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        Log.d(TAG, "onTitleChanged: " + title);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_title:
                // xml中定义了toolbar的title的话，调用这句会无效
                setTitle("Title");
                // 这句不会触发onTitleChanged方法
                // mToolbar.setTitle("Title");
                break;

            case R.id.btn_subtitle:
                mToolbar.setSubtitle("SubTitle");
                break;

            case R.id.btn_notitle:
                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayShowTitleEnabled(false);
                }
                break;

            case R.id.btn_title_color:
                mToolbar.setTitleTextColor(Color.GREEN);
                break;

            case R.id.btn_title_appearance:
                mToolbar.setTitleTextAppearance(this, android.R.style.TextAppearance_Holo);
                break;

            case R.id.btn_showtitle:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                }
                break;
            default:
                break;
        }
    }
}
