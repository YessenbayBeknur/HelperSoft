package com.example.helper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Survey_frag extends Fragment {
    View view;

    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.survey_frag_lay,container,false);
        TextView frag_title = Nav_activity.toolbar.findViewById(R.id.frag_title);
        frag_title.setText("Survey");
        return view;
    }
}
