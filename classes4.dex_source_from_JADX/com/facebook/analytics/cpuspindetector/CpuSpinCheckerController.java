package com.facebook.analytics.cpuspindetector;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ExecutorsModule;
import com.facebook.common.executors.ThreadPoolFactory;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: messenger_customthreads_color_themes */
public class CpuSpinCheckerController implements INeedInit {
    private static final Class<?> f8015a = CpuSpinCheckerController.class;
    public final GatekeeperStoreImpl f8016b;
    public final ScheduledExecutorService f8017c;
    public final CpuSpinCheckerWorker f8018d;
    public ScheduledFuture<?> f8019e;

    public static CpuSpinCheckerController m8323b(InjectorLike injectorLike) {
        return new CpuSpinCheckerController((Context) injectorLike.getInstance(Context.class, ForAppContext.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ExecutorsModule.b(ThreadPoolFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 375)), new CpuSpinCheckerWorker((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public CpuSpinCheckerController(@ForAppContext Context context, GatekeeperStoreImpl gatekeeperStoreImpl, ScheduledExecutorService scheduledExecutorService, CpuSpinCheckerWorker cpuSpinCheckerWorker) {
        this.f8016b = gatekeeperStoreImpl;
        this.f8017c = scheduledExecutorService;
        this.f8018d = cpuSpinCheckerWorker;
    }

    public void init() {
        if (this.f8016b.a(787, false)) {
            Long.valueOf(180);
            this.f8019e = this.f8017c.scheduleAtFixedRate(this.f8018d, 30, 180, TimeUnit.SECONDS);
        }
    }
}
