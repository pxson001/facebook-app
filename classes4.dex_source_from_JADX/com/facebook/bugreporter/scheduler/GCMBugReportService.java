package com.facebook.bugreporter.scheduler;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import javax.inject.Provider;

/* compiled from: isac_per_packet_ispx */
public class GCMBugReportService extends GcmTaskService {
    @Inject
    public volatile Provider<BugReportRetryInvoker> f9772a = UltralightRuntime.a;

    private static <T extends Context> void m10195a(Class<T> cls, T t) {
        m10196a((Object) t, (Context) t);
    }

    public static void m10196a(Object obj, Context context) {
        ((GCMBugReportService) obj).f9772a = IdBasedProvider.a(FbInjector.get(context), 5021);
    }

    private void m10197a(Provider<BugReportRetryInvoker> provider) {
        this.f9772a = provider;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1927930223);
        super.onCreate();
        Class cls = GCMBugReportService.class;
        m10196a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1145870797, a);
    }

    public final int m10198a(TaskParams taskParams) {
        ((BugReportRetryInvoker) this.f9772a.get()).a();
        return 0;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -648402867);
        if (intent == null) {
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1137976237, a);
                throw illegalArgumentException;
            } catch (Throwable e) {
                BLog.a("GCMBugReportService", e, "Unexpected service start parameters", new Object[0]);
                stopSelf(i2);
                LogUtils.d(-1796148610, a);
            }
        } else {
            i3 = super.onStartCommand(intent, i, i2);
            LogUtils.d(1368421170, a);
            return i3;
        }
    }
}
