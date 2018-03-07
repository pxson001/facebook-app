package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: view_details_cta_label */
public class AsyncTaskCompat {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m282a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
