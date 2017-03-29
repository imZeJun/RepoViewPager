package com.demo.lizejun.repoviewpager.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.lizejun.repoviewpager.R;

public class LogcatFragment extends Fragment {

    private static final String TAG = LogcatFragment.class.getSimpleName();
    private static final String TITLE = "title";

    private String getLogTag() {
        return TAG + "|" + getArguments().getString(TITLE);
    }

    public static LogcatFragment newInstance(String title) {
        LogcatFragment fragment = new LogcatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(getLogTag(), "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String title = bundle.getString(TITLE);
        View contentView = inflater.inflate(R.layout.fragment_not_update, container, false);
        TextView textView = (TextView) contentView.findViewById(R.id.tv_title);
        textView.setText(title);
        Log.d(getLogTag(), "onCreateView");
        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getLogTag(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getLogTag(), "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getLogTag(), "onDetach");
    }

}
