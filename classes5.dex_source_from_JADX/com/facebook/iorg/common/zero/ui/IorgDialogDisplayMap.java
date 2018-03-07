package com.facebook.iorg.common.zero.ui;

import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.zero.IorgDialogDisplayContext;
import com.facebook.zero.upsell.IorgFbErrorReporter;
import java.util.EnumMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOPICAL_LIVE_VIDEOS */
public class IorgDialogDisplayMap {
    private static volatile IorgDialogDisplayMap f13908c;
    @GuardedBy("this")
    private EnumMap<IorgDialogDisplayContext, Integer> f13909a = new EnumMap(IorgDialogDisplayContext.class);
    private final IorgFbErrorReporter f13910b;

    public static com.facebook.iorg.common.zero.ui.IorgDialogDisplayMap m23267a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13908c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.iorg.common.zero.ui.IorgDialogDisplayMap.class;
        monitor-enter(r1);
        r0 = f13908c;	 Catch:{ all -> 0x003a }
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
        r0 = m23268b(r0);	 Catch:{ all -> 0x0035 }
        f13908c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13908c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.iorg.common.zero.ui.IorgDialogDisplayMap.a(com.facebook.inject.InjectorLike):com.facebook.iorg.common.zero.ui.IorgDialogDisplayMap");
    }

    private static IorgDialogDisplayMap m23268b(InjectorLike injectorLike) {
        return new IorgDialogDisplayMap(IorgFbErrorReporter.b(injectorLike));
    }

    @Inject
    public IorgDialogDisplayMap(IorgFbErrorReporter iorgFbErrorReporter) {
        this.f13910b = iorgFbErrorReporter;
        for (Enum put : IorgDialogDisplayContext.values()) {
            this.f13909a.put(put, Integer.valueOf(0));
        }
    }

    public final synchronized void m23269a(@Nullable IorgDialogDisplayContext iorgDialogDisplayContext) {
        if (iorgDialogDisplayContext != null) {
            this.f13909a.put(iorgDialogDisplayContext, Integer.valueOf(((Integer) this.f13909a.get(iorgDialogDisplayContext)).intValue() + 1));
        }
    }

    public final synchronized void m23270b(@Nullable IorgDialogDisplayContext iorgDialogDisplayContext) {
        if (iorgDialogDisplayContext != null) {
            int intValue = ((Integer) this.f13909a.get(iorgDialogDisplayContext)).intValue() - 1;
            if (intValue < 0) {
                iorgDialogDisplayContext.name();
                this.f13910b.a(IorgDialogDisplayMap.class.getSimpleName(), "mDialogDisplayMap contained negative value for context");
                intValue = 0;
            }
            this.f13909a.put(iorgDialogDisplayContext, Integer.valueOf(intValue));
        }
    }
}
