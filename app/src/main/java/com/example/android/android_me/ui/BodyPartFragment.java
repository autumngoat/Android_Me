package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.zip.Inflater;

public class BodyPartFragment extends Fragment {
    // Empty constructor
    public BodyPartFragment(){ }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        // Grab view from fragment layout
        ImageView imageView = (ImageView)rootView.findViewById(R.id.fragment_body_part);
        // (3) Show the first image in the list of head images (3)
        // Set view
        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
        // Return the fragment View
        return rootView;
    }
}
