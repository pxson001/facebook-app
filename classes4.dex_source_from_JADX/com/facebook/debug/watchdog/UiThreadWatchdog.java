package com.facebook.debug.watchdog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: music_preview */
public class UiThreadWatchdog implements INeedInit {
    private static final Class<?> f7337a = UiThreadWatchdog.class;
    private static volatile UiThreadWatchdog f7338o;
    private final Clock f7339b;
    private final AppStateManager f7340c;
    private final LocalBroadcastManager f7341d;
    private final FbHandlerThreadFactory f7342e;
    public final FbSharedPreferences f7343f;
    private final OnSharedPreferenceChangeListener f7344g;
    private final Handler f7345h = new Handler(Looper.getMainLooper());
    private HandlerThread f7346i;
    private Handler f7347j;
    @GuardedBy("this")
    private long f7348k;
    @GuardedBy("this")
    private boolean f7349l;
    @GuardedBy("this")
    public boolean f7350m;
    @GuardedBy("this")
    private boolean f7351n;

    /* compiled from: music_preview */
    class C03521 extends BroadcastReceiver {
        final /* synthetic */ UiThreadWatchdog f7353a;

        C03521(UiThreadWatchdog uiThreadWatchdog) {
            this.f7353a = uiThreadWatchdog;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2011637981);
            UiThreadWatchdog.m7666a(this.f7353a);
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 404922722, a);
        }
    }

    /* compiled from: music_preview */
    class C03532 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ UiThreadWatchdog f7354a;

        C03532(UiThreadWatchdog uiThreadWatchdog) {
            this.f7354a = uiThreadWatchdog;
        }

        public final void m7678a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            UiThreadWatchdog.m7667a(this.f7354a, this.f7354a.f7343f.a(UiThreadWatchdogPrefKeys.f7355a, false));
        }
    }

    /* compiled from: music_preview */
    class C03543 implements Runnable {
        final /* synthetic */ UiThreadWatchdog f7356a;

        C03543(UiThreadWatchdog uiThreadWatchdog) {
            this.f7356a = uiThreadWatchdog;
        }

        public void run() {
            UiThreadWatchdog.m7670b(this.f7356a);
        }
    }

    public static com.facebook.debug.watchdog.UiThreadWatchdog m7665a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7338o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.watchdog.UiThreadWatchdog.class;
        monitor-enter(r1);
        r0 = f7338o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m7669b(r0);	 Catch:{ all -> 0x0035 }
        f7338o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7338o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.watchdog.UiThreadWatchdog.a(com.facebook.inject.InjectorLike):com.facebook.debug.watchdog.UiThreadWatchdog");
    }

    private static UiThreadWatchdog m7669b(InjectorLike injectorLike) {
        return new UiThreadWatchdog(AppStateManager.a(injectorLike), LocalBroadcastManagerMethodAutoProvider.m7676a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbHandlerThreadFactory.a(injectorLike));
    }

    @Inject
    public UiThreadWatchdog(AppStateManager appStateManager, LocalBroadcastManager localBroadcastManager, FbSharedPreferences fbSharedPreferences, Clock clock, FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f7340c = appStateManager;
        this.f7341d = localBroadcastManager;
        this.f7343f = fbSharedPreferences;
        this.f7339b = clock;
        this.f7342e = fbHandlerThreadFactory;
        this.f7341d.a(new C03521(this), new IntentFilter(AppStateManager.a));
        this.f7349l = this.f7340c.j();
        this.f7344g = new C03532(this);
        this.f7343f.a(UiThreadWatchdogPrefKeys.f7355a, this.f7344g);
    }

    public void init() {
        m7667a(this, this.f7343f.a(UiThreadWatchdogPrefKeys.f7355a, false));
    }

    public static synchronized void m7666a(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            uiThreadWatchdog.f7349l = uiThreadWatchdog.f7340c.j();
            m7670b(uiThreadWatchdog);
        }
    }

    public static synchronized void m7667a(UiThreadWatchdog uiThreadWatchdog, boolean z) {
        synchronized (uiThreadWatchdog) {
            uiThreadWatchdog.f7351n = z;
            HandlerDetour.a(uiThreadWatchdog.f7345h, new C03543(uiThreadWatchdog), 601208989);
        }
    }

    public static synchronized void m7670b(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            boolean h = uiThreadWatchdog.m7675h();
            if (h != uiThreadWatchdog.f7350m) {
                if (h) {
                    uiThreadWatchdog.f7346i = uiThreadWatchdog.f7342e.a("UiThreadWatchdog");
                    uiThreadWatchdog.f7346i.start();
                    uiThreadWatchdog.f7347j = new Handler(uiThreadWatchdog.f7346i.getLooper());
                    uiThreadWatchdog.f7350m = true;
                    m7672d(uiThreadWatchdog);
                    m7671c(uiThreadWatchdog);
                    Looper.myQueue().addIdleHandler(new 4(uiThreadWatchdog));
                } else {
                    uiThreadWatchdog.f7346i.quit();
                    uiThreadWatchdog.f7346i = null;
                    uiThreadWatchdog.f7347j = null;
                    uiThreadWatchdog.f7350m = false;
                }
            }
        }
    }

    public static synchronized void m7671c(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            if (uiThreadWatchdog.f7350m) {
                HandlerDetour.b(uiThreadWatchdog.f7347j, new 5(uiThreadWatchdog), 200, 1501235880);
            }
        }
    }

    public static synchronized void m7672d(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            if (uiThreadWatchdog.f7350m) {
                HandlerDetour.b(uiThreadWatchdog.f7345h, new 6(uiThreadWatchdog), 200, 969957469);
            }
        }
    }

    public static synchronized void m7673f(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            if (uiThreadWatchdog.f7350m) {
                uiThreadWatchdog.f7349l = uiThreadWatchdog.f7340c.j();
                if (uiThreadWatchdog.f7349l) {
                    m7670b(uiThreadWatchdog);
                } else {
                    uiThreadWatchdog.f7348k = uiThreadWatchdog.f7339b.a();
                }
            }
        }
    }

    public static synchronized void m7674g(UiThreadWatchdog uiThreadWatchdog) {
        synchronized (uiThreadWatchdog) {
            if (uiThreadWatchdog.f7350m) {
                uiThreadWatchdog.f7349l = uiThreadWatchdog.f7340c.j();
                if (uiThreadWatchdog.f7349l) {
                    m7670b(uiThreadWatchdog);
                } else {
                    long a = uiThreadWatchdog.f7339b.a() - uiThreadWatchdog.f7348k;
                    if (a >= 600) {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("UI Thread has been stuck for more than ").append(a).append(" ms.");
                        stringBuilder.append("Current UI thread stack\n");
                        m7668a(stringBuilder, "  ", stackTrace);
                        BLog.a(f7337a, stringBuilder.toString());
                    }
                }
            }
        }
    }

    private synchronized boolean m7675h() {
        boolean z;
        z = this.f7351n && !this.f7349l;
        return z;
    }

    private static void m7668a(StringBuilder stringBuilder, String str, StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            stringBuilder.append(str);
            stringBuilder.append("\tat ");
            stringBuilder.append(stackTraceElement.toString());
            stringBuilder.append("\n");
        }
    }
}
