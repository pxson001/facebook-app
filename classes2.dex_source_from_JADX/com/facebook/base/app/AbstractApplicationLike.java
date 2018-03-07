package com.facebook.base.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.facebook.acra.ErrorReporter;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.impl.FbAppInitializer;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.process.PrivateProcessName;
import com.facebook.common.process.ProcessName;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.debug.activitytracer.ActivityTrace;
import com.facebook.debug.activitytracer.ActivityTracer;
import com.facebook.debug.activitytracer.AppStartupType;
import com.facebook.debug.coldstart.ColdStartTimer;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.Module;
import com.facebook.inject.autorequire.AutoRequireLoaderModule;
import com.facebook.inject.rootmodule.RootModuleProvider;
import com.facebook.perftestutils.FrameRateEventsTraceListener;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.resources.FbResources;
import com.facebook.systrace.SystraceMetadata;
import com.facebook.systrace.mainlooper.FbMainLooperTracerFactory;
import com.facebook.systrace.mainlooper.MainLooperTracer;
import com.facebook.systrace.mainlooper.MainLooperTracerFactory;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ‏ */
public abstract class AbstractApplicationLike extends ApplicationLike implements InjectableComponentWithContext {
    private static final String f8j = AbstractApplicationLike.class.getName();
    public final Application f9a;
    @Inject
    FbAppInitializer f10b;
    @Inject
    ActivityTracer f11c;
    @Inject
    @ForUiThread
    Executor f12d;
    @Inject
    volatile Lazy<FbResources> f13e;
    @Inject
    Lazy<MemoryManager> f14f;
    @Inject
    FbMainLooperTracerFactory f15g;
    @Inject
    FbAppType f16h;
    @Inject
    ColdStartTimer f17i;
    private final AtomicInteger f18k = new AtomicInteger();
    private LightweightPerfEvents f19l;
    private FbInjector f20m;

    /* compiled from: ‏ */
    /* synthetic */ class C00662 {
        static final /* synthetic */ int[] f1105a = new int[IntendedAudience.values().length];

        static {
            try {
                f1105a[IntendedAudience.DEVELOPMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1105a[IntendedAudience.PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1105a[IntendedAudience.FACEBOOK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: ‏ */
    class C01051 implements FutureCallback<Object> {
        final /* synthetic */ AbstractApplicationLike f1466a;

        C01051(AbstractApplicationLike abstractApplicationLike) {
            this.f1466a = abstractApplicationLike;
        }

        public void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            throw Throwables.propagate(th);
        }
    }

    private static <T extends InjectableComponentWithContext> void m15a(Class<T> cls, T t) {
        m16a((Object) t, t.getContext());
    }

    private static void m16a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AbstractApplicationLike) obj).m14a(FbAppInitializer.m1595a(injectorLike), ActivityTracer.m2212a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3278), IdBasedSingletonScopeProvider.m1810b(injectorLike, 580), FbMainLooperTracerFactory.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), ColdStartTimer.m2225a(injectorLike));
    }

    private static void m18d(ProcessName processName) {
        String str;
        if (TextUtils.isEmpty(processName.b)) {
            str = "empty";
        } else {
            str = processName.b;
        }
        ErrorReporter.getInstance().putCustomData("process_name_on_start", str);
    }

    public AbstractApplicationLike(Application application, FbAppType fbAppType, LightweightPerfEvents lightweightPerfEvents) {
        this.f9a = application;
        FbAppType.a = fbAppType;
        this.f19l = lightweightPerfEvents;
    }

    private static List<Module> m17c(ProcessName processName) {
        return ImmutableList.builder().m1069c(new AutoRequireLoaderModule(processName.c)).m1069c(RootModuleProvider.m1076a(processName)).m1068b();
    }

    private Application m19e() {
        return this.f9a;
    }

    public /* synthetic */ Context getContext() {
        return this.f9a;
    }

    public void mo2b() {
        Logger.getLogger(FinalizableReferenceQueue.class.getName()).setLevel(Level.SEVERE);
        m20f();
        AsyncTracer a = AsyncTracer.m1032a("Application startup");
        long nanoTime = System.nanoTime();
        SystraceMetadata.c();
        m23i();
        m22h();
        ProcessName g = ProcessName.g();
        mo1a(g);
        m18d(g);
        synchronized (this) {
            List c = m17c(g);
            PrivateProcessName d = g.d();
            this.f19l.b("ColdStart/FBInjector.create");
            try {
                this.f20m = FbInjector.m1077a(m19e(), c, d, BuildConstants.e());
                TracerDetour.a("ApplicationLike.onCreate#notifyAll", -336883825);
                try {
                    ObjectDetour.c(this, -1147033798);
                    TracerDetour.a(-1147033798);
                } finally {
                    int i = -1792850293;
                    TracerDetour.a(-1792850293);
                }
            } finally {
                g = this.f19l;
                nanoTime = "ColdStart/FBInjector.create";
                g.c(nanoTime);
            }
        }
        this.f19l.b("ColdStart/FBInjector.inject");
        try {
            m15a(AbstractApplicationLike.class, (InjectableComponentWithContext) this);
            m21g();
            mo3b(g);
            TracerDetour.a("FbAppInitializer.run", 1227857792);
            ListenableFuture a2;
            try {
                a2 = this.f10b.m1597a();
                this.f13e.get();
                this.f17i.m2227a((System.nanoTime() - nanoTime) / 1000000);
                this.f11c.m2218a(a, "cold_start");
                ActivityTrace a3 = this.f11c.m2217a();
                if (a3 != null) {
                    a3.m2792a(AppStartupType.COLD_START);
                }
                Futures.m2458a(a2, new C01051(this), this.f12d);
                MainLooperTracer.a(this.f15g);
                FrameRateEventsTraceListener.m2796c();
            } finally {
                a2 = 424135233;
                TracerDetour.a(424135233);
            }
        } finally {
            g = this.f19l;
            nanoTime = "ColdStart/FBInjector.inject";
            g.c(nanoTime);
            this.f19l = null;
        }
    }

    private static void m20f() {
        if (BuildConstants.i) {
            BLog.a(3);
        }
    }

    private void m14a(FbAppInitializer fbAppInitializer, ActivityTracer activityTracer, Executor executor, Lazy<FbResources> lazy, Lazy<MemoryManager> lazy2, MainLooperTracerFactory mainLooperTracerFactory, FbAppType fbAppType, ColdStartTimer coldStartTimer) {
        this.f10b = fbAppInitializer;
        this.f11c = activityTracer;
        this.f12d = executor;
        this.f13e = lazy;
        this.f14f = lazy2;
        this.f15g = mainLooperTracerFactory;
        this.f16h = fbAppType;
        this.f17i = coldStartTimer;
    }

    private void m21g() {
        int i;
        switch (C00662.f1105a[this.f16h.i.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = 3;
                break;
            default:
                i = 5;
                break;
        }
        BLog.a(i);
    }

    protected void mo1a(ProcessName processName) {
    }

    protected void mo3b(ProcessName processName) {
    }

    public final void m31c() {
        ((MemoryManager) this.f14f.get()).m9812a();
    }

    public final void m27a(int i) {
        MemoryManager memoryManager = (MemoryManager) this.f14f.get();
        Integer.valueOf(i);
        switch (i) {
            case 15:
            case 80:
                memoryManager.m9812a();
                return;
            default:
                return;
        }
    }

    public final synchronized FbInjector m26a() {
        while (this.f20m == null) {
            try {
                ObjectDetour.a(this, 1458017824);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.f20m;
    }

    private void m22h() {
        ErrorReporter.getInstance().putCustomData("app_on_create_count", Integer.toString(this.f18k.incrementAndGet()));
    }

    private void m23i() {
        m24j();
        m25k();
    }

    private static void m24j() {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable e) {
            BLog.a(f8j, "Exception trying to initialize AsyncTask", e);
        }
    }

    private void m25k() {
        try {
            this.f9a.getSystemService("audio");
        } catch (NotFoundException e) {
        } catch (NullPointerException e2) {
        }
    }

    public final Resources Q_() {
        return this.f13e == null ? null : (FbResources) this.f13e.get();
    }
}
