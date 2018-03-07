package com.facebook.logcontroller;

import com.facebook.common.build.BuildConstants;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.debug.log.BLog;
import com.facebook.debug.mainlooper.MainLooperLogMessageListener;
import com.facebook.debug.mainlooper.MainLooperLogMessagesDispatcher;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.debug.tracer.Tracer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_taken_ms */
public class LogController implements INeedInit {
    private static final Set<PrefKey> f2794a = ImmutableSet.of(DebugLoggingPrefKeys.f2805c, DebugLoggingPrefKeys.f2804b);
    private static final MainLooperLogMessageListener f2795h = new C01761();
    private static volatile LogController f2796i;
    private final FbSharedPreferences f2797b;
    private final OnSharedPreferenceChangeListener f2798c = new C01792(this);
    private final FbAppType f2799d;
    private final Provider<Boolean> f2800e;
    private final MainLooperLogMessagesDispatcher f2801f;
    private boolean f2802g;

    /* compiled from: time_taken_ms */
    final class C01761 implements MainLooperLogMessageListener {
        C01761() {
        }

        public final void mo676a(String str) {
            Tracer.m885b(str);
        }
    }

    /* compiled from: time_taken_ms */
    class C01792 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ LogController f2820a;

        C01792(LogController logController) {
            this.f2820a = logController;
        }

        public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f2820a.m4816a();
        }
    }

    /* compiled from: time_taken_ms */
    /* synthetic */ class C01803 {
        static final /* synthetic */ int[] f2821a = new int[IntendedAudience.values().length];

        static {
            try {
                f2821a[IntendedAudience.DEVELOPMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2821a[IntendedAudience.PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2821a[IntendedAudience.FACEBOOK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.logcontroller.LogController m4814a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2796i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.logcontroller.LogController.class;
        monitor-enter(r1);
        r0 = f2796i;	 Catch:{ all -> 0x003a }
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
        r0 = m4815b(r0);	 Catch:{ all -> 0x0035 }
        f2796i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2796i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.logcontroller.LogController.a(com.facebook.inject.InjectorLike):com.facebook.logcontroller.LogController");
    }

    private static LogController m4815b(InjectorLike injectorLike) {
        return new LogController(FbSharedPreferencesImpl.m1826a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedProvider.m1811a(injectorLike, 3925), MainLooperLogMessagesDispatcher.m4820a(injectorLike));
    }

    @Inject
    LogController(FbSharedPreferences fbSharedPreferences, FbAppType fbAppType, Provider<Boolean> provider, MainLooperLogMessagesDispatcher mainLooperLogMessagesDispatcher) {
        this.f2797b = fbSharedPreferences;
        this.f2799d = fbAppType;
        this.f2800e = provider;
        this.f2801f = mainLooperLogMessagesDispatcher;
        this.f2797b.mo283a(f2794a, this.f2798c);
    }

    public void init() {
        m4816a();
    }

    public final void m4816a() {
        int parseInt;
        try {
            parseInt = Integer.parseInt(this.f2797b.mo278a(DebugLoggingPrefKeys.f2805c, "-1"));
        } catch (NumberFormatException e) {
            parseInt = -1;
        }
        if (parseInt == -1) {
            switch (C01803.f2821a[this.f2799d.g().ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    parseInt = 3;
                    break;
                default:
                    if (!BuildConstants.d() && ((Boolean) this.f2800e.get()).booleanValue()) {
                        parseInt = 4;
                        break;
                    } else {
                        parseInt = 5;
                        break;
                    }
                    break;
            }
        }
        BLog.a(parseInt);
        BLog.a(parseInt);
        if (BLog.b(2) && !this.f2802g) {
            this.f2801f.m4821a(f2795h);
            this.f2802g = true;
        } else if (!BLog.b(2) && this.f2802g) {
            this.f2801f.m4822b(f2795h);
            this.f2802g = false;
        }
    }
}
