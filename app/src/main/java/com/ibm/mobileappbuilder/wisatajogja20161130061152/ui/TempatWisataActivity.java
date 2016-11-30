

package com.ibm.mobileappbuilder.wisatajogja20161130061152.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.wisatajogja20161130061152.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * TempatWisataActivity list activity
 */
public class TempatWisataActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        if(isTaskRoot()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        setTitle(getString(R.string.tempatWisataActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return TempatWisataFragment.class;
    }

}
