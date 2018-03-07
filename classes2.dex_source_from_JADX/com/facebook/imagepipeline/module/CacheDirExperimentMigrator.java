package com.facebook.imagepipeline.module;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: other  */
public class CacheDirExperimentMigrator {
    protected static final PrefKey f10675a;
    protected static final PrefKey f10676b;
    private static final CacheLocation f10677c = CacheLocation.CACHE;
    private static volatile CacheDirExperimentMigrator f10678f;
    private final FbSharedPreferences f10679d;
    public final CacheLocationDetails f10680e;

    public static com.facebook.imagepipeline.module.CacheDirExperimentMigrator m15957a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10678f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.module.CacheDirExperimentMigrator.class;
        monitor-enter(r1);
        r0 = f10678f;	 Catch:{ all -> 0x003a }
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
        r0 = m15959b(r0);	 Catch:{ all -> 0x0035 }
        f10678f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10678f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.module.CacheDirExperimentMigrator.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.module.CacheDirExperimentMigrator");
    }

    private static CacheDirExperimentMigrator m15959b(InjectorLike injectorLike) {
        return new CacheDirExperimentMigrator(CacheLocationDetails.m15961a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("cache_dir_expriment_migrator");
        f10675a = prefKey;
        f10676b = (PrefKey) prefKey.m2011a("last_known_loc");
    }

    @Inject
    public CacheDirExperimentMigrator(CacheLocationDetails cacheLocationDetails, FbSharedPreferences fbSharedPreferences) {
        this.f10680e = cacheLocationDetails;
        this.f10679d = fbSharedPreferences;
    }

    public final CacheLocation m15960a(CacheLocation cacheLocation) {
        CacheLocation a = m15958a();
        if (a == cacheLocation) {
            return cacheLocation;
        }
        boolean renameTo;
        File file = new File((File) this.f10680e.m15963a(a).mo2058a(), this.f10680e.m15964b(a));
        if (file.exists()) {
            renameTo = file.renameTo(new File((File) this.f10680e.m15963a(cacheLocation).mo2058a(), this.f10680e.m15964b(cacheLocation)));
        } else {
            renameTo = true;
        }
        boolean z = renameTo;
        if (z) {
            this.f10679d.edit().mo1276a(f10676b, cacheLocation.name()).commit();
        }
        if (z) {
            return cacheLocation;
        }
        return a;
    }

    private CacheLocation m15958a() {
        try {
            return CacheLocation.valueOf(this.f10679d.mo278a(f10676b, f10677c.name()));
        } catch (IllegalArgumentException e) {
            this.f10679d.edit().mo1271a(f10676b).commit();
            return f10677c;
        }
    }
}
