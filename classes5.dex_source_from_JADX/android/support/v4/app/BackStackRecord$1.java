package android.support.v4.app;

import android.support.v4.app.FragmentTransitionCompat21.ViewRetriever;
import android.view.View;

/* compiled from: withPrefix */
class BackStackRecord$1 implements ViewRetriever {
    final /* synthetic */ Fragment f27a;
    final /* synthetic */ BackStackRecord f28b;

    BackStackRecord$1(BackStackRecord backStackRecord, Fragment fragment) {
        this.f28b = backStackRecord;
        this.f27a = fragment;
    }

    public final View mo14a() {
        return this.f27a.T;
    }
}
