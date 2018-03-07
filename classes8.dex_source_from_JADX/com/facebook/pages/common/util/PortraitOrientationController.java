package com.facebook.pages.common.util;

import android.support.v4.app.Fragment;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.base.fragment.FbFragment;

/* compiled from: copyright_annotation */
public class PortraitOrientationController extends AbstractFbFragmentListener {
    private int f16897a = -1;

    public final void m20197d(Fragment fragment) {
        this.f16897a = fragment.o().getRequestedOrientation();
        fragment.o().setRequestedOrientation(1);
    }

    public final void m20196c(Fragment fragment) {
        fragment.o().setRequestedOrientation(this.f16897a);
    }

    public final void m20198e(Fragment fragment) {
        ((FbFragment) fragment).b(this);
    }
}
