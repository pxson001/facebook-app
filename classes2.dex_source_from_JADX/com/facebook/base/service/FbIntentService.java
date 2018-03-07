package com.facebook.base.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Process;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.common.dispose.DisposableContext;
import com.facebook.common.dispose.DisposableContextHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: messenger_new_message_anchor */
public abstract class FbIntentService extends IntentService implements DisposableContext, PropertyBag {
    private final String f13858a;
    private final PropertyBagHelper f13859b = new PropertyBagHelper();
    private DisposableContextHelper f13860c;
    private BackgroundWorkLogger f13861d;
    private ViewerContextManager f13862e;
    private Lazy<FbErrorReporter> f13863f;

    protected abstract void mo2677a(Intent intent);

    public FbIntentService(String str) {
        super(str);
        this.f13858a = str;
    }

    @Deprecated
    public final FbInjector m20250a() {
        return FbInjector.get(this);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 2005901722);
        super.onCreate();
        this.f13860c = DisposableContextHelper.m6133b(m20250a());
        this.f13861d = BaseBackgroundWorkLogger.m1660a(m20250a());
        this.f13862e = ViewerContextManagerProvider.m2496b(m20250a());
        this.f13863f = IdBasedSingletonScopeProvider.m1810b(m20250a(), 494);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 596406765, a);
    }

    public final void onHandleIntent(Intent intent) {
        Throwable th;
        Process.setThreadPriority(ThreadPriority.NORMAL.getAndroidThreadPriority());
        PushedViewerContext b = m20249b(intent);
        Throwable th2 = null;
        try {
            StatsCollector a = this.f13861d.mo229a("IntentService", this.f13858a);
            if (a != null) {
                a.mo2832a();
            }
            try {
                mo2677a(intent);
                if (a != null) {
                    a.mo2833a(true);
                }
                if (b != null) {
                    b.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                if (a != null) {
                    a.mo2833a(false);
                }
            }
        } catch (Throwable th22) {
            Throwable th4 = th22;
            th22 = th;
            th = th4;
        }
        throw th;
        if (b != null) {
            if (th22 != null) {
                try {
                    b.close();
                } catch (Throwable th5) {
                    AndroidCompat.addSuppressed(th22, th5);
                }
            } else {
                b.close();
            }
        }
        throw th;
    }

    public final void mo822a(Object obj, Object obj2) {
        this.f13859b.m6132a(obj, obj2);
    }

    public final Object mo818a(Object obj) {
        return this.f13859b.m6131a(obj);
    }

    public final void mo821a(AbstractListenableDisposable abstractListenableDisposable) {
        this.f13860c.m6136a(abstractListenableDisposable);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1470632086);
        super.onDestroy();
        this.f13860c.m6135a();
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1736288014, a);
    }

    private PushedViewerContext m20249b(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra("overridden_viewer_context")) {
                    return this.f13862e.mo214b((ViewerContext) intent.getParcelableExtra("overridden_viewer_context"));
                }
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f13863f.get()).m2346a("cant_get_overriden_viewer_context", e);
                return PushedViewerContext.f14985a;
            }
        }
        return PushedViewerContext.f14985a;
    }
}
