package com.benio.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ToolbarHelperActivity extends AppCompatActivity {
    private ToolbarHelper mToolbarHelper = new ToolbarHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_helper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleView = (TextView) findViewById(R.id.toolbar_title);
        mToolbarHelper.init(this, toolbar, titleView);
        final EditText editText = (EditText) findViewById(R.id.et_title);
        findViewById(R.id.btn_settitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence title = editText.getText();
                // 这里不要toolbar.setTitle()，该方法不会触发onTitleChanged()
                setTitle(title);
            }
        });
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mToolbarHelper != null) {
            mToolbarHelper.setTitle(title);
        }
    }
}
