package com.facebook.fbreact.instance;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.facebook.catalyst.shadow.flat.FlatUIImplementationProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.build.SignatureType;
import com.facebook.common.collect.WeakHashSets;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceHolderSpec;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.C03002;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManager.Builder;
import com.facebook.react.ReactPackage;
import com.facebook.react.XReactInstanceManager;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import junit.framework.Assert;

@Singleton
/* compiled from: staging_ground_enter */
public class FbReactInstanceHolder {
    private static volatile FbReactInstanceHolder f3502i;
    private final Context f3503a;
    private final Fb4aReactInstanceHolderSpec f3504b;
    private final DefaultAndroidThreadUtil f3505c;
    private final SecureContextHelper f3506d;
    public final Set<Fragment> f3507e;
    public final Set<Fragment> f3508f;
    public final Set<ClearListener> f3509g = new HashSet();
    public ReactInstanceManager f3510h;

    /* compiled from: staging_ground_enter */
    class C03051 implements Runnable {
        final /* synthetic */ FbReactInstanceHolder f3501a;

        C03051(FbReactInstanceHolder fbReactInstanceHolder) {
            this.f3501a = fbReactInstanceHolder;
        }

        public void run() {
            if (this.f3501a.f3510h != null) {
                this.f3501a.f3510h.mo636i();
                this.f3501a.f3510h = null;
                for (C03002 c03002 : this.f3501a.f3509g) {
                    if (!(c03002.f3463a.al == null || c03002.f3463a.am == null)) {
                        c03002.f3463a.al.removeView(c03002.f3463a.am);
                        c03002.f3463a.am.m13326a();
                        c03002.f3463a.am = null;
                        c03002.f3463a.ao = true;
                    }
                    c03002.f3463a.ap = false;
                }
            }
        }
    }

    public static com.facebook.fbreact.instance.FbReactInstanceHolder m4203a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3502i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.instance.FbReactInstanceHolder.class;
        monitor-enter(r1);
        r0 = f3502i;	 Catch:{ all -> 0x003a }
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
        r0 = m4204b(r0);	 Catch:{ all -> 0x0035 }
        f3502i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3502i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.instance.FbReactInstanceHolder.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.instance.FbReactInstanceHolder");
    }

    private static FbReactInstanceHolder m4204b(InjectorLike injectorLike) {
        return new FbReactInstanceHolder((Context) injectorLike.getInstance(Context.class), Fb4aReactInstanceHolderSpec.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public FbReactInstanceHolder(Context context, Fb4aReactInstanceHolderSpec fb4aReactInstanceHolderSpec, DefaultAndroidThreadUtil defaultAndroidThreadUtil, SecureContextHelper secureContextHelper) {
        Assert.assertNotNull(fb4aReactInstanceHolderSpec);
        this.f3503a = context;
        this.f3504b = fb4aReactInstanceHolderSpec;
        this.f3505c = defaultAndroidThreadUtil;
        this.f3506d = secureContextHelper;
        this.f3507e = WeakHashSets.a();
        this.f3508f = WeakHashSets.a();
    }

    public final boolean m4205a() {
        return this.f3510h != null;
    }

    public final void m4206b() {
        this.f3505c.a(new C03051(this));
    }

    public final ReactInstanceManager m4208c() {
        if (this.f3510h == null) {
            boolean z;
            Builder a;
            FlatUIImplementationProvider flatUIImplementationProvider;
            Fb4aReactInstanceHolderSpec fb4aReactInstanceHolderSpec = this.f3504b;
            if (BuildConstants.i && fb4aReactInstanceHolderSpec.d == SignatureType.DEBUG) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            if (z2 && VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.f3503a)) {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setFlags(268435456);
                this.f3506d.b(intent, this.f3503a);
                Toast.makeText(this.f3503a, "Overlay permissions needs to be granted in order for react native apps to run in dev mode.", 1).show();
            }
            fb4aReactInstanceHolderSpec = this.f3504b;
            if (1 != 0) {
                a = XReactInstanceManager.m13330a();
            } else {
                a = ReactInstanceManager.m13249k();
            }
            a.f11361e = (Application) this.f3503a.getApplicationContext();
            Builder builder = a;
            Fb4aReactInstanceHolderSpec fb4aReactInstanceHolderSpec2 = this.f3504b;
            builder = builder.m13244a("Fb4aBundle.js");
            fb4aReactInstanceHolderSpec2 = this.f3504b;
            builder.f11359c = "RKJSModules/Apps/Fb4a/Fb4aBundle";
            builder = builder;
            fb4aReactInstanceHolderSpec2 = this.f3504b;
            builder.f11363g = LifecycleState.BEFORE_RESUME;
            builder = builder;
            builder.f11362f = z2;
            builder = builder.m13241a((ReactPackage) this.f3504b.b);
            builder.f11365i = this.f3504b.c;
            builder = builder;
            builder.f11366j = this.f3504b.a;
            builder = builder;
            if (this.f3504b.e.a(Liveness.Live, ExperimentsForEventsGatingModule.Q, false)) {
                flatUIImplementationProvider = new FlatUIImplementationProvider();
            } else {
                flatUIImplementationProvider = null;
            }
            builder.f11364h = flatUIImplementationProvider;
            this.f3510h = builder.mo639a();
        }
        return this.f3510h;
    }

    public final void m4207b(C03002 c03002) {
        this.f3509g.remove(c03002);
    }
}
