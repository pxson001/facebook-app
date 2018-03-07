package com.facebook.prefs.counters;

import android.net.Uri;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Iterator;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_type_count_map */
public class UiCounters {
    private static volatile UiCounters f8014c;
    public final FbSharedPreferences f8015a;
    private final WeakHashMap<Object, Integer> f8016b = new WeakHashMap();

    public static com.facebook.prefs.counters.UiCounters m12583a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8014c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.counters.UiCounters.class;
        monitor-enter(r1);
        r0 = f8014c;	 Catch:{ all -> 0x003a }
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
        r0 = m12584b(r0);	 Catch:{ all -> 0x0035 }
        f8014c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8014c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.counters.UiCounters.a(com.facebook.inject.InjectorLike):com.facebook.prefs.counters.UiCounters");
    }

    private static UiCounters m12584b(InjectorLike injectorLike) {
        return new UiCounters(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public UiCounters(FbSharedPreferences fbSharedPreferences) {
        this.f8015a = fbSharedPreferences;
    }

    public final int m12589a(String str, @Nullable String str2) {
        return this.f8015a.mo276a(m12587f(str, str2), 0);
    }

    public final long m12591b(String str) {
        return m12592b(str, null);
    }

    public final long m12592b(String str, @Nullable String str2) {
        return this.f8015a.mo277a(m12588g(str, str2), 0);
    }

    public final void m12593c(String str) {
        m12594c(str, null);
    }

    public final void m12594c(String str, @Nullable String str2) {
        int a = m12589a(str, str2);
        Editor edit = this.f8015a.edit();
        edit.mo1274a(m12587f(str, str2), a + 1);
        edit.mo1275a(m12588g(str, str2), System.currentTimeMillis());
        edit.commit();
        m12586e(str, str2);
    }

    public final void m12590a(String str, @Nullable String str2, int i) {
        Editor edit = this.f8015a.edit();
        edit.mo1274a(m12587f(str, str2), i);
        edit.mo1275a(m12588g(str, str2), System.currentTimeMillis());
        edit.commit();
        m12586e(str, str2);
    }

    public final void m12595d(String str, @Nullable String str2) {
        Editor edit = this.f8015a.edit();
        edit.mo1271a(m12587f(str, str2));
        edit.mo1271a(m12588g(str, str2));
        edit.commit();
        m12586e(str, str2);
    }

    private void m12586e(String str, @Nullable String str2) {
        Iterator it = this.f8016b.keySet().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static PrefKey m12585e(String str) {
        return (PrefKey) UiCountersPrefKeys.b.m2011a(Uri.encode(str));
    }

    private static PrefKey m12587f(String str, @Nullable String str2) {
        TypedKey e = m12585e(str);
        if (str2 != null) {
            e = (PrefKey) e.m2011a("/" + Uri.encode(str2));
        }
        return (PrefKey) e.m2011a("/count");
    }

    private static PrefKey m12588g(String str, @Nullable String str2) {
        TypedKey e = m12585e(str);
        if (str2 != null) {
            e = (PrefKey) e.m2011a("/" + Uri.encode(str2));
        }
        return (PrefKey) e.m2011a("/timestamp");
    }
}
