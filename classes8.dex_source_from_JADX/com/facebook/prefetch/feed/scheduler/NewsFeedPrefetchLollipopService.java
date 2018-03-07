package com.facebook.prefetch.feed.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.facebook.inject.FbInjector;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;

@TargetApi(21)
/* compiled from: resource_version */
public class NewsFeedPrefetchLollipopService extends JobService {
    public static final String f4481a = NewsFeedPrefetchLollipopService.class.getName();

    public boolean onStartJob(final JobParameters jobParameters) {
        Futures.a(NewsFeedPrefetchInvoker.m4322b(FbInjector.get(this)).m4323a(), new FutureCallback<Object>(this) {
            final /* synthetic */ NewsFeedPrefetchLollipopService f4480b;

            public void onFailure(Throwable th) {
                String str = NewsFeedPrefetchLollipopService.f4481a;
                th.getMessage();
                this.f4480b.jobFinished(jobParameters, false);
            }

            public void onSuccess(@Nullable Object obj) {
                this.f4480b.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
