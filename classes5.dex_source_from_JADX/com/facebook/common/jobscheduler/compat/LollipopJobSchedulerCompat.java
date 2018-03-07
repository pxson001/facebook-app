package com.facebook.common.jobscheduler.compat;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.persistablebundle.compat.LollipopPersistableBundleCompat;

@TargetApi(21)
/* compiled from: social_graph */
public class LollipopJobSchedulerCompat extends JobSchedulerCompat<JobServiceCompat> {
    private final Context f2671a;
    private final JobScheduler f2672b;

    LollipopJobSchedulerCompat(Context context) {
        super(context, 0);
        this.f2671a = context;
        this.f2672b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    protected final void m3773a(JobRequest jobRequest, Class<? extends JobServiceCompat> cls) {
        JobScheduler jobScheduler = this.f2672b;
        Builder builder = new Builder(jobRequest.f2661a, new ComponentName(this.f2671a, cls));
        if (jobRequest.f2664d > -1) {
            builder.setMinimumLatency(jobRequest.f2664d);
        }
        if (jobRequest.f2666f > -1) {
            builder.setOverrideDeadline(jobRequest.f2666f);
        }
        switch (jobRequest.f2662b) {
            case 0:
                builder.setRequiredNetworkType(0);
                break;
            case 1:
                builder.setRequiredNetworkType(1);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                builder.setRequiredNetworkType(2);
                break;
        }
        if (jobRequest.f2663c) {
            builder.setRequiresCharging(jobRequest.f2663c);
        }
        if (jobRequest.f2668h != null) {
            builder.setExtras(((LollipopPersistableBundleCompat) jobRequest.f2668h).f2723a);
        }
        int schedule = jobScheduler.schedule(builder.build());
    }

    protected final void m3772a(int i, Class<? extends JobServiceCompat> cls) {
        this.f2672b.cancel(i);
    }
}
