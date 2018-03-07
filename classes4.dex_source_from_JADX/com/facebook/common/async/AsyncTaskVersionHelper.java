package com.facebook.common.async;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: profilePictureHighRes */
public class AsyncTaskVersionHelper {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m4682a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (VERSION.SDK_INT >= 11) {
            return asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        }
        return asyncTask.execute(paramsArr);
    }
}
