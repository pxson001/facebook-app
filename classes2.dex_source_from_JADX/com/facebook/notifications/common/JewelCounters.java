package com.facebook.notifications.common;

import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: structured_survey/intern_dev_mode_enabled */
public class JewelCounters {
    private static volatile JewelCounters f3956b;
    private final FbSharedPreferences f3957a;

    /* compiled from: structured_survey/intern_dev_mode_enabled */
    public enum Jewel {
        INBOX("inbox", 0),
        FRIEND_REQUESTS("friendrequests", 1),
        NOTIFICATIONS("notifications", 2),
        FEED("feed", 4),
        REDSPACE("redspace", 6),
        BACKSTAGE("backstage", 7),
        VIDEO_HOME("videohome", 8),
        NOTIFICATIONS_FRIENDING("notifications_friending", 9),
        MARKETPLACE("marketplace", 10);
        
        private static final PrefKey PREF_PREFIX = null;
        public final String graphName;
        private final String mPrefKey;
        private final int mStyleIndex;

        static {
            PREF_PREFIX = (PrefKey) SharedPrefKeys.f987a.m2011a("jewels/");
        }

        private Jewel(String str, int i) {
            this.graphName = str;
            this.mPrefKey = str;
            this.mStyleIndex = i;
        }

        public static Jewel forIndex(int i) {
            for (Jewel jewel : values()) {
                if (jewel.mStyleIndex == i) {
                    return jewel;
                }
            }
            return null;
        }

        public static List<Jewel> forCountPrefKey(PrefKey prefKey) {
            List<Jewel> a = Lists.m1296a();
            for (Jewel jewel : values()) {
                if (getCountPrefKey(jewel).equals(prefKey)) {
                    a.add(jewel);
                }
            }
            return a;
        }

        public static PrefKey getCountPrefKey(Jewel jewel) {
            return (PrefKey) ((PrefKey) PREF_PREFIX.m2011a(Uri.encode(jewel.mPrefKey))).m2011a("/count");
        }

        public static Set<PrefKey> getCountPrefKeys() {
            Set<PrefKey> a = Sets.m1314a(values().length);
            for (Jewel countPrefKey : values()) {
                a.add(getCountPrefKey(countPrefKey));
            }
            return a;
        }
    }

    /* compiled from: structured_survey/intern_dev_mode_enabled */
    public abstract class OnJewelCountChangeListener implements OnSharedPreferenceChangeListener {
        public abstract void mo1726a(Jewel jewel, int i);

        public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            for (Jewel jewel : Jewel.forCountPrefKey(prefKey)) {
                if (jewel != null) {
                    mo1726a(jewel, fbSharedPreferences.mo276a(prefKey, 0));
                }
            }
        }
    }

    public static com.facebook.notifications.common.JewelCounters m6558a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3956b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.common.JewelCounters.class;
        monitor-enter(r1);
        r0 = f3956b;	 Catch:{ all -> 0x003a }
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
        r0 = m6559b(r0);	 Catch:{ all -> 0x0035 }
        f3956b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3956b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.common.JewelCounters.a(com.facebook.inject.InjectorLike):com.facebook.notifications.common.JewelCounters");
    }

    private static JewelCounters m6559b(InjectorLike injectorLike) {
        return new JewelCounters(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public JewelCounters(FbSharedPreferences fbSharedPreferences) {
        this.f3957a = (FbSharedPreferences) Preconditions.checkNotNull(fbSharedPreferences);
    }

    public final void m6561a(Jewel jewel, int i) {
        Editor edit = this.f3957a.edit();
        edit.mo1274a(Jewel.getCountPrefKey(jewel), i);
        edit.commit();
    }

    public final int m6560a(Jewel jewel) {
        return this.f3957a.mo276a(Jewel.getCountPrefKey(jewel), 0);
    }

    public final void m6562a(OnJewelCountChangeListener onJewelCountChangeListener) {
        this.f3957a.mo283a(Jewel.getCountPrefKeys(), (OnSharedPreferenceChangeListener) onJewelCountChangeListener);
    }

    public final void m6563b(OnJewelCountChangeListener onJewelCountChangeListener) {
        this.f3957a.mo290b(Jewel.getCountPrefKeys(), (OnSharedPreferenceChangeListener) onJewelCountChangeListener);
    }
}
