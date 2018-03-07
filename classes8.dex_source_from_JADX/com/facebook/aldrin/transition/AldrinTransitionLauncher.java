package com.facebook.aldrin.transition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.aldrin.transition.activity.AldrinTransitionActivity;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_state */
public class AldrinTransitionLauncher {
    private static volatile AldrinTransitionLauncher f10388f;
    private final Provider<Boolean> f10389a;
    private final SecureContextHelper f10390b;
    private final AppStateManager f10391c;
    private final AldrinUserStatusManager f10392d;
    public boolean f10393e = false;

    /* compiled from: last_state */
    /* synthetic */ class C11061 {
        static final /* synthetic */ int[] f10387a = new int[GraphQLTosTransitionTypeEnum.values().length];

        static {
            try {
                f10387a[GraphQLTosTransitionTypeEnum.EXPLICIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10387a[GraphQLTosTransitionTypeEnum.EXPLICIT_FROM_BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.aldrin.transition.AldrinTransitionLauncher m12188a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10388f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.aldrin.transition.AldrinTransitionLauncher.class;
        monitor-enter(r1);
        r0 = f10388f;	 Catch:{ all -> 0x003a }
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
        r0 = m12189b(r0);	 Catch:{ all -> 0x0035 }
        f10388f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10388f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.aldrin.transition.AldrinTransitionLauncher.a(com.facebook.inject.InjectorLike):com.facebook.aldrin.transition.AldrinTransitionLauncher");
    }

    private static AldrinTransitionLauncher m12189b(InjectorLike injectorLike) {
        return new AldrinTransitionLauncher(IdBasedProvider.a(injectorLike, 3873), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AppStateManager.a(injectorLike), AldrinUserStatusManager.a(injectorLike));
    }

    @Inject
    public AldrinTransitionLauncher(Provider<Boolean> provider, SecureContextHelper secureContextHelper, AppStateManager appStateManager, AldrinUserStatusManager aldrinUserStatusManager) {
        this.f10389a = provider;
        this.f10390b = secureContextHelper;
        this.f10391c = appStateManager;
        this.f10392d = aldrinUserStatusManager;
    }

    public final boolean m12191a() {
        if (!((Boolean) this.f10389a.get()).booleanValue()) {
            return false;
        }
        AldrinUserStatus d = this.f10392d.d();
        if (d == null || d.tosTransitionType == null) {
            return false;
        }
        switch (C11061.f10387a[d.tosTransitionType.ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public final void m12190a(Context context) {
        if (!this.f10393e && !this.f10391c.j() && m12191a()) {
            Intent intent = new Intent(context, AldrinTransitionActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.f10390b.a(intent, context);
        }
    }
}
