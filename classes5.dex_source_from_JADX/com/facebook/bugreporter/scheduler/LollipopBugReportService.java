package com.facebook.bugreporter.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.facebook.inject.FbInjector;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;

@TargetApi(21)
/* compiled from: android.intent.extra.STREAM */
public class LollipopBugReportService extends JobService {
    public boolean onStartJob(final JobParameters jobParameters) {
        Futures.a(BugReportRetryInvoker.m18793b(FbInjector.get(this)).m18794a(), new FutureCallback<Object>(this) {
            final /* synthetic */ LollipopBugReportService f10768b;

            public void onSuccess(@Nullable Object obj) {
                this.f10768b.jobFinished(jobParameters, false);
            }

            public void onFailure(Throwable th) {
                this.f10768b.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
