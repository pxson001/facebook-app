package com.facebook.abtest.qe.log;

import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unsupported */
public class RecentUIDsUtil {
    private static volatile RecentUIDsUtil f1855c;
    private final FbSharedPreferences f1856a;
    private final Provider<Boolean> f1857b;

    public static com.facebook.abtest.qe.log.RecentUIDsUtil m3749a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1855c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.log.RecentUIDsUtil.class;
        monitor-enter(r1);
        r0 = f1855c;	 Catch:{ all -> 0x003a }
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
        r0 = m3752b(r0);	 Catch:{ all -> 0x0035 }
        f1855c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1855c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.log.RecentUIDsUtil.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.log.RecentUIDsUtil");
    }

    private static RecentUIDsUtil m3752b(InjectorLike injectorLike) {
        return new RecentUIDsUtil(FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3871));
    }

    @Inject
    public RecentUIDsUtil(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        this.f1856a = fbSharedPreferences;
        this.f1857b = provider;
    }

    public final List<String> m3754a() {
        if (((Boolean) this.f1857b.get()).booleanValue()) {
            return m3753b(this.f1856a.mo278a(QuickExperimentConfigPrefKeys.b, ""));
        }
        return Lists.m1296a();
    }

    @VisibleForTesting
    public static List<String> m3751a(String str, List<String> list) {
        Preconditions.checkArgument(list.size() <= 5, "Too many UIDs were initially stored in the system.");
        if (list instanceof ImmutableList) {
            list = Lists.m1298a((Iterable) list);
        }
        list.remove(str);
        if (list.size() >= 5) {
            list = list.subList(0, 4);
        }
        list.add(0, str);
        return list;
    }

    @VisibleForTesting
    private static List<String> m3753b(String str) {
        if (str.equals("")) {
            return Lists.m1306b();
        }
        return Lists.m1307b(Splitter.on(",").split(str));
    }

    @VisibleForTesting
    public static String m3750a(List<String> list) {
        return Joiner.on(",").join((Iterable) list);
    }
}
