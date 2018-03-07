package com.facebook.common.network;

import android.text.TextUtils;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unable to resolve root flattenable feed unit from flatbuffer */
public class HistoricalConnectionQuality {
    public static final PrefKey f2024a;
    private static final PrefKey f2025b;
    private static final String f2026c = HistoricalConnectionQuality.class.getSimpleName();
    private static volatile HistoricalConnectionQuality f2027f;
    public final FbSharedPreferences f2028d;
    public final Map<String, ConnectionQuality> f2029e = Maps.m843e();

    public static com.facebook.common.network.HistoricalConnectionQuality m4107a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2027f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.network.HistoricalConnectionQuality.class;
        monitor-enter(r1);
        r0 = f2027f;	 Catch:{ all -> 0x003a }
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
        r0 = m4108b(r0);	 Catch:{ all -> 0x0035 }
        f2027f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2027f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.network.HistoricalConnectionQuality.a(com.facebook.inject.InjectorLike):com.facebook.common.network.HistoricalConnectionQuality");
    }

    private static HistoricalConnectionQuality m4108b(InjectorLike injectorLike) {
        return new HistoricalConnectionQuality(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("connection_manager/");
        f2025b = prefKey;
        f2024a = (PrefKey) prefKey.m2011a("history/");
    }

    @Inject
    public HistoricalConnectionQuality(FbSharedPreferences fbSharedPreferences) {
        this.f2028d = fbSharedPreferences;
    }

    public final ConnectionQuality m4109a(String str) {
        if (!this.f2028d.mo284a()) {
            return ConnectionQuality.UNKNOWN;
        }
        if (this.f2029e.containsKey(str)) {
            return (ConnectionQuality) this.f2029e.get(str);
        }
        Object a = this.f2028d.mo278a((PrefKey) f2024a.m2011a(str), "");
        ConnectionQuality connectionQuality = ConnectionQuality.UNKNOWN;
        if (!TextUtils.isEmpty(a)) {
            try {
                connectionQuality = ConnectionQuality.valueOf(a);
            } catch (IllegalArgumentException e) {
            }
        }
        this.f2029e.put(str, connectionQuality);
        return connectionQuality;
    }
}
