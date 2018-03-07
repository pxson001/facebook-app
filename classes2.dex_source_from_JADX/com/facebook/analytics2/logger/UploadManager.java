package com.facebook.analytics2.logger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.analytics2.logger.UploadServiceBus.JobRanResult;
import com.facebook.analytics2.logger.UploadServiceLogic.FallbackConfig;
import com.facebook.analytics2.logger.UploadServiceLogic.LogoutJobParams;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02003;
import com.facebook.crudolib.processname.ProcessNameHelper;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: t_tcpr */
class UploadManager implements UploadBatchNotifier<File> {
    final int f3418a;
    final UploadJobConfig f3419b;
    private final Context f3420c;
    private final C02003 f3421d;
    private final Class<? extends HandlerThreadFactory> f3422e;
    private final UploadSchedulerParams f3423f;
    private final UploadSchedulerParams f3424g;
    private boolean f3425h;
    private boolean f3426i;
    @GuardedBy("this")
    private long f3427j;
    @GuardedBy("this")
    private String f3428k;
    @GuardedBy("this")
    @Nullable
    private File f3429l;
    @GuardedBy("this")
    @Nullable
    private File f3430m;
    @GuardedBy("this")
    @Nullable
    private File f3431n;

    /* compiled from: t_tcpr */
    class JobRanReceiver extends BroadcastReceiver {
        final /* synthetic */ UploadManager f3514a;

        public JobRanReceiver(UploadManager uploadManager) {
            this.f3514a = uploadManager;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1734254982);
            JobRanResult jobRanResult = new JobRanResult(intent.getExtras());
            if (jobRanResult.a != this.f3514a.f3418a) {
                LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 44045524, a);
                return;
            }
            Integer.valueOf(jobRanResult.a);
            String.valueOf(jobRanResult.c);
            if (jobRanResult.b != null) {
                UploadManager.m5630c(this.f3514a, jobRanResult.b);
            }
            if (!jobRanResult.c) {
                if (jobRanResult.b == null) {
                    UploadManager.m5635h(this.f3514a);
                }
                int a2 = jobRanResult.d.a(ProcessNameHelper.m2551a());
                if (a2 >= 0) {
                    UploadManager.m5627b(this.f3514a, (File) jobRanResult.d.c(a2));
                }
            }
            LogUtils.a(intent, -1671353625, a);
        }
    }

    public final void mo751a(@Nullable Object obj) {
        File file = (File) obj;
        synchronized (this) {
            this.f3429l = file;
        }
    }

    public UploadManager(Context context, int i, UploadJobConfig uploadJobConfig, AppBackgroundedProvider appBackgroundedProvider, Class<? extends HandlerThreadFactory> cls, UploadSchedulerParams uploadSchedulerParams, UploadSchedulerParams uploadSchedulerParams2) {
        this.f3420c = context;
        this.f3418a = i;
        this.f3419b = uploadJobConfig;
        this.f3421d = appBackgroundedProvider;
        this.f3422e = cls;
        this.f3423f = uploadSchedulerParams;
        this.f3424g = uploadSchedulerParams2;
        m5635h(this);
    }

    public final void mo750a() {
        m5629c();
        m5623a(m5633f().f3208a, m5633f().f3209b);
    }

    public final void mo753b() {
        m5631d();
        m5623a(m5633f().f3210c, m5633f().f3211d);
    }

    private synchronized void m5623a(long j, long j2) {
        m5632e();
        if (this.f3428k == null && m5634g() > j) {
            m5626b(j, j2);
        }
    }

    private synchronized void m5629c() {
        this.f3430m = this.f3429l;
    }

    private synchronized void m5631d() {
        this.f3431n = this.f3429l;
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    private void m5632e() {
        if (!this.f3426i) {
            HandlerThread a = ContextConstructorHelper.m5559a(this.f3420c).m5563b(this.f3422e.getName()).mo735a("JobRanReceiver");
            a.start();
            this.f3420c.registerReceiver(new JobRanReceiver(this), new IntentFilter("com.facebook.analytics2.action.UPLOAD_JOB_RAN"), null, new Handler(a.getLooper()));
            this.f3426i = true;
        }
    }

    private UploadSchedulerParams m5633f() {
        if (this.f3421d.m5348a()) {
            return this.f3424g;
        }
        return this.f3423f;
    }

    private synchronized long m5634g() {
        if (!this.f3425h) {
            this.f3425h = true;
            this.f3427j = UploadScheduler.m5734a(this.f3420c).mo763b(this.f3418a);
        }
        return this.f3427j;
    }

    private synchronized void m5626b(long j, long j2) {
        if (j == 0 && j2 == 0) {
            Integer.valueOf(this.f3418a);
            UploadScheduler.m5734a(this.f3420c).mo761a(this.f3418a);
            m5635h(this);
            m5628b("com.facebook.analytics2.logger.UPLOAD_NOW");
            UploadSchedulerNoDelayHack.a().a(this.f3420c, "com.facebook.analytics2.logger.UPLOAD_NOW", this.f3419b, null, this.f3418a, new FallbackConfig(j, j2));
        } else {
            Integer.valueOf(this.f3418a);
            Long.valueOf(j);
            Long.valueOf(j2);
            UploadScheduler.m5734a(this.f3420c).mo762a(this.f3418a, this.f3419b, j, j2);
            this.f3427j = j;
        }
    }

    public static synchronized void m5635h(UploadManager uploadManager) {
        synchronized (uploadManager) {
            uploadManager.f3427j = Long.MAX_VALUE;
        }
    }

    public final synchronized void mo752a(@Nullable String str) {
        m5636i();
        UploadScheduler.m5734a(this.f3420c).mo761a(this.f3418a);
        m5635h(this);
        m5628b("com.facebook.analytics2.logger.USER_LOGOUT");
        UploadSchedulerNoDelayHack.a().a(this.f3420c, "com.facebook.analytics2.logger.USER_LOGOUT", this.f3419b, new LogoutJobParams(str).a(), this.f3418a, null);
    }

    private synchronized void m5628b(String str) {
        this.f3428k = str;
    }

    public static synchronized void m5630c(UploadManager uploadManager, String str) {
        synchronized (uploadManager) {
            if (uploadManager.f3428k != null && uploadManager.f3428k.equals(str)) {
                uploadManager.f3428k = null;
            }
        }
    }

    public static synchronized void m5627b(@Nullable UploadManager uploadManager, File file) {
        synchronized (uploadManager) {
            if (m5625b(uploadManager.f3431n, file) > 0) {
                m5624a(file, uploadManager.f3431n);
                uploadManager.mo753b();
            } else if (m5625b(uploadManager.f3430m, file) > 0) {
                m5624a(file, uploadManager.f3430m);
                uploadManager.mo750a();
            }
            uploadManager.m5636i();
        }
    }

    private static void m5624a(@Nullable File file, @Nullable File file2) {
        BLog.a("UploadManager", "Events logged to %s during upload session ending with %s, catching up...", new Object[]{file2, file});
    }

    private synchronized void m5636i() {
        this.f3431n = null;
        this.f3430m = null;
    }

    private static int m5625b(@Nullable File file, @Nullable File file2) {
        if (file2 == null) {
            return file == null ? 0 : 1;
        } else {
            if (file == null) {
                return -1;
            }
            return file.compareTo(file2);
        }
    }
}
