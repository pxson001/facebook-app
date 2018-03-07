package com.facebook.fbui.runtimelinter;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.activityidentifier.ActivityNameFormatter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder.JSONOutputType;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder.ViewTraversalMode;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: qp_definition */
public class UIRuntimeLinter {
    private static final Class<?> f8495a = UIRuntimeLinter.class;
    private static volatile UIRuntimeLinter f8496q;
    private final Lazy<Set<RuntimeLinterRule>> f8497b;
    public final Handler f8498c;
    public final Random f8499d;
    private final AbstractFbErrorReporter f8500e;
    private final Provider<TriState> f8501f;
    private final ViewDescriptionBuilder f8502g;
    private final ActivityNameFormatter f8503h;
    private final DefaultAndroidThreadUtil f8504i;
    public final DefaultUserInteractionController f8505j;
    public final Provider<Boolean> f8506k;
    private List<RuntimeLinterRule> f8507l;
    public boolean f8508m;
    public WeakReference<Activity> f8509n = new WeakReference(null);
    public Runnable f8510o;
    public UserInteractionListener f8511p;

    public static com.facebook.fbui.runtimelinter.UIRuntimeLinter m13047a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8496q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.runtimelinter.UIRuntimeLinter.class;
        monitor-enter(r1);
        r0 = f8496q;	 Catch:{ all -> 0x003a }
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
        r0 = m13050b(r0);	 Catch:{ all -> 0x0035 }
        f8496q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8496q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.runtimelinter.UIRuntimeLinter.a(com.facebook.inject.InjectorLike):com.facebook.fbui.runtimelinter.UIRuntimeLinter");
    }

    private static UIRuntimeLinter m13050b(InjectorLike injectorLike) {
        return new UIRuntimeLinter(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$RuntimeLinterRule(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), ViewDescriptionBuilder.m13060b(injectorLike), IdBasedProvider.m1811a(injectorLike, 640), DefaultUserInteractionController.m1747a(injectorLike), ActivityNameFormatter.m6512a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3972));
    }

    @Inject
    public UIRuntimeLinter(Lazy<Set<RuntimeLinterRule>> lazy, Handler handler, FbErrorReporter fbErrorReporter, ViewDescriptionBuilder viewDescriptionBuilder, Provider<TriState> provider, UserInteractionController userInteractionController, ActivityNameFormatter activityNameFormatter, AndroidThreadUtil androidThreadUtil, Random random, Provider<Boolean> provider2) {
        this.f8497b = lazy;
        this.f8498c = handler;
        this.f8500e = fbErrorReporter;
        this.f8502g = viewDescriptionBuilder;
        this.f8501f = provider;
        this.f8505j = userInteractionController;
        this.f8503h = activityNameFormatter;
        this.f8504i = androidThreadUtil;
        this.f8499d = random;
        this.f8506k = provider2;
    }

    @VisibleForTesting
    public final void m13055a(boolean z) {
        if (!z) {
            m13056b(1000);
        }
    }

    @VisibleForTesting
    public final void m13054a(Activity activity) {
        this.f8509n = new WeakReference(activity);
    }

    public final void m13053a(int i) {
        if (m13052e() && this.f8509n.get() != null) {
            this.f8504i.m1649a();
            HandlerDetour.b(this.f8498c, new 2(this), (long) i, 204670123);
        }
    }

    public final void m13056b(int i) {
        if (m13052e() && this.f8510o == null && this.f8509n.get() != null && ((Boolean) this.f8506k.get()).booleanValue()) {
            this.f8504i.m1649a();
            if (this.f8499d.nextInt(i) == 0) {
                this.f8510o = new 3(this);
                HandlerDetour.b(this.f8498c, this.f8510o, (long) (this.f8499d.nextInt(10000) + 5000), -1885844023);
            }
        }
    }

    public static void m13049a(UIRuntimeLinter uIRuntimeLinter, RuntimeLinterRule runtimeLinterRule) {
        try {
            uIRuntimeLinter.f8505j.m1752a(5000);
            Activity activity = (Activity) uIRuntimeLinter.f8509n.get();
            if (activity != null) {
                View view = (ViewGroup) activity.findViewById(16908290).getRootView();
                Map c = Maps.m838c();
                long uptimeMillis = SystemClock.uptimeMillis();
                new StringBuilder("Running UI linter ").append(runtimeLinterRule.getClass().getSimpleName());
                if (runtimeLinterRule.a(view, c)) {
                    c.put("view_hierarchy", uIRuntimeLinter.m13048a(view));
                    c.put("current_activity", ActivityNameFormatter.m6513a(activity));
                    uIRuntimeLinter.f8500e.mo340a(runtimeLinterRule.b(), runtimeLinterRule.a(), c);
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 > 500) {
                    uIRuntimeLinter.f8500e.m2340a("Slow Runtime Lint", "Testing rule " + runtimeLinterRule.getClass().getSimpleName() + " took " + uptimeMillis2 + " msec");
                }
            }
        } catch (Throwable th) {
            uIRuntimeLinter.f8500e.m2343a(f8495a.getSimpleName(), "Failed while testing rule " + runtimeLinterRule.getClass().getSimpleName(), th);
            BLog.b(f8495a, "Throwable caught while linting UI.", th);
        }
    }

    public static synchronized List m13051d(UIRuntimeLinter uIRuntimeLinter) {
        List list;
        synchronized (uIRuntimeLinter) {
            if (uIRuntimeLinter.f8507l == null) {
                uIRuntimeLinter.f8507l = new ArrayList((Collection) uIRuntimeLinter.f8497b.get());
            }
            list = uIRuntimeLinter.f8507l;
        }
        return list;
    }

    private boolean m13052e() {
        return ((TriState) this.f8501f.get()).asBoolean(false);
    }

    private String m13048a(View view) {
        return this.f8502g.m13062a(view, ViewTraversalMode.ALL, JSONOutputType.PRETTY);
    }
}
