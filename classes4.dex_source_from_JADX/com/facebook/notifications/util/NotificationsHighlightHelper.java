package com.facebook.notifications.util;

import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: expected_location_history_setting */
public class NotificationsHighlightHelper {
    private static volatile NotificationsHighlightHelper f12636c;
    private final QeAccessor f12637a;
    public final FbSharedPreferences f12638b;

    public static com.facebook.notifications.util.NotificationsHighlightHelper m13445a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12636c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsHighlightHelper.class;
        monitor-enter(r1);
        r0 = f12636c;	 Catch:{ all -> 0x003a }
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
        r0 = m13446b(r0);	 Catch:{ all -> 0x0035 }
        f12636c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12636c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsHighlightHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsHighlightHelper");
    }

    private static NotificationsHighlightHelper m13446b(InjectorLike injectorLike) {
        return new NotificationsHighlightHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NotificationsHighlightHelper(QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f12637a = qeAccessor;
        this.f12638b = fbSharedPreferences;
    }

    public final boolean m13447a() {
        return this.f12637a.a(ExperimentsForNotificationsAbtestModule.f7772k, false);
    }

    public final HighlightType m13448b() {
        String a = this.f12637a.a(ExperimentsForNotificationsAbtestModule.f7774m, HighlightType.DEFAULT.mParamValue);
        for (HighlightType highlightType : HighlightType.values()) {
            if (highlightType.mParamValue.equals(a)) {
                return highlightType;
            }
        }
        return HighlightType.DEFAULT;
    }

    public final boolean m13449d() {
        return m13447a() && m13448b() == HighlightType.STAR;
    }
}
