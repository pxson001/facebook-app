package com.facebook.ui.keyboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.base.fragment.FbFragment;
import com.google.common.base.Preconditions;

/* compiled from: search_result_tapped */
public class SmoothKeyboardFragmentBehavior extends AbstractFbFragmentListener {
    public int f5156a = -1;

    public final void m7887a(Fragment fragment, View view, Bundle bundle) {
        FbFragment fbFragment = (FbFragment) fragment;
        Preconditions.checkArgument(this.f5156a == -1, "Previous soft input mode was never reset!");
        Window window = fbFragment.ao().getWindow();
        this.f5156a = window.getAttributes().softInputMode;
        window.setSoftInputMode((this.f5156a & -241) | 32);
    }

    public final void m7888b(Fragment fragment) {
        FbFragment fbFragment = (FbFragment) fragment;
        Preconditions.checkArgument(this.f5156a != -1, "Previous soft input mode was never recorded!");
        fbFragment.ao().getWindow().setSoftInputMode(this.f5156a);
        this.f5156a = -1;
    }
}
