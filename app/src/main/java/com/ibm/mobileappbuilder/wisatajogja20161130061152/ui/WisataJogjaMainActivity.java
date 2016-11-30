
package com.ibm.mobileappbuilder.wisatajogja20161130061152.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;
import com.ibm.mobileappbuilder.wisatajogja20161130061152.R;

public class WisataJogjaMainActivity extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
            sectionFragments.append(R.id.entry0, TempatWisataFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}
