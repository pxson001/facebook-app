package com.facebook.fbreact.fragment;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.C02991;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: staging_ground_tap_edit_button */
public class ImmersiveReactFragmentHooks {
    private static volatile ImmersiveReactFragmentHooks f3489d;
    public final DefaultAndroidThreadUtil f3490a;
    public final AbstractFbErrorReporter f3491b;
    public C02991 f3492c;

    /* compiled from: staging_ground_tap_edit_button */
    public class C03031 implements Runnable {
        final /* synthetic */ String f3486a;
        final /* synthetic */ ImmersiveReactFragmentHooks f3487b;

        public C03031(ImmersiveReactFragmentHooks immersiveReactFragmentHooks, String str) {
            this.f3487b = immersiveReactFragmentHooks;
            this.f3486a = str;
        }

        public void run() {
            if (this.f3487b.f3492c != null) {
                C02991 c02991 = this.f3487b.f3492c;
                c02991.f3462a.m4174a(this.f3486a);
            }
        }
    }

    /* compiled from: staging_ground_tap_edit_button */
    class C03042 implements Runnable {
        final /* synthetic */ ImmersiveReactFragmentHooks f3488a;

        C03042(ImmersiveReactFragmentHooks immersiveReactFragmentHooks) {
            this.f3488a = immersiveReactFragmentHooks;
        }

        public void run() {
            if (this.f3488a.f3492c != null) {
                C02991 c02991 = this.f3488a.f3492c;
                ImmersiveReactFragment.aB(c02991.f3462a);
                c02991.f3462a.o().finish();
            }
        }
    }

    public static com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks m4188a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3489d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks.class;
        monitor-enter(r1);
        r0 = f3489d;	 Catch:{ all -> 0x003a }
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
        r0 = m4189b(r0);	 Catch:{ all -> 0x0035 }
        f3489d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3489d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks");
    }

    private static ImmersiveReactFragmentHooks m4189b(InjectorLike injectorLike) {
        return new ImmersiveReactFragmentHooks(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ImmersiveReactFragmentHooks(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3490a = defaultAndroidThreadUtil;
        this.f3491b = abstractFbErrorReporter;
    }

    public final void m4190a() {
        this.f3490a.a(new C03042(this));
    }

    @Nullable
    public final Bundle m4192b() {
        return this.f3492c != null ? this.f3492c.f3462a.f3485i : null;
    }

    public final void m4191a(Bundle bundle) {
        if (this.f3492c != null) {
            this.f3492c.f3462a.f3485i = bundle;
        }
    }
}
