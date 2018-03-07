package com.facebook.orca.threadview.seenheads;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.orca.threadview.seenheads.configs.SeenHeadsMaxGroupSizeXConfig;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: machineID */
public class SeenHeadsEligibilityChecker {
    private static volatile SeenHeadsEligibilityChecker f8334c;
    public final int f8335a;
    private final Provider<Boolean> f8336b;

    public static com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker m8295a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8334c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker.class;
        monitor-enter(r1);
        r0 = f8334c;	 Catch:{ all -> 0x003a }
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
        r0 = m8296b(r0);	 Catch:{ all -> 0x0035 }
        f8334c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8334c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker");
    }

    private static SeenHeadsEligibilityChecker m8296b(InjectorLike injectorLike) {
        return new SeenHeadsEligibilityChecker(IdBasedProvider.a(injectorLike, 4156), IdBasedSingletonScopeProvider.a(injectorLike, 3749));
    }

    @Inject
    public SeenHeadsEligibilityChecker(Provider<Boolean> provider, Provider<XConfigReader> provider2) {
        this.f8336b = provider;
        this.f8335a = ((XConfigReader) provider2.get()).a(SeenHeadsMaxGroupSizeXConfig.d, 75);
    }

    public final boolean m8297a(int i, FolderName folderName) {
        return i <= this.f8335a && ((Boolean) this.f8336b.get()).booleanValue() && !folderName.isMessageRequestFolders();
    }
}
