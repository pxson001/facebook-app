package android.support.v7.app;

import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: upsell_continue_with_current_promo */
public class WindowLikeImpl implements WindowLike {
    private final Window f652a;

    public WindowLikeImpl(Window window) {
        this.f652a = window;
    }

    public final Callback mo235a() {
        return this.f652a.getCallback();
    }

    public final void mo238a(Callback callback) {
        this.f652a.setCallback(callback);
    }

    public final View mo239b() {
        return this.f652a.getDecorView();
    }

    public final View mo234a(int i) {
        return this.f652a.findViewById(i);
    }

    public final void mo237a(View view) {
        this.f652a.setContentView(view);
    }

    public final void mo236a(int i, int i2) {
        this.f652a.setLayout(i, i2);
    }

    public final boolean mo240b(int i) {
        return this.f652a.requestFeature(i);
    }
}
