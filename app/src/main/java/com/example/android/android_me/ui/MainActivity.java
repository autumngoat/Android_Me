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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // Completed (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        // List range is 0 to 35 or max size 36, divide by 12 will result in a range of 0 to 2 or a
        // max size of 3 to help ID whether the position is a head/body/leg
        int bodyPartNumber = position / 12;
        // However, each individual list of heads/bodies/legs is 0 to 11 or 12 items so we must get
        // number between 0 and 11 to get the proper head/body/leg
        //   EX: position == 35, bodyPartNumber == 2, listIndex == 35 - 2 * 12 == 11 DING DING DING!
        int listIndex = position - bodyPartNumber * 12;
        switch(bodyPartNumber){
            case 0: // Head 0 - 11
                mHeadIndex = listIndex;
                break;
            case 1: // Body 12 - 23
                mBodyIndex = listIndex;
                break;
            case 2: // Legs 24 - 35
                mLegsIndex = listIndex;
                break;
            default:
                break;
        }

        // Completed (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle b = new Bundle();
        b.putInt("headKey", mHeadIndex);
        b.putInt("bodyKey", mBodyIndex);
        b.putInt("legsKey", mLegsIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtra("bodyParts", b);

        // Completed (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

}
