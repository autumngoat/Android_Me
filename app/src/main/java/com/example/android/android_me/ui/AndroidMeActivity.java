/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    // COMPLETED (1) Create a layout file that displays one body part image named fragment_body_part.xml
        // This layout should contain a single ImageView

    // COMPLETED (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
        // In this class, you'll need to implement an empty constructor and the onCreateView method
        // COMPLETED (3) Show the first image in the list of head images
            // Soon, you'll update this image display code to show any image you want

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Completed (5) Create a new BodyPartFragment instance and display it using the FragmentManager
        BodyPartFragment bodyPartFragment = new BodyPartFragment();
        // Return the FragmentManager for interacting with Fragments associated with this Activity,
        // used to create transactions for adding, removing, and replacing fragments
        FragmentManager fm = getSupportFragmentManager();
        // Start a series of edit operations Fragments associated with this FragmentManager
        FragmentTransaction ft = fm.beginTransaction();
        // Add Fragment to the container
        ft.add(R.id.fragment_container, bodyPartFragment);
        // Schedules a commit of this transaction (does not happen immediately) to be done on the
        // main/UI thread when thread next becomes available
        ft.commit();
    }
}
