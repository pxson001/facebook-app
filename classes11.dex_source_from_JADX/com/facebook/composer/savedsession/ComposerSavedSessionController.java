package com.facebook.composer.savedsession;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.composer.activity.ComposerFragment.C07669;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetch_upnp_device_data */
public class ComposerSavedSessionController {
    public final ScheduledExecutorService f6928a;
    public final ComposerSavedSessionStore f6929b;
    public final ComposerAnalyticsLogger f6930c;
    private final AbstractFbErrorReporter f6931d;
    public final ComposerInstanceTracker f6932e;
    public WeakReference<SessionProvider> f6933f = null;
    public String f6934g = null;
    public ScheduledFuture<?> f6935h = null;

    /* compiled from: fetch_upnp_device_data */
    class C08731 implements Runnable {
        final /* synthetic */ ComposerSavedSessionController f6927a;

        C08731(ComposerSavedSessionController composerSavedSessionController) {
            this.f6927a = composerSavedSessionController;
        }

        public void run() {
            C07669 i = ComposerSavedSessionController.m8248i(this.f6927a);
            if (i != null) {
                Optional a = i.f6141a.an.m7612a(i.f6141a.aU.f6187f, i.f6141a.aL);
                if (a.isPresent()) {
                    this.f6927a.f6932e.m8228a((ComposerSavedSession) a.get());
                }
                this.f6927a.f6929b.a(a);
                this.f6927a.f6930c.a(Events.SAVE_SESSION, this.f6927a.f6934g);
                this.f6927a.f6935h = this.f6927a.f6928a.schedule(this, 5, TimeUnit.SECONDS);
            }
        }
    }

    public static ComposerSavedSessionController m8243b(InjectorLike injectorLike) {
        return new ComposerSavedSessionController((ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ComposerSavedSessionStore.a(injectorLike), ComposerAnalyticsLogger.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ComposerInstanceTracker.m8225a(injectorLike));
    }

    @Inject
    public ComposerSavedSessionController(ScheduledExecutorService scheduledExecutorService, ComposerSavedSessionStore composerSavedSessionStore, ComposerAnalyticsLogger composerAnalyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, ComposerInstanceTracker composerInstanceTracker) {
        this.f6928a = scheduledExecutorService;
        this.f6929b = composerSavedSessionStore;
        this.f6930c = composerAnalyticsLogger;
        this.f6931d = abstractFbErrorReporter;
        this.f6932e = composerInstanceTracker;
    }

    public final void m8249a() {
        m8246g();
    }

    public final void m8250b() {
        m8247h();
    }

    public final void m8251c() {
        m8245f();
    }

    public final void m8252d() {
        m8245f();
    }

    private boolean m8244e() {
        return this.f6935h != null;
    }

    private void m8245f() {
        m8247h();
        this.f6929b.b();
        this.f6930c.a(Events.DISCARD_SESSION, this.f6934g);
    }

    private void m8246g() {
        if (!m8244e()) {
            C07669 i = m8248i(this);
            if (i != null) {
                boolean z = false;
                if (i.f6141a.y) {
                    if (i.f6141a.aL.w != null) {
                        z = i.f6141a.aL.w.a();
                    } else if (!i.f6141a.aS.m7439o().isEdit()) {
                        z = true;
                    }
                }
                if (z) {
                    this.f6935h = this.f6928a.schedule(new C08731(this), 5, TimeUnit.SECONDS);
                }
            }
        }
    }

    private void m8247h() {
        if (m8244e()) {
            this.f6935h.cancel(false);
            this.f6935h = null;
        }
    }

    @Nullable
    public static C07669 m8248i(ComposerSavedSessionController composerSavedSessionController) {
        Preconditions.checkState(composerSavedSessionController.f6933f != null);
        C07669 c07669 = (C07669) composerSavedSessionController.f6933f.get();
        if (c07669 != null) {
            return c07669;
        }
        composerSavedSessionController.f6931d.a("composer_session_provider_collected", "");
        return null;
    }
}
