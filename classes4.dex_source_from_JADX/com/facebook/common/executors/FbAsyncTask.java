package com.facebook.common.executors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.facebook.common.async.AsyncTaskVersionHelper;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.inject.FbInjector;

/* compiled from: profilePictureLarge */
public abstract class FbAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private StatsCollector f4142a;

    protected abstract Result mo340a(Params... paramsArr);

    @SuppressLint({"FbInjectorGet"})
    public final FbAsyncTask<Params, Progress, Result> m4679a(Context context, Params... paramsArr) {
        return m4680a((BackgroundWorkLogger) BaseBackgroundWorkLogger.a(FbInjector.get(context.getApplicationContext())), (Object[]) paramsArr);
    }

    public final FbAsyncTask<Params, Progress, Result> m4680a(BackgroundWorkLogger backgroundWorkLogger, Params... paramsArr) {
        this.f4142a = backgroundWorkLogger.a("AsyncTask", getClass().getSimpleName());
        AsyncTaskVersionHelper.m4682a(this, paramsArr);
        return this;
    }

    protected final Result doInBackground(Params... paramsArr) {
        if (this.f4142a != null) {
            this.f4142a.a();
        }
        boolean z = false;
        try {
            Result a = mo340a(paramsArr);
            if (this.f4142a != null) {
                this.f4142a.a(true);
            }
            return a;
        } catch (Throwable th) {
            if (this.f4142a != null) {
                this.f4142a.a(z);
            }
        }
    }
}
