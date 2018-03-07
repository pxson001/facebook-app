package com.facebook.analytics2.logger;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics2.logger.UploadServiceLogic.JobFinishedNotifier;
import com.facebook.analytics2.logger.UploadServiceLogic.StopServiceCallback;
import com.facebook.debug.log.BLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: textview_text */
public class LollipopUploadService extends JobService {
    @Nullable
    UploadServiceLogic f2029a;

    /* compiled from: textview_text */
    class JobFinishedJobFinishedNotifier implements JobFinishedNotifier {
        final /* synthetic */ LollipopUploadService f2027a;
        private final JobParameters f2028b;

        public JobFinishedJobFinishedNotifier(LollipopUploadService lollipopUploadService, JobParameters jobParameters) {
            this.f2027a = lollipopUploadService;
            this.f2028b = jobParameters;
        }

        public final void mo500a(boolean z) {
            Integer.valueOf(this.f2028b.getJobId());
            Boolean.valueOf(z);
            this.f2027a.jobFinished(this.f2028b, z);
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1066597169);
        this.f2029a = new UploadServiceLogic(this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 837422433, a);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            ((UploadServiceLogic) Assertions.b(this.f2029a)).m2794a(jobParameters.getJobId(), new UploadJobConfig(new Bundle(jobParameters.getExtras())), new JobFinishedJobFinishedNotifier(this, jobParameters));
            return true;
        } catch (Throwable e) {
            BLog.a("PostLolliopUploadService", "Misunderstood job service extras: %s", e);
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        ((UploadServiceLogic) Assertions.b(this.f2029a)).m2793a(jobParameters.getJobId());
        return true;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 970169453);
        int a2 = ((UploadServiceLogic) Assertions.b(this.f2029a)).m2792a(intent, new StopServiceCallback(this, i2));
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1871451629, a);
        return a2;
    }
}
