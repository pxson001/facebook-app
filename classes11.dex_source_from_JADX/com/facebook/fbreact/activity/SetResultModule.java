package com.facebook.fbreact.activity;

import android.app.Activity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed to mutate message button nux state */
public class SetResultModule extends ReactContextBaseJavaModule {
    private static final Class<?> f7248a = SetResultModule.class;
    private AbstractFbErrorReporter f7249b;

    @Inject
    public SetResultModule(@Assisted ReactApplicationContext reactApplicationContext, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(reactApplicationContext);
        this.f7249b = abstractFbErrorReporter;
    }

    public String getName() {
        return "SetResultAndroid";
    }

    @ReactMethod
    public void setResultOK() {
        Activity r = m8464r();
        if (r != null) {
            r.setResult(-1);
        }
    }

    @ReactMethod
    public void setResultCanceled() {
        Activity r = m8464r();
        if (r != null) {
            r.setResult(0);
        }
    }

    @ReactMethod
    public void setResultFirstUser() {
        Activity r = m8464r();
        if (r != null) {
            r.setResult(1);
        }
    }

    @Nullable
    private Activity m8464r() {
        if (q() == null) {
            this.f7249b.a(f7248a.getSimpleName(), "currentAcitvity is null");
        }
        return q();
    }
}
