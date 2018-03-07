package com.facebook.selfupdate;

import com.facebook.appupdate.ReleaseInfo;
import com.facebook.appupdate.SelfUpdateLauncher;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_info_map */
public class SelfUpdateStartOperationTask extends AbstractBackgroundTask {
    private static final Class<?> f12496a = SelfUpdateStartOperationTask.class;
    private final Clock f12497b;
    private final FbSharedPreferences f12498c;
    private final GatekeeperStoreImpl f12499d;
    private final SelfUpdateDataFetcher f12500e;
    private final SelfUpdateLauncher f12501f;

    public static SelfUpdateStartOperationTask m13247b(InjectorLike injectorLike) {
        return new SelfUpdateStartOperationTask((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SelfUpdateDataFetcher.m13254b(injectorLike), SelfUpdateLauncherMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public SelfUpdateStartOperationTask(Clock clock, FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl, SelfUpdateDataFetcher selfUpdateDataFetcher, SelfUpdateLauncher selfUpdateLauncher) {
        super("selfupdate_start_operation_task");
        this.f12498c = fbSharedPreferences;
        this.f12497b = clock;
        this.f12499d = gatekeeperStoreImpl;
        this.f12500e = selfUpdateDataFetcher;
        this.f12501f = selfUpdateLauncher;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        return mo593f() < this.f12497b.a();
    }

    public final long mo593f() {
        return this.f12498c.a(SelfUpdateConstants.u, 0) + this.f12498c.a(SelfUpdateConstants.v, 43200000);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        if (this.f12499d.a(805, false)) {
            ReleaseInfo k = m13248k();
            if (k != null) {
                boolean a = this.f12499d.a(806, false);
                this.f12501f.a(k, a, a);
            }
        }
        this.f12498c.edit().a(SelfUpdateConstants.u, this.f12497b.a()).commit();
        return Futures.a(new BackgroundResult(true));
    }

    @Nullable
    private ReleaseInfo m13248k() {
        if (this.f12499d.a(807, false)) {
            OxygenQueryResponse b = this.f12500e.m13256b(false);
            if (b != null) {
                return new ReleaseInfo(b.e, b.f, b.c, false, b.h, null, b.i, b.g, b.d, "oxygen");
            }
        }
        AppServerResponse a = this.f12500e.m13255a(false);
        if (!(a == null || a.f == null)) {
            return new ReleaseInfo(a.c, a.d, a.f, a.b(), a.h, null, a.i, a.g, a.l, "fql");
        }
        return null;
    }
}
