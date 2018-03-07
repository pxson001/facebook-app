package com.facebook.actionbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.base.fragment.FragmentManagerHost;

/* compiled from: bd_data_cleanup */
public class FragmentActionBarHost extends ActivityActionBarActivityOverriderHost implements FragmentManagerHost {
    private final Fragment f8014a;

    public FragmentActionBarHost(Fragment fragment) {
        this.f8014a = fragment;
    }

    public final FragmentManager kO_() {
        return this.f8014a.D;
    }

    public final void gE_() {
        this.f8014a.C();
    }
}
