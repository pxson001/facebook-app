package com.facebook.stickers.data;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: rating5 */
public class StickersAssetTablePopulator {
    private static volatile StickersAssetTablePopulator f3829c;
    private final StickersFileUtil f3830a;
    private final Provider<StickersAssetsFileVisitor> f3831b;

    public static com.facebook.stickers.data.StickersAssetTablePopulator m4277a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3829c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickersAssetTablePopulator.class;
        monitor-enter(r1);
        r0 = f3829c;	 Catch:{ all -> 0x003a }
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
        r0 = m4278b(r0);	 Catch:{ all -> 0x0035 }
        f3829c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3829c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickersAssetTablePopulator.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickersAssetTablePopulator");
    }

    private static StickersAssetTablePopulator m4278b(InjectorLike injectorLike) {
        return new StickersAssetTablePopulator(StickersFileUtil.m13050a(injectorLike), IdBasedProvider.a(injectorLike, 3451));
    }

    @Inject
    public StickersAssetTablePopulator(StickersFileUtil stickersFileUtil, Provider<StickersAssetsFileVisitor> provider) {
        this.f3830a = stickersFileUtil;
        this.f3831b = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4279a(android.database.sqlite.SQLiteDatabase r4) {
        /*
        r3 = this;
        r0 = "StickersAssetTablePopulator.populate";
        r1 = 1364263312; // 0x51510190 float:5.6104649E10 double:6.740356343E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r3.f3831b;	 Catch:{ all -> 0x0044 }
        r0 = r0.get();	 Catch:{ all -> 0x0044 }
        r0 = (com.facebook.stickers.data.StickersAssetsFileVisitor) r0;	 Catch:{ all -> 0x0044 }
        r0.m4392a(r4);	 Catch:{ all -> 0x0044 }
        r1 = 1751358332; // 0x68639b7c float:4.2993815E24 double:8.652859854E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r4, r1);	 Catch:{ all -> 0x003f }
        r1 = r3.f3830a;	 Catch:{ all -> 0x0037 }
        r1 = r1.m13054a();	 Catch:{ all -> 0x0037 }
        if (r1 == 0) goto L_0x0024;
    L_0x0021:
        com.facebook.common.file.FileTree.m3116a(r1, r0);	 Catch:{ all -> 0x0037 }
    L_0x0024:
        r4.setTransactionSuccessful();	 Catch:{ all -> 0x0037 }
        r1 = 249346965; // 0xedcbb95 float:5.4414822E-30 double:1.231937693E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r1);	 Catch:{  }
        r0.m4391a();	 Catch:{  }
        r0 = 478752130; // 0x1c892d82 float:9.077663E-22 double:2.365349803E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return;
    L_0x0037:
        r1 = move-exception;
        r2 = 1113706199; // 0x4261ced7 float:56.451992 double:5.502439725E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r2);	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x003f:
        r1 = move-exception;
        r0.m4391a();	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x0044:
        r0 = move-exception;
        r1 = -35558444; // 0xfffffffffde16bd4 float:-3.7454522E37 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickersAssetTablePopulator.a(android.database.sqlite.SQLiteDatabase):void");
    }
}
