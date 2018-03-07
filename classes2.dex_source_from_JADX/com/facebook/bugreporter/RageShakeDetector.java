package com.facebook.bugreporter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.bugreporter.abtest.ExperimentsForBugReporterModule;
import com.facebook.bugreporter.abtest.RageshakeRedesignQuickExperimentController;
import com.facebook.bugreporter.activity.BugReportActivity;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.SerialListeningExecutorService;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rageshake.RageSensorEventListener;
import com.facebook.reportaproblem.base.ReportAProblem;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: suggest_photo_location */
public class RageShakeDetector {
    private static volatile RageShakeDetector f3865i;
    public final Provider<String> f3866a;
    public final Provider<Boolean> f3867b;
    public ActivityListener f3868c = new ActivityListener(this);
    public final Lazy<SerialListeningExecutorService> f3869d;
    private RageshakeRedesignQuickExperimentController f3870e;
    public boolean f3871f;
    private Toaster f3872g;
    public Activity f3873h;

    /* compiled from: suggest_photo_location */
    public class ActivityListener extends AbstractFbActivityListener {
        public final /* synthetic */ RageShakeDetector f3880a;
        public RageSensorEventListener f3881b;
        public AsyncSensorRegistration f3882c;

        public ActivityListener(RageShakeDetector rageShakeDetector) {
            this.f3880a = rageShakeDetector;
        }

        public final void mo263c(Activity activity) {
            if ((activity instanceof FragmentManagerHost) && !this.f3880a.f3871f && ((Boolean) this.f3880a.f3867b.get()).booleanValue()) {
                if (this.f3881b == null) {
                    this.f3881b = new 1(this);
                }
                if (this.f3882c == null) {
                    this.f3882c = new AsyncSensorRegistration(activity.getApplicationContext(), (DefaultSerialListeningExecutorService) this.f3880a.f3869d.get(), this.f3881b);
                }
                this.f3882c.a();
                this.f3880a.f3871f = true;
            }
            this.f3880a.f3873h = activity;
        }

        public final void mo242d(Activity activity) {
            if (this.f3881b != null && this.f3880a.f3871f) {
                this.f3882c.b();
                this.f3880a.f3871f = false;
            }
            this.f3880a.f3873h = null;
        }
    }

    public static com.facebook.bugreporter.RageShakeDetector m6441a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3865i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.RageShakeDetector.class;
        monitor-enter(r1);
        r0 = f3865i;	 Catch:{ all -> 0x003a }
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
        r0 = m6442b(r0);	 Catch:{ all -> 0x0035 }
        f3865i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3865i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.RageShakeDetector.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.RageShakeDetector");
    }

    private static RageShakeDetector m6442b(InjectorLike injectorLike) {
        return new RageShakeDetector(IdBasedProvider.m1811a(injectorLike, 4442), IdBasedProvider.m1811a(injectorLike, 3909), Toaster.m6454b(injectorLike), new RageshakeRedesignQuickExperimentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike)), IdBasedLazy.m1808a(injectorLike, 519));
    }

    @Inject
    public RageShakeDetector(Provider<String> provider, Provider<Boolean> provider2, Toaster toaster, RageshakeRedesignQuickExperimentController rageshakeRedesignQuickExperimentController, Lazy<SerialListeningExecutorService> lazy) {
        this.f3866a = provider;
        this.f3867b = provider2;
        this.f3872g = toaster;
        this.f3870e = rageshakeRedesignQuickExperimentController;
        this.f3869d = lazy;
    }

    private void m6443d() {
        if (this.f3873h != null && this.f3868c != null) {
            if (this.f3870e.f3879a.mo596a(ExperimentsForBugReporterModule.a, false) && (this.f3873h instanceof FragmentActivity)) {
                ReportAProblem.m1029a((FragmentActivity) this.f3873h);
            } else if (m6444e() == null) {
                Collection a = Lists.m1300a(this.f3873h.getString(2131235819), this.f3873h.getString(2131235820), this.f3873h.getString(2131235821));
                String string = this.f3873h.getString(2131235795);
                RageShakeDialogFragment rageShakeDialogFragment = new RageShakeDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", string);
                ArrayList a2 = Lists.m1296a();
                a2.addAll(a);
                bundle.putCharSequenceArrayList("items", a2);
                rageShakeDialogFragment.m271g(bundle);
                rageShakeDialogFragment.m213a(m6445f(), "BugReportFragmentDialog");
            }
        }
    }

    private RageShakeDialogFragment m6444e() {
        return (RageShakeDialogFragment) m6445f().mo841a("BugReportFragmentDialog");
    }

    private FragmentManager m6445f() {
        if (this.f3873h instanceof FragmentManagerHost) {
            FragmentManager kO_ = ((FragmentManagerHost) this.f3873h).kO_();
            if (kO_ != null) {
                return kO_;
            }
        }
        throw new IllegalStateException("FragmentManager not available");
    }

    public final void m6447a() {
        if (this.f3873h != null && !m6446g() && !(this.f3873h instanceof BugReportActivity)) {
            Object obj;
            if (Strings.isNullOrEmpty((String) this.f3866a.get())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                this.f3872g.m6456b(new ToastBuilder(2131235812));
            } else {
                m6443d();
            }
        }
    }

    private boolean m6446g() {
        RageShakeDialogFragment e = m6444e();
        if (e != null) {
            return e.m282z();
        }
        return false;
    }
}
