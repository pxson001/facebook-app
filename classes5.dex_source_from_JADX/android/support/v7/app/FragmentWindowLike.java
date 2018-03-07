package android.support.v7.app;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window.Callback;

/* compiled from: upsell_interstitial_impression */
public class FragmentWindowLike implements WindowLike {
    private Fragment f647a;
    private Callback f648b;

    public FragmentWindowLike(Fragment fragment, Callback callback) {
        this.f647a = fragment;
        this.f648b = callback;
    }

    public final Callback mo235a() {
        return this.f648b;
    }

    public final void mo238a(Callback callback) {
        this.f648b = callback;
    }

    public final View mo239b() {
        return this.f647a.T;
    }

    public final View mo234a(int i) {
        return this.f647a.T.findViewById(i);
    }

    public final void mo237a(View view) {
    }

    public final void mo236a(int i, int i2) {
    }

    public final boolean mo240b(int i) {
        return false;
    }
}
