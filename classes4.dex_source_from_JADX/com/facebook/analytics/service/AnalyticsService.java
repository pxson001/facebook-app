package com.facebook.analytics.service;

import android.content.Intent;
import android.os.IBinder;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.IAnalyticsService.Stub;
import com.facebook.base.service.FbService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.Lists;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: thread_presence */
public class AnalyticsService extends FbService {
    public static final Class<?> f1133a = AnalyticsService.class;
    private static final String f1134b = AnalyticsService.class.getSimpleName();
    private static String f1135c = "selfStart";
    private AbstractFbErrorReporter f1136d;
    private AnalyticsServiceStub f1137e;
    private AnalyticsEventUploader f1138f;
    public AnalyticsEventsDataStore f1139g;
    public Lazy<HoneyAnalyticsUploadHandler> f1140h;
    private DefaultAndroidThreadUtil f1141i;
    public final Object f1142j = new Object();
    private EventProcessorListener f1143k;
    @GuardedBy("mSelfStartSync")
    public boolean f1144l;

    /* compiled from: thread_presence */
    public class AnalyticsServiceStub extends Stub {
        final /* synthetic */ AnalyticsService f1145a;

        protected AnalyticsServiceStub(AnalyticsService analyticsService) {
            this.f1145a = analyticsService;
        }

        public final void mo85a(List<HoneyAnalyticsEvent> list) {
            this.f1145a.m1397a((List) list);
        }
    }

    /* compiled from: thread_presence */
    public class EventProcessorListener {
        final /* synthetic */ AnalyticsService f1146a;

        public EventProcessorListener(AnalyticsService analyticsService) {
            this.f1146a = analyticsService;
        }

        public final void m1409a() {
            synchronized (this.f1146a.f1142j) {
                if (this.f1146a.f1144l) {
                    this.f1146a.f1144l = false;
                    this.f1146a.stopSelf();
                }
            }
        }
    }

    public final void m1405a() {
        TracerDetour.a("AnalyticsService.onCreate", -2140164190);
        try {
            super.a();
            AppInitLockHelper.a(this);
            InjectorLike injectorLike = FbInjector.get(this);
            this.f1136d = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
            this.f1137e = new AnalyticsServiceStub(this);
            this.f1143k = new EventProcessorListener(this);
            this.f1138f = AnalyticsEventUploader.m1267a(injectorLike);
            this.f1138f.m1283a(this.f1143k);
            this.f1139g = AnalyticsEventsDataStore.m1410a(injectorLike);
            this.f1140h = IdBasedSingletonScopeProvider.b(injectorLike, 191);
            this.f1141i = DefaultAndroidThreadUtil.b(injectorLike);
        } finally {
            TracerDetour.a(-194721087);
        }
    }

    public final void m1406k() {
        TracerDetour.a("AnalyticsService.onDestroy", 1763701156);
        try {
            super.k();
            this.f1138f.m1288b(this.f1143k);
        } finally {
            TracerDetour.a(846703856);
        }
    }

    public final int m1404a(Intent intent, int i, int i2) {
        boolean z = false;
        TracerDetour.a("AnalyticsService.onStartCommand", 254564520);
        if (intent != null) {
            try {
                z = intent.getBooleanExtra(f1135c, false);
            } catch (Throwable th) {
                TracerDetour.a(2091265336);
            }
        }
        if (z) {
            synchronized (this.f1142j) {
                if (!this.f1144l) {
                    stopSelf(i2);
                }
            }
        } else {
            stopSelf(i2);
            this.f1136d.a(f1134b, "AnalyticsService was externally started.");
        }
        TracerDetour.a(1381889319);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return this.f1137e;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private Intent m1401c() {
        Intent intent = new Intent(this, getClass());
        intent.putExtra(f1135c, true);
        return intent;
    }

    private void m1397a(List<HoneyAnalyticsEvent> list) {
        synchronized (this.f1142j) {
            if (!this.f1144l) {
                if (startService(m1401c()) != null) {
                    this.f1144l = true;
                } else {
                    this.f1136d.a(f1134b, "Failed to start AnalyticsService.");
                }
            }
            List a = Lists.a();
            List a2 = Lists.a();
            for (HoneyAnalyticsEvent honeyAnalyticsEvent : list) {
                if (honeyAnalyticsEvent.b("upload_this_event_now")) {
                    a.add(honeyAnalyticsEvent);
                } else {
                    a2.add(honeyAnalyticsEvent);
                }
            }
            if (!a.isEmpty()) {
                this.f1141i.a(new SendEventNowTask(this), new List[]{a});
            }
            if (!a2.isEmpty()) {
                this.f1139g.m1419a(a2);
            }
        }
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f1142j) {
            printWriter.println("mSelfStartRequested: " + this.f1144l);
            this.f1138f.m1284a(printWriter);
            this.f1139g.m1418a(printWriter);
        }
    }
}
