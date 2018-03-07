package com.facebook.timeline.service;

import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.base.service.FbBackgroundService;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.SingleThreadedExecutorService;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.service.ProfileLoadRequest.Parameters.Builder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_order_id */
public class ProfileLoaderService extends FbBackgroundService {
    private static final Class f12701e = ProfileLoaderService.class;
    @Inject
    @SingleThreadedExecutorService
    ScheduledExecutorService f12702b;
    @Inject
    FbHandlerThreadFactory f12703c;
    @Inject
    ProfileLoadManager f12704d;
    private final int f12705f = 5;
    private final int f12706g = 2;
    private ScheduledFuture<?> f12707h;
    private boolean f12708i;

    /* compiled from: extra_order_id */
    class C17821 implements Runnable {
        final /* synthetic */ ProfileLoaderService f12700a;

        C17821(ProfileLoaderService profileLoaderService) {
            this.f12700a = profileLoaderService;
        }

        public void run() {
            if (!this.f12700a.f12704d.f12680m.m12644a()) {
                this.f12700a.stopSelf();
            }
        }
    }

    private static <T extends Context> void m12650a(Class<T> cls, T t) {
        m12651a((Object) t, (Context) t);
    }

    public static void m12651a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileLoaderService) obj).m12652a(ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), FbHandlerThreadFactory.a(injectorLike), ProfileLoadManager.m12613b(injectorLike));
    }

    private void m12652a(ScheduledExecutorService scheduledExecutorService, FbHandlerThreadFactory fbHandlerThreadFactory, ProfileLoadManager profileLoadManager) {
        this.f12702b = scheduledExecutorService;
        this.f12703c = fbHandlerThreadFactory;
        this.f12704d = profileLoadManager;
    }

    protected final Looper m12654c() {
        if (!this.f12708i) {
            Class cls = ProfileLoaderService.class;
            m12651a((Object) this, (Context) this);
            this.f12708i = true;
        }
        HandlerThread a = this.f12703c.a(f12701e.getName());
        a.start();
        return a.getLooper();
    }

    protected final void m12655d() {
        this.f12707h = this.f12702b.scheduleAtFixedRate(new C17821(this), 5, 2, TimeUnit.SECONDS);
    }

    protected final void m12653a(Intent intent) {
        if (intent == null) {
            this.f12704d.m12617a();
        } else if (intent.hasExtra("com.facebook.katana.profile.id")) {
            this.f12704d.m12618a(new ProfileLoadRequest(new Builder(intent).m12631a()));
        }
    }

    @Nullable
    protected final Integer m12656e() {
        return Integer.valueOf(1);
    }

    protected final void m12657i() {
        this.f12707h.cancel(true);
        super.i();
    }
}
