package com.facebook.analytics2.logger;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.facebook.analytics2.logger.UploadJobConfig.PrimitiveMapReader;
import com.facebook.analytics2.logger.UploadJobConfig.PrimitiveMapWriter;
import com.facebook.common.jobscheduler.compat.DisabledServiceWorkaround;

@TargetApi(21)
/* compiled from: the border width cannot be < 0 */
class LollipopUploadScheduler extends UploadScheduler {
    private final Context f2024a;
    private final JobScheduler f2025b;
    private final ComponentName f2026c;

    /* compiled from: the border width cannot be < 0 */
    class PersistableBundlePrimitiveMapper implements PrimitiveMapReader, PrimitiveMapWriter<PersistableBundle> {
        private final PersistableBundle f2023a;

        public PersistableBundlePrimitiveMapper(PersistableBundle persistableBundle) {
            this.f2023a = persistableBundle;
        }

        public final Object m2722a() {
            return this.f2023a;
        }

        public final String m2723a(String str, String str2) {
            return this.f2023a.getString(str, str2);
        }

        public final int m2721a(String str, int i) {
            return this.f2023a.getInt(str, i);
        }

        public final void a_(String str, String str2) {
            this.f2023a.putString(str, str2);
        }

        public final void a_(String str, int i) {
            this.f2023a.putInt(str, i);
        }
    }

    LollipopUploadScheduler(Context context) {
        this.f2024a = context;
        this.f2025b = (JobScheduler) context.getSystemService("jobscheduler");
        this.f2026c = new ComponentName(context, LollipopUploadService.class);
    }

    public final String m2724a() {
        return "jobscheduler";
    }

    public final void m2726a(int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        try {
            this.f2025b.schedule(new Builder(i, this.f2026c).setMinimumLatency(j).setOverrideDeadline(j2).setExtras((PersistableBundle) uploadJobConfig.a(new PersistableBundlePrimitiveMapper(new PersistableBundle()))).setRequiredNetworkType(1).setPersisted(false).build());
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.a(this.f2024a, this.f2026c, e);
        }
    }

    public final void m2725a(int i) {
        this.f2025b.cancel(i);
    }

    public final ComponentName m2728b() {
        return this.f2026c;
    }

    public final long m2727b(int i) {
        for (JobInfo jobInfo : this.f2025b.getAllPendingJobs()) {
            if (jobInfo.getId() == i) {
                return jobInfo.getMinLatencyMillis();
            }
        }
        return Long.MAX_VALUE;
    }
}
