package com.facebook.composer.savedsession;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.savedsession.ComposerSavedSession.Builder;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timestamp_sent_ms */
public class ComposerSavedSessionStore implements IHaveUserData {
    public static final PrefKey f2685a = ComposerPrefKeys.f2662e;
    private static volatile ComposerSavedSessionStore f2686j;
    private final Clock f2687b;
    private final DefaultBlueServiceOperationFactory f2688c;
    private final TasksManager<String> f2689d;
    private final Lazy<ComposerSavedSessionServiceHandler> f2690e;
    private final FbSharedPreferences f2691f;
    public final AbstractFbErrorReporter f2692g;
    public boolean f2693h = false;
    private Optional<ComposerSavedSession> f2694i = Absent.INSTANCE;

    @Singleton
    /* compiled from: timestamp_sent_ms */
    public class ComposerSavedSessionStoreInitializer implements INeedInit {
        private static volatile ComposerSavedSessionStoreInitializer f2682c;
        private final Lazy<ComposerSavedSessionStore> f2683a;
        private final FbSharedPreferences f2684b;

        public static com.facebook.composer.savedsession.ComposerSavedSessionStore.ComposerSavedSessionStoreInitializer m4722a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2682c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.composer.savedsession.ComposerSavedSessionStore.ComposerSavedSessionStoreInitializer.class;
            monitor-enter(r1);
            r0 = f2682c;	 Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000b:
            if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000d:
            r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
            r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
            r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
            r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
            r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
            r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
            r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
            r0 = m4723b(r0);	 Catch:{ all -> 0x0035 }
            f2682c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2682c;
            return r0;
        L_0x0035:
            r0 = move-exception;
            com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
            throw r0;	 Catch:{ all -> 0x0035 }
        L_0x003a:
            r0 = move-exception;
            r2.m1505c(r3);	 Catch:{ all -> 0x003a }
            throw r0;	 Catch:{ all -> 0x003a }
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003a }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.savedsession.ComposerSavedSessionStore.ComposerSavedSessionStoreInitializer.a(com.facebook.inject.InjectorLike):com.facebook.composer.savedsession.ComposerSavedSessionStore$ComposerSavedSessionStoreInitializer");
        }

        private static ComposerSavedSessionStoreInitializer m4723b(InjectorLike injectorLike) {
            return new ComposerSavedSessionStoreInitializer(IdBasedSingletonScopeProvider.m1810b(injectorLike, 864), FbSharedPreferencesImpl.m1826a(injectorLike));
        }

        @Inject
        public ComposerSavedSessionStoreInitializer(Lazy<ComposerSavedSessionStore> lazy, FbSharedPreferences fbSharedPreferences) {
            this.f2683a = lazy;
            this.f2684b = fbSharedPreferences;
        }

        public void init() {
            if (this.f2684b.mo286a(ComposerSavedSessionStore.f2685a, false)) {
                ((ComposerSavedSessionStore) this.f2683a.get()).m4730c();
            }
        }
    }

    public static com.facebook.composer.savedsession.ComposerSavedSessionStore m4724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2686j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.savedsession.ComposerSavedSessionStore.class;
        monitor-enter(r1);
        r0 = f2686j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4725b(r0);	 Catch:{ all -> 0x0035 }
        f2686j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2686j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.savedsession.ComposerSavedSessionStore.a(com.facebook.inject.InjectorLike):com.facebook.composer.savedsession.ComposerSavedSessionStore");
    }

    private static ComposerSavedSessionStore m4725b(InjectorLike injectorLike) {
        return new ComposerSavedSessionStore(SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), TasksManager.m14550b(injectorLike), IdBasedLazy.m1808a(injectorLike, 5284), FbSharedPreferencesImpl.m1826a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ComposerSavedSessionStore(Clock clock, BlueServiceOperationFactory blueServiceOperationFactory, TasksManager tasksManager, Lazy<ComposerSavedSessionServiceHandler> lazy, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter) {
        this.f2687b = clock;
        this.f2688c = blueServiceOperationFactory;
        this.f2689d = tasksManager;
        this.f2690e = lazy;
        this.f2691f = fbSharedPreferences;
        this.f2692g = fbErrorReporter;
    }

    public final void m4728a(Optional<ComposerSavedSession> optional) {
        if (optional.isPresent()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("saveSession", (Parcelable) optional.get());
            this.f2689d.m14553a((Object) "save_session", BlueServiceOperationFactoryDetour.a(this.f2688c, "composer_save_session", bundle, ErrorPropagation.BY_EXCEPTION, -1480737650).mo3452a(), new 1(this, optional));
        }
    }

    public final Optional<ComposerSavedSession> m4727a() {
        Optional<ComposerSavedSession> optional = this.f2694i;
        if (!optional.isPresent()) {
            return Absent.INSTANCE;
        }
        m4729b();
        if (((ComposerSavedSession) optional.get()).version != 60) {
            this.f2692g.m2340a("composer_session_version_not_current", StringFormatUtil.formatStrLocaleSafe("currentVersion=%s, sessionVersion=%s", Integer.valueOf(60), Integer.valueOf(((ComposerSavedSession) optional.get()).version)));
            return Absent.INSTANCE;
        }
        long a = this.f2687b.mo211a();
        long j = (a - ((ComposerSavedSession) optional.get()).creationTimeMs) / 1000;
        if (j > 604800) {
            this.f2692g.m2340a("composer_session_expired", StringFormatUtil.formatStrLocaleSafe("now=%dms, sessionTime=%dms, elapsed=%ds, expiration=%ds", Long.valueOf(a), Long.valueOf(((ComposerSavedSession) optional.get()).creationTimeMs), Long.valueOf(j), Long.valueOf(604800)));
            return Absent.INSTANCE;
        } else if (((ComposerSavedSession) optional.get()).loadAttempts <= 3) {
            return optional;
        } else {
            this.f2692g.m2340a("composer_session_max_load_attempts_reached", "loaded " + ((ComposerSavedSession) optional.get()).loadAttempts + " times");
            return Absent.INSTANCE;
        }
    }

    public final void m4729b() {
        this.f2693h = true;
        m4726b(this, Absent.INSTANCE);
        this.f2689d.m14553a((Object) "delete_session", BlueServiceOperationFactoryDetour.a(this.f2688c, "composer_delete_session", new Bundle(), ErrorPropagation.BY_EXCEPTION, -1140302600).mo3452a(), new 2(this));
    }

    @VisibleForTesting
    final void m4730c() {
        if (this.f2691f.mo286a(f2685a, false)) {
            try {
                Optional of;
                Optional a = ((ComposerSavedSessionServiceHandler) this.f2690e.get()).a();
                if (a.isPresent()) {
                    of = Optional.of(new Builder((ComposerSavedSession) a.get()).a(((ComposerSavedSession) a.get()).loadAttempts + 1).a());
                } else {
                    of = a;
                }
                m4726b(this, of);
            } catch (Throwable th) {
                this.f2692g.m2346a("composer_session_load_failed", th);
                m4726b(this, Absent.withType());
            }
        }
    }

    public void clearUserData() {
        m4726b(this, Absent.withType());
        try {
            ((ComposerSavedSessionServiceHandler) this.f2690e.get()).b();
        } catch (Throwable th) {
            this.f2692g.m2346a("composer_session_clear_data_failed", th);
        }
    }

    public static void m4726b(ComposerSavedSessionStore composerSavedSessionStore, Optional optional) {
        composerSavedSessionStore.f2694i = optional;
        composerSavedSessionStore.f2691f.edit().putBoolean(f2685a, optional.isPresent()).commit();
    }
}
