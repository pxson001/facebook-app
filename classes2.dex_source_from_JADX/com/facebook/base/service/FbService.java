package com.facebook.base.service;

import android.app.Service;
import android.content.Intent;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: save_draft */
public abstract class FbService extends Service implements PropertyBag {
    private static final String f6277a = FbService.class.getSimpleName();
    private final PropertyBagHelper f6278b = new PropertyBagHelper();
    private MultiplexBackgroundWorkObserver f6279c;
    private boolean f6280d = false;
    private boolean f6281e = false;
    private boolean f6282f = false;
    public ViewerContextManager f6283g;

    public final void onCreate() {
        long d;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1222283534);
        if (this.f6280d) {
            m10481a("Class %s called onCreate twice. This may be due to calling super.onCreate instead of super.onFbCreate", getClass().getName());
            m10483b();
            Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1954678776, a);
            return;
        }
        MultiplexBackgroundWorkObserver d2 = m10485d();
        if (d2 != null) {
            d = d2.m1686d();
        } else {
            d = -1;
        }
        try {
            this.f6280d = true;
            mo1459a();
        } finally {
            this.f6280d = false;
            if (d2 != null) {
                d2.mo234a(d, getClass());
            }
            LogUtils.d(1575057273, a);
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        Throwable th;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1976915100);
        if (this.f6281e) {
            m10481a("Class %s called onStartCommand twice. This may be due to calling super.onStartCommand instead of super.onFbStartCommand", getClass().getName());
            int b = m10482b(intent, i, i2);
            Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -823059481, a);
            return b;
        }
        MultiplexBackgroundWorkObserver d = m10485d();
        PushedViewerContext b2 = m10490b(intent);
        Throwable th2 = null;
        if (d != null) {
            try {
                long e = d.m1687e();
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
                if (b2 != null) {
                    if (th22 == null) {
                        b2.close();
                    } else {
                        b2.close();
                    }
                }
                LogUtils.d(59824891, a);
                throw th;
            }
        }
        e = -1;
        try {
            this.f6281e = true;
            b = mo1458a(intent, i, i2);
            this.f6281e = false;
            if (d != null) {
                d.mo235a(e, getClass(), intent);
            }
            if (b2 != null) {
                b2.close();
            }
            LogUtils.d(178358265, a);
            return b;
        } finally {
            this.f6281e = false;
            if (d != null) {
                d.mo235a(e, getClass(), intent);
            }
            LogUtils.d(-920876197, a);
        }
    }

    public final void onDestroy() {
        long f;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -268735013);
        if (this.f6282f) {
            m10481a("Class %s called onDestroy twice. This may be due to calling super.onDestroy instead of super.onFbDestroy", getClass().getName());
            m10484c();
            Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1036291230, a);
            return;
        }
        MultiplexBackgroundWorkObserver d = m10485d();
        if (d != null) {
            f = d.m1688f();
        } else {
            f = -1;
        }
        try {
            this.f6282f = true;
            mo3462k();
        } finally {
            this.f6282f = false;
            if (d != null) {
                d.mo239b(f, getClass());
            }
            LogUtils.d(-1432204620, a);
        }
    }

    protected void mo1459a() {
        m10483b();
    }

    private void m10483b() {
        super.onCreate();
    }

    protected int mo1458a(Intent intent, int i, int i2) {
        return m10482b(intent, i, i2);
    }

    private int m10482b(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void mo3462k() {
        m10484c();
    }

    private void m10484c() {
        super.onDestroy();
    }

    @Deprecated
    public final FbInjector m10492l() {
        return FbInjector.get(this);
    }

    private MultiplexBackgroundWorkObserver m10485d() {
        if (this.f6279c == null) {
            this.f6279c = MultiplexBackgroundWorkObserver.m1670a(m10492l());
        }
        return this.f6279c;
    }

    private void m10481a(String str, Object... objArr) {
        FbErrorReporterImpl.m2317a(m10492l()).m2351b(f6277a, StringFormatUtil.a(str, objArr), new Throwable());
    }

    public final void mo822a(Object obj, Object obj2) {
        this.f6278b.m6132a(obj, obj2);
    }

    public final Object mo818a(Object obj) {
        return this.f6278b.m6131a(obj);
    }

    protected final PushedViewerContext m10490b(@Nullable Intent intent) {
        if (intent == null || !intent.hasExtra("overridden_viewer_context")) {
            return PushedViewerContext.f14985a;
        }
        ViewerContext viewerContext = (ViewerContext) intent.getParcelableExtra("overridden_viewer_context");
        if (this.f6283g == null) {
            this.f6283g = ViewerContextManagerProvider.m2496b(m10492l());
        }
        return this.f6283g.mo214b(viewerContext);
    }
}
