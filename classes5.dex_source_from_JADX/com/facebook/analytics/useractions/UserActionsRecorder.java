package com.facebook.analytics.useractions;

import android.app.Activity;
import com.facebook.analytics.useractions.filters.OnClickProxyEventListener;
import com.facebook.analytics.useractions.utils.UserActionEventLog;
import com.facebook.analytics.useractions.utils.UserActionType;
import com.facebook.analytics.useractions.utils.ViewHierarchyMap;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: tickets_count */
public class UserActionsRecorder {
    public static boolean f1915f = true;
    private static volatile UserActionsRecorder f1916g;
    @Nullable
    private Activity f1917a = null;
    private final List<ProxyEventListener> f1918b;
    private Provider<TriState> f1919c;
    private final UserActionEventLog f1920d;
    private final ViewHierarchyMap f1921e;

    public static com.facebook.analytics.useractions.UserActionsRecorder m2600a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1916g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.useractions.UserActionsRecorder.class;
        monitor-enter(r1);
        r0 = f1916g;	 Catch:{ all -> 0x003a }
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
        r0 = m2601b(r0);	 Catch:{ all -> 0x0035 }
        f1916g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1916g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.useractions.UserActionsRecorder.a(com.facebook.inject.InjectorLike):com.facebook.analytics.useractions.UserActionsRecorder");
    }

    private static UserActionsRecorder m2601b(InjectorLike injectorLike) {
        return new UserActionsRecorder(IdBasedProvider.a(injectorLike, 633), UserActionEventLog.m2609a(injectorLike), OnClickProxyEventListener.m2604a(injectorLike), ViewHierarchyMap.m2616a(injectorLike));
    }

    @Inject
    public UserActionsRecorder(Provider<TriState> provider, UserActionEventLog userActionEventLog, OnClickProxyEventListener onClickProxyEventListener, ViewHierarchyMap viewHierarchyMap) {
        this.f1919c = provider;
        this.f1921e = viewHierarchyMap;
        this.f1920d = userActionEventLog;
        this.f1918b = Lists.a();
        if (m2602b()) {
            this.f1918b.add(onClickProxyEventListener);
            this.f1920d.m2612a();
        }
    }

    private boolean m2602b() {
        return f1915f && BuildConstants.i && this.f1919c != null && this.f1919c.get() == TriState.YES;
    }

    public final void m2603a() {
        if (m2602b()) {
            this.f1920d.m2613a(UserActionType.BACK_PRESSED);
        }
    }
}
