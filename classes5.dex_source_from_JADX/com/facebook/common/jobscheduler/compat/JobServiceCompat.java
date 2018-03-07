package com.facebook.common.jobscheduler.compat;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

@TargetApi(21)
/* compiled from: social_plugin */
public abstract class JobServiceCompat extends JobService {

    /* compiled from: social_plugin */
    class JobServiceCompatJobFinishedNotifier {
        final /* synthetic */ JobServiceCompat f2669a;
        private final JobParameters f2670b;

        public JobServiceCompatJobFinishedNotifier(JobServiceCompat jobServiceCompat, JobParameters jobParameters) {
            this.f2669a = jobServiceCompat;
            this.f2670b = jobParameters;
        }
    }

    protected abstract RunJobLogic m3771a();

    protected JobServiceCompat() {
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        RunJobLogic a = m3771a();
        jobParameters.getJobId();
        Bundle bundle = new Bundle(jobParameters.getExtras());
        JobServiceCompatJobFinishedNotifier jobServiceCompatJobFinishedNotifier = new JobServiceCompatJobFinishedNotifier(this, jobParameters);
        return a.m3775a();
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        RunJobLogic a = m3771a();
        jobParameters.getJobId();
        return a.m3776b();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1247149497);
        m3771a();
        int i3 = 2;
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 925118995, a);
        return i3;
    }
}
