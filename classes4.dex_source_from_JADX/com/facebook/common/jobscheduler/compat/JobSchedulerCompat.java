package com.facebook.common.jobscheduler.compat;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: messenger_mqtt_region */
public abstract class JobSchedulerCompat<T> {
    @GuardedBy("JobScheduler.class")
    private static JobSchedulerCompat f7947a;
    private final ServiceInfoParser f7948b;

    protected abstract void m8275a(int i, Class<? extends T> cls);

    protected abstract void m8277a(JobRequest jobRequest, Class<? extends T> cls);

    JobSchedulerCompat(Context context, int i) {
        this.f7948b = new ServiceInfoParser(context, i);
    }

    @Nullable
    public static synchronized JobSchedulerCompat m8273a(Context context) {
        JobSchedulerCompat jobSchedulerCompat;
        synchronized (JobSchedulerCompat.class) {
            if (f7947a == null) {
                if (VERSION.SDK_INT < 21) {
                    if (GmsMetadataReader.m8278a(context)) {
                        GoogleApiAvailability.a();
                        int a = GoogleApiAvailability.a(context);
                        switch (a) {
                            case 0:
                                f7947a = new GcmNetworkManagerJobSchedulerCompat(context);
                                break;
                            default:
                                ConnectionResult.a(a);
                                break;
                        }
                    }
                }
                f7947a = new LollipopJobSchedulerCompat(context);
            }
            jobSchedulerCompat = f7947a;
        }
        return jobSchedulerCompat;
    }

    public final void m8276a(JobRequest jobRequest) {
        Class a = this.f7948b.a(jobRequest.a);
        if (a == null) {
            throw new RuntimeException("jobId: " + jobRequest.a + " was not found.");
        }
        m8277a(jobRequest, a);
    }

    public final void m8274a(int i) {
        Class a = this.f7948b.a(i);
        if (a == null) {
            throw new RuntimeException("jobId: " + i + " was not found.");
        }
        m8275a(i, a);
    }
}
