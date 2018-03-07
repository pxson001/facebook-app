package com.facebook.notifications.util;

import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: expectedValuesPerKey */
public class NotificationsSeeMoreHelper {
    private static volatile NotificationsSeeMoreHelper f12639b;
    private final QeAccessor f12640a;

    /* compiled from: expectedValuesPerKey */
    public enum SeeMoreButtonType {
        DEFAULT("default"),
        BLUE_PILL("blue_pill"),
        BAR_VISUAL("bar_visual");
        
        public String mParamValue;

        private SeeMoreButtonType(String str) {
            this.mParamValue = str;
        }
    }

    public static com.facebook.notifications.util.NotificationsSeeMoreHelper m13450a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12639b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsSeeMoreHelper.class;
        monitor-enter(r1);
        r0 = f12639b;	 Catch:{ all -> 0x003a }
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
        r0 = m13451b(r0);	 Catch:{ all -> 0x0035 }
        f12639b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12639b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsSeeMoreHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsSeeMoreHelper");
    }

    private static NotificationsSeeMoreHelper m13451b(InjectorLike injectorLike) {
        return new NotificationsSeeMoreHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsSeeMoreHelper(QeAccessor qeAccessor) {
        this.f12640a = qeAccessor;
    }

    public final SeeMoreButtonType m13452a() {
        String a = this.f12640a.a(ExperimentsForNotificationsAbtestModule.f7755D, SeeMoreButtonType.DEFAULT.mParamValue);
        for (SeeMoreButtonType seeMoreButtonType : SeeMoreButtonType.values()) {
            if (seeMoreButtonType.mParamValue.equals(a)) {
                return seeMoreButtonType;
            }
        }
        return SeeMoreButtonType.DEFAULT;
    }
}
