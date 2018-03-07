package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask.Builder;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.TaskParams;
import javax.inject.Inject;

/* compiled from: display_locales */
public class BackgroundLocationReportingGcmUploadService extends GcmTaskService {
    @Inject
    FacebookOnlyIntentActionFactory f14882a;
    @Inject
    SecureContextHelper f14883b;

    private static <T extends Context> void m15346a(Class<T> cls, T t) {
        m15347a((Object) t, (Context) t);
    }

    public static void m15347a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BackgroundLocationReportingGcmUploadService) obj).m15345a(FacebookOnlyIntentActionFactory.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    static void m15344a(Context context, long j, long j2) {
        GcmNetworkManager a = GcmNetworkManager.a(context);
        Builder a2 = new Builder().a(BackgroundLocationReportingGcmUploadService.class).a(j, j2);
        a2.e = true;
        Task.Builder builder = a2;
        builder.a = 0;
        builder = builder;
        builder.c = "BGLR-" + System.nanoTime();
        a.a(builder.b());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -659322587);
        super.onCreate();
        Class cls = BackgroundLocationReportingGcmUploadService.class;
        m15347a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 2096176411, a);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 537598299);
        if (intent == null) {
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1940944692, a);
                throw illegalArgumentException;
            } catch (Throwable e) {
                BLog.a("background_location_reporting_gcm_upload", e, "Unexpected service start parameters", new Object[0]);
                stopSelf(i2);
                LogUtils.d(-1618804830, a);
            }
        } else {
            i3 = super.onStartCommand(intent, i, i2);
            LogUtils.d(-1383794640, a);
            return i3;
        }
    }

    public final int m15348a(TaskParams taskParams) {
        Context applicationContext = getApplicationContext();
        this.f14883b.c(BackgroundLocationReportingGcmUploadSchedulerService.m15332a(applicationContext, this.f14882a, taskParams.a), applicationContext);
        return 0;
    }

    private void m15345a(FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, SecureContextHelper secureContextHelper) {
        this.f14882a = facebookOnlyIntentActionFactory;
        this.f14883b = secureContextHelper;
    }
}
