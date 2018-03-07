package com.facebook.common.jobscheduler.compat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.persistablebundle.compat.PreLollipopPersistableBundleCompat;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task.Builder;
import java.util.concurrent.TimeUnit;

/* compiled from: social_usage_summary_sentence */
public class GcmNetworkManagerJobSchedulerCompat extends JobSchedulerCompat<GcmTaskServiceCompat> {
    private final Context f2645a;

    GcmNetworkManagerJobSchedulerCompat(Context context) {
        super(context, 1);
        this.f2645a = context;
    }

    protected final void m3759a(int i, Class<? extends GcmTaskServiceCompat> cls) {
        String a = GcmTaskServiceCompat.m3763a(i);
        Context context = this.f2645a;
        GcmNetworkManager.a(context).a(a, cls);
        PendingIntent service = PendingIntent.getService(context, 0, GcmTaskServiceCompat.m3768c(context, a, (Class) cls), 536870912);
        if (service != null) {
            ((AlarmManager) context.getSystemService("alarm")).cancel(service);
        }
    }

    protected final void m3760a(JobRequest jobRequest, Class<? extends GcmTaskServiceCompat> cls) {
        Builder builder;
        if (jobRequest.f2667g < 0) {
            OneoffTask.Builder builder2 = new OneoffTask.Builder();
            builder2.a(TimeUnit.MILLISECONDS.toSeconds(jobRequest.f2664d), TimeUnit.MILLISECONDS.toSeconds(jobRequest.f2665e > 0 ? jobRequest.f2665e : jobRequest.f2666f));
            builder = builder2;
        } else {
            builder = m3758c(jobRequest);
        }
        builder.b(cls);
        builder.b(GcmTaskServiceCompat.m3763a(jobRequest.f2661a));
        builder.d(true);
        switch (jobRequest.f2662b) {
            case 0:
                builder.b(2);
                break;
            case 1:
                builder.b(0);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                builder.b(1);
                break;
        }
        if (jobRequest.f2663c) {
            builder.e(jobRequest.f2663c);
        }
        if (jobRequest.f2668h != null) {
            builder.a(((PreLollipopPersistableBundleCompat) jobRequest.f2668h).f2724a);
        }
        GcmTaskServiceCompat.m3764a(this.f2645a, builder.c(), 0);
    }

    public static PeriodicTask.Builder m3758c(JobRequest jobRequest) {
        PeriodicTask.Builder builder = new PeriodicTask.Builder();
        builder.f6803i = TimeUnit.MILLISECONDS.toSeconds(jobRequest.f2667g);
        return builder;
    }
}
