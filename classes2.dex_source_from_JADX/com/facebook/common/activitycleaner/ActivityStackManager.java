package com.facebook.common.activitycleaner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.activitycleaner.ActivityCleaner.C03621;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Longs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: type must not be null */
public class ActivityStackManager implements FbCustomReportDataSupplier {
    public static final PrefKey f2112a = ((PrefKey) SharedPrefKeys.f994h.m2011a("user_left_app_at"));
    private static volatile ActivityStackManager f2113n;
    public final List<Entry> f2114b = Lists.m1296a();
    public int f2115c = 0;
    public final Map<Activity, Entry> f2116d = new MapMaker().m1485e().m1489l();
    private final AbstractFbErrorReporter f2117e;
    private final BaseFbBroadcastManager f2118f;
    public final FbSharedPreferences f2119g;
    private SelfRegistrableReceiverImpl f2120h;
    public final MonotonicClock f2121i;
    public long f2122j;
    public OnApplicationEnteredListener f2123k;
    public C03621 f2124l;
    public String f2125m;

    /* compiled from: type must not be null */
    class C03502 implements ActionReceiver {
        final /* synthetic */ ActivityStackManager f8074a;

        C03502(ActivityStackManager activityStackManager) {
            this.f8074a = activityStackManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1485970893);
            this.f8074a.f2119g.edit().mo1275a(ActivityStackManager.f2112a, this.f8074a.f2121i.now()).commit();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1418521660, a);
        }
    }

    /* compiled from: type must not be null */
    class C03511 implements ActionReceiver {
        final /* synthetic */ ActivityStackManager f8075a;

        C03511(ActivityStackManager activityStackManager) {
            this.f8075a = activityStackManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -511227739);
            this.f8075a.f2122j = this.f8075a.f2119g.mo277a(ActivityStackManager.f2112a, 0);
            this.f8075a.f2119g.edit().mo1275a(ActivityStackManager.f2112a, 0).commit();
            if (this.f8075a.f2123k != null) {
                this.f8075a.f2123k.mo1729a();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1833498452, a);
        }
    }

    /* compiled from: type must not be null */
    public interface OnApplicationEnteredListener {
        void mo1729a();
    }

    /* compiled from: type must not be null */
    public class Entry {
        public static final Comparator<Entry> f8346a = new C03641();
        private final WeakReference<Activity> f8347b;
        public long f8348c = Long.MIN_VALUE;

        /* compiled from: type must not be null */
        final class C03641 implements Comparator<Entry> {
            C03641() {
            }

            public final int compare(Object obj, Object obj2) {
                return Longs.a(((Entry) obj).f8348c, ((Entry) obj2).f8348c);
            }
        }

        public Entry(Activity activity) {
            this.f8347b = new WeakReference(activity);
        }

        public final Activity m12860b() {
            return (Activity) this.f8347b.get();
        }
    }

    public static com.facebook.common.activitycleaner.ActivityStackManager m4298a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2113n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.activitycleaner.ActivityStackManager.class;
        monitor-enter(r1);
        r0 = f2113n;	 Catch:{ all -> 0x003a }
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
        r0 = m4299b(r0);	 Catch:{ all -> 0x0035 }
        f2113n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2113n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.activitycleaner.ActivityStackManager.a(com.facebook.inject.InjectorLike):com.facebook.common.activitycleaner.ActivityStackManager");
    }

    private static ActivityStackManager m4299b(InjectorLike injectorLike) {
        return new ActivityStackManager(FbErrorReporterImpl.m2317a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public ActivityStackManager(AbstractFbErrorReporter abstractFbErrorReporter, BaseFbBroadcastManager baseFbBroadcastManager, FbSharedPreferences fbSharedPreferences, MonotonicClock monotonicClock) {
        this.f2117e = abstractFbErrorReporter;
        this.f2118f = baseFbBroadcastManager;
        this.f2119g = fbSharedPreferences;
        this.f2121i = monotonicClock;
        this.f2125m = FBLinks.bT;
        this.f2122j = 0;
    }

    public final void m4303b() {
        if (this.f2120h == null || !this.f2120h.m3295a()) {
            this.f2120h = this.f2118f.m2951a().mo506a(AppStateManager.f1111c, new C03502(this)).mo506a(AppStateManager.f1110b, new C03511(this)).mo503a();
            this.f2120h.m3296b();
        }
    }

    public final void m4305c() {
        if (this.f2120h != null && this.f2114b.size() <= 1) {
            this.f2120h.m3297c();
        }
        this.f2123k = null;
    }

    public final long m4307d() {
        long j = this.f2122j;
        this.f2122j = 0;
        return j;
    }

    public final void m4304b(Activity activity) {
        Entry entry = (Entry) this.f2116d.get(activity);
        if (entry != null) {
            this.f2114b.remove(entry);
            this.f2116d.remove(activity);
        }
    }

    public final void m4302a(OnApplicationEnteredListener onApplicationEnteredListener) {
        this.f2123k = onApplicationEnteredListener;
    }

    public final void m4306c(Activity activity) {
        if (this.f2124l != null) {
            this.f2124l.f8344a.m12855e(activity);
        }
    }

    public final void m4308f() {
        Collections.sort(this.f2114b, Entry.f8346a);
        Iterator it = this.f2114b.iterator();
        while (it.hasNext()) {
            if (((Entry) it.next()).m12860b() == null) {
                it.remove();
            }
        }
        this.f2117e.mo345c("activity_stack_size", Integer.toString(m4310h()));
        this.f2117e.mo345c("activity_creation_count", Integer.toString(this.f2115c));
    }

    public final List<Entry> m4309g() {
        return new ArrayList(this.f2114b);
    }

    public final int m4310h() {
        return this.f2114b.size();
    }

    public final String mo633a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry b : this.f2114b) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s%n", b.m12860b().toString()));
        }
        return stringBuilder.toString();
    }

    public final String mo632a() {
        return "activity_stack";
    }
}
