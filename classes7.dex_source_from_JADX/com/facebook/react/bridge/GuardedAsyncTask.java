package com.facebook.react.bridge;

import android.os.AsyncTask;

/* compiled from: group_stories */
public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void> {
    private final ReactContext f11504a;

    protected abstract void mo731a(Params... paramsArr);

    protected GuardedAsyncTask(ReactContext reactContext) {
        this.f11504a = reactContext;
    }

    protected Object doInBackground(Object[] objArr) {
        try {
            mo731a(objArr);
        } catch (RuntimeException e) {
            this.f11504a.m13523a(e);
        }
        return null;
    }
}
