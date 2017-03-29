package com.demo.lizejun.repoviewpager;

import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.demo.lizejun.repoviewpager.common.LogcatFragment;

import java.util.ArrayList;
import java.util.List;

public class NotUpdateActivity extends AppCompatActivity {

    private static final int INCREASE = 5;
    private NotUpdateAdapter mNotUpdateAdapter;
    private List<Fragment> mFragments;
    private int mLastIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_update);
        TextView textView = (TextView) findViewById(R.id.tv_update);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragments();
            }
        });
        initFragments();
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < INCREASE; i++) {
            //初始时刻有5个Fragment，每个Fragment和一条数据相关联.
            mFragments.add(LogcatFragment.newInstance("index=" + i));
        }
        mLastIndex = INCREASE;
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_content);
        mNotUpdateAdapter = new NotUpdateAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mNotUpdateAdapter);
    }

    private void updateFragments() {
        int startIndex = mLastIndex;
        mFragments.clear();
        for (int i = startIndex; i < startIndex + INCREASE; i++) {
            //更新时候生成新的5个Fragment，每个Fragment和一条数据向关联.
            mFragments.add(LogcatFragment.newInstance("index=" + i));
        }
        mLastIndex += INCREASE;
        mNotUpdateAdapter.notifyDataSetChanged();
    }

    private class NotUpdateAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> mFragments;

        public NotUpdateAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

    }
}
