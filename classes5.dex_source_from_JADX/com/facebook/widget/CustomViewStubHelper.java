package com.facebook.widget;

import android.view.View;

/* compiled from: com.google.android.gms.signin.internal.idTokenRequested */
public class CustomViewStubHelper<T extends View> {
    private final CustomViewStub f5606a;
    public T f5607b;

    public static <T extends View> CustomViewStubHelper<T> m10407a(CustomViewStub customViewStub) {
        return new CustomViewStubHelper(customViewStub);
    }

    private CustomViewStubHelper(CustomViewStub customViewStub) {
        this.f5606a = customViewStub;
    }

    public final T m10408a() {
        if (this.f5607b == null) {
            this.f5607b = this.f5606a.m10406a();
        }
        return this.f5607b;
    }

    public final void m10410c() {
        Object obj;
        if (m10409b() && this.f5607b.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f5607b.setVisibility(8);
        }
    }

    public final boolean m10409b() {
        return this.f5607b != null;
    }

    public final void m10411d() {
        m10408a().setVisibility(0);
    }
}
