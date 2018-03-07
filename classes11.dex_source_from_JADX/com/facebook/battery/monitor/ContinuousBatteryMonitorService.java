package com.facebook.battery.monitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.ElapsedRealtimeSinceBoot;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: media_error_timed_out */
public class ContinuousBatteryMonitorService extends FbIntentService {
    private static final String f5478d = ContinuousBatteryMonitorService.class.getSimpleName();
    @ElapsedRealtimeSinceBoot
    @Inject
    public MonotonicClock f5479a;
    @Inject
    public AbstractFbErrorReporter f5480b;
    @Inject
    public AnalyticsLogger f5481c;

    @SuppressLint({"BadSuperClassBroadcastReceiver.SecureBroadcastReceiver"})
    /* compiled from: media_error_timed_out */
    public class BroadcastReceiver extends WakefulBroadcastReceiver {
        @Inject
        public QeAccessor f5477a;

        @Deprecated
        private static <T> void m6687a(Class<T> cls, T t, Context context) {
            m6688a(t, context);
        }

        public static void m6688a(Object obj, Context context) {
            ((BroadcastReceiver) obj).f5477a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
        }

        private void m6686a(QeAccessor qeAccessor) {
            this.f5477a = qeAccessor;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1988588986);
            if (this.f5477a == null) {
                Class cls = BroadcastReceiver.class;
                m6688a(this, context);
            }
            if (this.f5477a.a(ExperimentsForBatteryMonitorModule.f5482a, false)) {
                WakefulBroadcastReceiver.a(context, ContinuousBatteryMonitorService.m6689a(context, intent.getAction()));
                LogUtils.a(intent, 651475693, a);
                return;
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -135109420, a);
        }
    }

    private static <T extends Context> void m6691a(Class<T> cls, T t) {
        m6692a((Object) t, (Context) t);
    }

    public static void m6692a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ContinuousBatteryMonitorService continuousBatteryMonitorService = (ContinuousBatteryMonitorService) obj;
        MonotonicClock monotonicClock = (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        continuousBatteryMonitorService.f5479a = monotonicClock;
        continuousBatteryMonitorService.f5480b = abstractFbErrorReporter;
        continuousBatteryMonitorService.f5481c = a;
    }

    public static Intent m6689a(Context context, String str) {
        return new Intent(context, ContinuousBatteryMonitorService.class).setAction("action_report_battery_status").putExtra("trigger_type", str);
    }

    public ContinuousBatteryMonitorService() {
        super(f5478d);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1207372402);
        super.onCreate();
        Class cls = ContinuousBatteryMonitorService.class;
        m6692a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1920540915, a);
    }

    protected final void m6694a(Intent intent) {
        try {
            m6693b(intent);
        } finally {
            WakefulBroadcastReceiver.a(intent);
        }
    }

    private void m6693b(Intent intent) {
        if ("action_report_battery_status".equals(intent.getAction())) {
            Intent registerReceiver = registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                this.f5480b.a(f5478d, "the intent to get battery status is unavailable");
                return;
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            if (intExtra == -1) {
                this.f5480b.a(f5478d, "battery level is unavailable");
                return;
            }
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra2 == -1) {
                this.f5480b.a(f5478d, "battery scale is unavailable");
                return;
            } else {
                m6690a(intExtra, intExtra2, intent.getStringExtra("trigger_type"));
                return;
            }
        }
        this.f5480b.a(f5478d, "unknown intent action: " + intent.getAction());
    }

    private void m6690a(int i, int i2, String str) {
        HoneyClientEventFast a = this.f5481c.a("android_continuous_battery_drain", false);
        if (a.a()) {
            a.a("current_battery_level", i).a("max_battery_level", i2).a("trigger_type", str).a("elapsed_time_since_boot_ms", this.f5479a.now()).b();
        }
    }
}
