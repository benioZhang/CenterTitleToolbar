package com.benio.toolbar;

import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ToolbarHelper {
    private TextView mTitleTextView;
    private Toolbar mToolbar;

    public void init(AppCompatActivity activity, Toolbar toolbar, TextView titleTextView) {
        if (activity == null) {
            return;
        }
        mTitleTextView = titleTextView;
        mToolbar = toolbar;
        activity.setSupportActionBar(toolbar);
        // titleTextView不为null才设置actionbar不显示Title
        if (titleTextView != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                // 不显示title和subTitle
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
    }

    public void setTitle(@StringRes int resid) {
        if (mTitleTextView != null) {
            mTitleTextView.setText(resid);
        }
    }

    public void setTitle(CharSequence title) {
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    public void setTitleTextColor(@ColorInt int color) {
        if (mTitleTextView != null) {
            mTitleTextView.setTextColor(color);
        }
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }
}