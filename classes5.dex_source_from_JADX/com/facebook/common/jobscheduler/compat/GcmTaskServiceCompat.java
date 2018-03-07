package com.facebook.common.jobscheduler.compat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.TaskParams;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: social_usage_sentence_with_names */
public abstract class GcmTaskServiceCompat extends GcmTaskService {
    private static final long f2651a = TimeUnit.MINUTES.toMillis(5);
    private static final long f2652b = TimeUnit.MINUTES.toMillis(2);

    /* compiled from: social_usage_sentence_with_names */
    class GcmTaskServiceCompatJobFinishedNotifier {
        private boolean f2646a = true;
        private CountDownLatch f2647b = new CountDownLatch(1);

        public final boolean m3761a(long j) {
            while (true) {
                try {
                    break;
                } catch (InterruptedException e) {
                    j = (SystemClock.uptimeMillis() + j) - SystemClock.uptimeMillis();
                }
            }
            if (this.f2647b.await(j, TimeUnit.MILLISECONDS)) {
                return this.f2646a;
            }
            throw new TimeoutException();
        }
    }

    /* compiled from: social_usage_sentence_with_names */
    class TryScheduleParams {
        public final String f2648a;
        public final Task f2649b;
        public final int f2650c;

        public TryScheduleParams(Task task, int i) {
            this.f2648a = task.b;
            this.f2649b = task;
            this.f2650c = i;
        }

        public TryScheduleParams(Bundle bundle) {
            String string = bundle.getString("job_tag", null);
            if (string == null) {
                throw new IllegalRemoteArgumentException("Invalid job_tag: " + bundle.get("job_tag"));
            }
            this.f2648a = string;
            Task task = (Task) bundle.getParcelable("task");
            if (task == null) {
                throw new IllegalRemoteArgumentException("Missing task");
            }
            this.f2650c = bundle.getInt("num_failures", -1);
            if (this.f2650c <= 0) {
                throw new IllegalRemoteArgumentException("invalid num_failures: " + this.f2650c);
            }
            this.f2649b = task;
        }

        public final Bundle m3762a() {
            Bundle bundle = new Bundle();
            bundle.putString("job_tag", this.f2648a);
            bundle.putParcelable("task", this.f2649b);
            bundle.putInt("num_failures", this.f2650c);
            return bundle;
        }
    }

    protected abstract RunJobLogic m3770a();

    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 2000333845);
        if (intent == null) {
            try {
                IllegalRemoteArgumentException illegalRemoteArgumentException = new IllegalRemoteArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1344329694, a);
                throw illegalRemoteArgumentException;
            } catch (Throwable e) {
                BLog.b("GcmTaskServiceCompat", "Unexpected service start parameters", e);
                LogUtils.d(-1133190647, a);
            }
        } else {
            String action = intent.getAction();
            if (action.startsWith("com.facebook.common.jobscheduler.compat.GcmTaskServiceCompat.gms.TRY_SCHEDULE-")) {
                TryScheduleParams tryScheduleParams = new TryScheduleParams(intent.getExtras());
                m3764a(this, tryScheduleParams.f2649b, tryScheduleParams.f2650c);
                LogUtils.d(852979966, a);
            } else if (action.startsWith("com.google")) {
                i3 = super.onStartCommand(intent, i, i2);
                LogUtils.d(1283764449, a);
            } else {
                m3770a();
                i3 = RunJobLogic.m3774c();
                LogUtils.d(609333806, a);
            }
            return i3;
        }
    }

    public final int m3769a(TaskParams taskParams) {
        long uptimeMillis = SystemClock.uptimeMillis();
        String a = taskParams.m12710a();
        if (!a.matches("[0-9]+")) {
            return 0;
        }
        boolean a2;
        m3765b(a);
        GcmTaskServiceCompatJobFinishedNotifier gcmTaskServiceCompatJobFinishedNotifier = new GcmTaskServiceCompatJobFinishedNotifier();
        if (m3770a().m3775a()) {
            try {
                a2 = gcmTaskServiceCompatJobFinishedNotifier.m3761a(f2652b - (SystemClock.uptimeMillis() - uptimeMillis));
            } catch (TimeoutException e) {
                a2 = m3770a().m3776b();
            }
        } else {
            a2 = false;
        }
        if (a2) {
            return 1;
        }
        return 0;
    }

    public static String m3763a(int i) {
        return String.valueOf(i);
    }

    private static int m3765b(String str) {
        return Integer.parseInt(str);
    }

    public static void m3764a(Context context, Task task, int i) {
        GoogleApiAvailability.a();
        int a = GoogleApiAvailability.a(context);
        switch (a) {
            case 0:
                try {
                    GcmNetworkManager.a(context).a(task);
                    return;
                } catch (IllegalArgumentException e) {
                    DisabledServiceWorkaround.a(context, new ComponentName(context, task.a()), e);
                    return;
                }
            default:
                if (i >= 3) {
                    BLog.c("GcmTaskServiceCompat", "Job %s was not scheduled because Google Play Services became consistentlyunavailable after initial check: %s", new Object[]{task.b(), ConnectionResult.a(a)});
                    return;
                }
                ConnectionResult.a(a);
                m3766b(context, task, i + 1);
                return;
        }
    }

    private static void m3766b(Context context, Task task, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + f2651a;
        ((AlarmManager) context.getSystemService("alarm")).set(2, elapsedRealtime, PendingIntent.getService(context, 0, m3767c(context, task, i), 134217728));
    }

    private static Intent m3767c(Context context, Task task, int i) {
        try {
            Intent c = m3768c(context, task.b(), Class.forName(task.a()));
            c.putExtras(new TryScheduleParams(task, i).m3762a());
            return c;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Intent m3768c(Context context, String str, Class<? extends GcmTaskServiceCompat> cls) {
        return new Intent(context, cls).setAction("com.facebook.common.jobscheduler.compat.GcmTaskServiceCompat.gms.TRY_SCHEDULE-" + str).setPackage(context.getPackageName());
    }
}
