package com.facebook.analytics2.logger;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.facebook.analytics2.logger.UploadJobConfig.PrimitiveMapWriter;
import com.facebook.analytics2.logger.UploadServiceLogic.StopServiceCallback;
import com.facebook.common.jobscheduler.compat.DisabledServiceWorkaround;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.OneoffTask.Builder;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.TaskParams;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressLint({"AlarmManagerUse", "SharedPreferencesUse"})
/* compiled from: system_triggered */
public class GooglePlayUploadService extends GcmTaskService {
    private static final long f3631a = TimeUnit.MINUTES.toMillis(2);
    private static final long f3632b = TimeUnit.MINUTES.toMillis(5);
    private static final AtomicInteger f3633c = new AtomicInteger(0);
    private static boolean f3634e = false;
    @Nullable
    private UploadServiceLogic f3635d;

    /* compiled from: system_triggered */
    class SharedPreferencesPrimitiveMapWriter implements PrimitiveMapWriter<Editor> {
        private final Editor f3666a;

        public SharedPreferencesPrimitiveMapWriter(Editor editor) {
            this.f3666a = editor;
        }

        public final Object mo780a() {
            return this.f3666a;
        }

        public final void a_(String str, String str2) {
            this.f3666a.putString(str, str2);
        }

        public final void a_(String str, int i) {
            this.f3666a.putInt(str, i);
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1030730689);
        this.f3635d = new UploadServiceLogic(this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 56126258, a);
    }

    @Nonnull
    private UploadServiceLogic m5886a() {
        return this.f3635d;
    }

    public static synchronized void m5890a(Context context, int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        synchronized (GooglePlayUploadService.class) {
            long j3 = j / 1000;
            long j4 = j2 / 1000;
            if (j3 == j4) {
                j4++;
            }
            OneoffTask b = new Builder().m5903a(GooglePlayUploadService.class).m5904a(m5892b(i)).m5901a(0).m5902a(j3, j4).m5908b(true).m5913c(f3634e).m5909b();
            m5889a(context, i, uploadJobConfig);
            m5891a(context, i, b);
            f3634e = true;
        }
    }

    private static void m5891a(Context context, int i, OneoffTask oneoffTask) {
        GoogleApiAvailability.m150a();
        int a = GoogleApiAvailability.m148a(context);
        switch (a) {
            case 0:
                try {
                    GcmNetworkManager.m5926a(context).m5929a((Task) oneoffTask);
                } catch (IllegalArgumentException e) {
                    DisabledServiceWorkaround.a(context, new ComponentName(context, oneoffTask.m5934a()), e);
                }
                f3633c.set(0);
                return;
            default:
                if (f3633c.incrementAndGet() == 3) {
                    BLog.c("GooglePlayUploadService", "Google Play Services became consistently unavailable after initial check: %s", new Object[]{ConnectionResult.m31392a(a)});
                    return;
                }
                ConnectionResult.m31392a(a);
                m5894b(context, i, oneoffTask);
                return;
        }
    }

    public static void m5888a(Context context, int i) {
        GcmNetworkManager.m5926a(context).m5931a(String.valueOf(i), GooglePlayUploadService.class);
        m5893b(context, i);
    }

    private static void m5894b(Context context, int i, OneoffTask oneoffTask) {
        ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + f3632b, PendingIntent.getService(context, 0, m5895c(context, i, oneoffTask), 134217728));
    }

    private static void m5893b(Context context, int i) {
        PendingIntent service = PendingIntent.getService(context, 0, m5895c(context, i, null), 536870912);
        if (service != null) {
            ((AlarmManager) context.getSystemService("alarm")).cancel(service);
        }
    }

    private static Intent m5895c(Context context, int i, @Nullable OneoffTask oneoffTask) {
        Intent action = new Intent(context, GooglePlayUploadService.class).setAction(m5887a(i));
        if (oneoffTask != null) {
            action.putExtras(new TryScheduleParams(i, oneoffTask).a());
        }
        return action;
    }

    private static void m5889a(Context context, int i, UploadJobConfig uploadJobConfig) {
        Editor edit = m5897d(context, i).edit();
        uploadJobConfig.m5645a(new SharedPreferencesPrimitiveMapWriter(edit));
        edit.commit();
    }

    private static UploadJobConfig m5896c(Context context, int i) {
        return new UploadJobConfig(new SharedPreferencesPrimitiveMapReader(m5897d(context, i)));
    }

    private static SharedPreferences m5897d(Context context, int i) {
        return context.getSharedPreferences(m5892b(i), 0);
    }

    private static String m5887a(int i) {
        return "com.facebook.analytics2.logger.gms.TRY_SCHEDULE-" + i;
    }

    private static String m5892b(int i) {
        return "analytics2-gcm-" + i;
    }

    private static int m5885a(String str) {
        try {
            return Integer.parseInt(str.split("-", 3)[2]);
        } catch (RuntimeException e) {
            throw new IllegalRemoteArgumentException(e.getMessage());
        }
    }

    public final int mo768a(TaskParams taskParams) {
        Throwable e;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int a = m5885a(taskParams.a());
            UploadJobConfig c = m5896c(this, a);
            BlockingJobFinishedNotifier blockingJobFinishedNotifier = new BlockingJobFinishedNotifier();
            m5886a().a(a, c, blockingJobFinishedNotifier);
            try {
                if (blockingJobFinishedNotifier.a(f3631a - (SystemClock.uptimeMillis() - uptimeMillis))) {
                    return 1;
                }
                return 0;
            } catch (TimeoutException e2) {
                m5886a().a(a);
                return 1;
            }
        } catch (NumberFormatException e3) {
            e = e3;
            BLog.a("GooglePlayUploadService", "Misunderstood job extras: %s", e);
            return 2;
        } catch (IllegalRemoteArgumentException e4) {
            e = e4;
            BLog.a("GooglePlayUploadService", "Misunderstood job extras: %s", e);
            return 2;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        IllegalRemoteArgumentException illegalRemoteArgumentException;
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 906668551);
        if (intent == null) {
            try {
                illegalRemoteArgumentException = new IllegalRemoteArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1634905976, a);
                throw illegalRemoteArgumentException;
            } catch (IllegalRemoteArgumentException illegalRemoteArgumentException2) {
                BLog.a("GooglePlayUploadService", "Unexpected service start parameters: %s", new Object[]{illegalRemoteArgumentException2.getMessage()});
                stopSelf(i2);
                LogUtils.d(-758250566, a);
            }
        } else {
            String action = intent.getAction();
            if (action.startsWith("com.facebook.analytics2.logger.gms.TRY_SCHEDULE")) {
                TryScheduleParams tryScheduleParams = new TryScheduleParams(intent.getExtras());
                m5891a((Context) this, tryScheduleParams.a, tryScheduleParams.b);
                LogUtils.d(-477882720, a);
            } else if (action.startsWith("com.facebook")) {
                i3 = m5886a().a(intent, new StopServiceCallback(this, i2));
                LogUtils.d(456369191, a);
            } else {
                i3 = super.onStartCommand(intent, i, i2);
                LogUtils.d(-229868435, a);
            }
            return i3;
        }
    }
}
