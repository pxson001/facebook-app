package com.facebook.placetips.pulsarcore.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.pulsarcore.PulsarController;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: last_reauth_ts */
public class PulsarService extends FbService {
    @Inject
    @ForUiThread
    Executor f9562a;
    @Inject
    Lazy<PulsarController> f9563b;
    @Inject
    PlaceTipsLocalLogger f9564c;

    private static <T extends Context> void m9942a(Class<T> cls, T t) {
        m9943a((Object) t, (Context) t);
    }

    public static void m9943a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PulsarService) obj).m9944a((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 9594), (PlaceTipsLocalLogger) PlaceTipsLocalLoggerImpl.a(fbInjector));
    }

    public final void m9945a() {
        super.a();
        Class cls = PulsarService.class;
        m9943a((Object) this, (Context) this);
        this.f9564c.a("Starting PulsarService");
        Futures.a(((PulsarController) this.f9563b.get()).a(), new 1(this), this.f9562a);
    }

    private void m9944a(Executor executor, Lazy<PulsarController> lazy, PlaceTipsLocalLogger placeTipsLocalLogger) {
        this.f9562a = executor;
        this.f9563b = lazy;
        this.f9564c = placeTipsLocalLogger;
    }

    public final void m9946k() {
        this.f9564c.a("Stopping PulsarService");
        super.k();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
