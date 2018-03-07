package com.facebook.notifications.jewel;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.util.JewelCountHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.reaction.ReactionUtil;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: structured_menu/?page_id=%s */
public class JewelCountFetcher {
    public static final String f3958a = (f3959b + ".INITIATE_BACKGROUND_FETCH");
    private static final String f3959b = JewelCountFetcher.class.getSimpleName();
    private static volatile JewelCountFetcher f3960m;
    public final Context f3961c;
    private final FbAlarmManagerImpl f3962d;
    public final FbSharedPreferences f3963e;
    private final DefaultAppChoreographer f3964f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<JewelCountHelper> f3965g = UltralightRuntime.f368b;
    public final Provider<String> f3966h;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ReactionUtil> f3967i = UltralightRuntime.f368b;
    public boolean f3968j = false;
    public boolean f3969k = false;
    private final Runnable f3970l = new C02222(this);

    /* compiled from: structured_menu/?page_id=%s */
    class C02222 implements Runnable {
        final /* synthetic */ JewelCountFetcher f3979a;

        C02222(JewelCountFetcher jewelCountFetcher) {
            this.f3979a = jewelCountFetcher;
        }

        public void run() {
            if (this.f3979a.f3966h.get() != null) {
                if (this.f3979a.f3969k) {
                    JewelCountHelper jewelCountHelper = (JewelCountHelper) this.f3979a.f3965g.get();
                    jewelCountHelper.e.a(((ReactionUtil) this.f3979a.f3967i.get()).a(Surface.ANDROID_NOTIFICATIONS));
                    this.f3979a.f3969k = false;
                }
                ((JewelCountHelper) this.f3979a.f3965g.get()).a();
                this.f3979a.m6570b();
            }
        }
    }

    /* compiled from: structured_menu/?page_id=%s */
    class C03531 implements FutureCallback<Object> {
        final /* synthetic */ JewelCountFetcher f8136a;

        C03531(JewelCountFetcher jewelCountFetcher) {
            this.f8136a = jewelCountFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f8136a.f3968j = false;
        }

        public void onFailure(Throwable th) {
            this.f8136a.f3968j = false;
        }
    }

    public static com.facebook.notifications.jewel.JewelCountFetcher m6564a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3960m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.jewel.JewelCountFetcher.class;
        monitor-enter(r1);
        r0 = f3960m;	 Catch:{ all -> 0x003a }
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
        r0 = m6566b(r0);	 Catch:{ all -> 0x0035 }
        f3960m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3960m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.jewel.JewelCountFetcher.a(com.facebook.inject.InjectorLike):com.facebook.notifications.jewel.JewelCountFetcher");
    }

    private static JewelCountFetcher m6566b(InjectorLike injectorLike) {
        JewelCountFetcher jewelCountFetcher = new JewelCountFetcher((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.m6572a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), DefaultAppChoreographer.m1621a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.m1810b(injectorLike, 2825);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 9839);
        jewelCountFetcher.f3965g = b;
        jewelCountFetcher.f3967i = b2;
        return jewelCountFetcher;
    }

    @Inject
    public JewelCountFetcher(Context context, FbAlarmManager fbAlarmManager, FbSharedPreferences fbSharedPreferences, AppChoreographer appChoreographer, Provider<String> provider) {
        this.f3961c = context;
        this.f3962d = fbAlarmManager;
        this.f3963e = fbSharedPreferences;
        this.f3964f = appChoreographer;
        this.f3966h = provider;
    }

    public final void m6568a() {
        if (!this.f3968j) {
            this.f3968j = true;
            Futures.m2457a(this.f3964f.m1634a("JewelCountFetcher-schedule", this.f3970l, AppChoreographer$Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, AppChoreographer$ThreadType.BACKGROUND), new C03531(this));
        }
    }

    public final void m6569a(boolean z) {
        this.f3969k = z;
    }

    private void m6565a(long j) {
        long j2 = (j / 60) * 3600000;
        m6571c();
        m6567b(true);
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f3962d;
        long elapsedRealtime = SystemClock.elapsedRealtime() + j2;
        Intent intent = new Intent(this.f3961c, JewelCountBroadcastReceiver.class);
        intent.setAction(f3958a);
        fbAlarmManagerImpl.m6574a(3, elapsedRealtime, j2, PendingIntent.getBroadcast(this.f3961c, 0, intent, 0));
    }

    private void m6567b(boolean z) {
        this.f3963e.edit().putBoolean(NotificationsPreferenceConstants.x, z).commit();
    }

    @SuppressLint({"SetInexactRepeatingArgs"})
    public final void m6570b() {
        if (!this.f3963e.mo286a(NotificationsPreferenceConstants.x, false)) {
            m6565a(480);
        }
    }

    public final void m6571c() {
        m6567b(false);
        Intent intent = new Intent(this.f3961c, JewelCountBroadcastReceiver.class);
        intent.setAction(f3958a);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3961c, 0, intent, 0);
        this.f3962d.m6576a(broadcast);
        broadcast.cancel();
    }
}
