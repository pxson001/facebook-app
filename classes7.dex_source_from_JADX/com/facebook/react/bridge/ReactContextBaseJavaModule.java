package com.facebook.react.bridge;

import android.app.Activity;
import javax.annotation.Nullable;

/* compiled from: universal_feedback_give_feedback */
public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public final ReactApplicationContext f1100a;

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.f1100a = reactApplicationContext;
    }

    protected final ReactApplicationContext m1069p() {
        return this.f1100a;
    }

    @Nullable
    protected final Activity m1070q() {
        return this.f1100a.m13537j();
    }
}
