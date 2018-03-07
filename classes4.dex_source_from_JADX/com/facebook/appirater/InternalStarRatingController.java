package com.facebook.appirater;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.appirater.api.AppRaterReport;
import com.facebook.appirater.api.FetchISRConfigResult;
import com.facebook.appirater.ratingdialog.AppiraterRatingDialogFragment;
import com.facebook.appirater.ratingdialog.AppiraterRatingDialogFragment.Screen;
import com.facebook.appirater.ratingdialog.RatingDialogSaveState;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: multi-output-single-context-table */
public class InternalStarRatingController {
    private static final Class<?> f7385a = InternalStarRatingController.class;
    private static final ImmutableList<Product> f7386b = ImmutableList.of(Product.FB4A, Product.PAA, Product.MESSENGER);
    private static volatile InternalStarRatingController f7387v;
    public final InternalStarRatingPreferences f7388c;
    private final DefaultBlueServiceOperationFactory f7389d;
    public final Handler f7390e;
    public final AbstractFbErrorReporter f7391f;
    private final FbAppType f7392g;
    private final Provider<TriState> f7393h;
    public final DefaultUserInteractionController f7394i;
    public int f7395j;
    public boolean f7396k;
    public boolean f7397l;
    public boolean f7398m;
    public boolean f7399n;
    public final Runnable f7400o = new C03561(this);
    private RatingDialogSaveState f7401p = null;
    public FetchISRConfigResult f7402q = null;
    public AppRaterReport f7403r = null;
    private WeakReference<Activity> f7404s = null;
    public boolean f7405t = false;
    private boolean f7406u = false;

    /* compiled from: multi-output-single-context-table */
    class C03561 implements Runnable {
        final /* synthetic */ InternalStarRatingController f7410a;

        C03561(InternalStarRatingController internalStarRatingController) {
            this.f7410a = internalStarRatingController;
        }

        public void run() {
            Object obj;
            InternalStarRatingController internalStarRatingController = this.f7410a;
            if (internalStarRatingController.f7394i.b() || internalStarRatingController.f7397l || internalStarRatingController.f7396k || internalStarRatingController.f7398m || internalStarRatingController.f7399n) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                InternalStarRatingController.m7698l(this.f7410a);
            } else if (this.f7410a.f7395j < 15) {
                internalStarRatingController = this.f7410a;
                internalStarRatingController.f7395j++;
                HandlerDetour.b(this.f7410a.f7390e, this.f7410a.f7400o, 120000, 1167651679);
            }
        }
    }

    public static com.facebook.appirater.InternalStarRatingController m7692a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7387v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.appirater.InternalStarRatingController.class;
        monitor-enter(r1);
        r0 = f7387v;	 Catch:{ all -> 0x003a }
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
        r0 = m7693b(r0);	 Catch:{ all -> 0x0035 }
        f7387v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7387v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appirater.InternalStarRatingController.a(com.facebook.inject.InjectorLike):com.facebook.appirater.InternalStarRatingController");
    }

    private static InternalStarRatingController m7693b(InjectorLike injectorLike) {
        return new InternalStarRatingController(new InternalStarRatingPreferences((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike)), DefaultBlueServiceOperationFactory.b(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedProvider.a(injectorLike, 635), DefaultUserInteractionController.a(injectorLike));
    }

    @Inject
    public InternalStarRatingController(InternalStarRatingPreferences internalStarRatingPreferences, BlueServiceOperationFactory blueServiceOperationFactory, Handler handler, FbErrorReporter fbErrorReporter, FbAppType fbAppType, Provider<TriState> provider, UserInteractionController userInteractionController) {
        this.f7388c = internalStarRatingPreferences;
        this.f7389d = blueServiceOperationFactory;
        this.f7390e = handler;
        this.f7391f = fbErrorReporter;
        this.f7392g = fbAppType;
        this.f7393h = provider;
        this.f7394i = userInteractionController;
        this.f7395j = 0;
    }

    public final boolean m7703a() {
        return f7386b.contains(this.f7392g.j) && ((TriState) this.f7393h.get()).asBoolean(false);
    }

    public final FetchISRConfigResult m7704d() {
        if (this.f7402q == null) {
            this.f7402q = this.f7388c.m7709a();
        }
        return this.f7402q;
    }

    private RatingDialogSaveState m7694g() {
        if (this.f7401p == null) {
            this.f7401p = this.f7388c.m7714c();
        }
        return this.f7401p;
    }

    public final void m7702a(RatingDialogSaveState ratingDialogSaveState) {
        this.f7401p = ratingDialogSaveState;
        this.f7388c.m7712a(ratingDialogSaveState);
    }

    public final void m7701a(AppRaterReport appRaterReport) {
        this.f7403r = appRaterReport;
        this.f7388c.m7710a(appRaterReport);
        m7702a(null);
        m7699m();
    }

    @Nullable
    private Activity m7695i() {
        return this.f7404s == null ? null : (Activity) this.f7404s.get();
    }

    @Nullable
    private FragmentManager m7696j() {
        Activity i = m7695i();
        if (i == null || !(i instanceof FragmentActivity)) {
            return null;
        }
        return ((FragmentActivity) i).kO_();
    }

    public final boolean m7705e() {
        if (this.f7406u || this.f7388c.m7715d() || m7697k() || this.f7388c.m7716e()) {
            return false;
        }
        FetchISRConfigResult d = m7704d();
        if (d == null || !d.a() || d.a(7200000)) {
            return true;
        }
        return false;
    }

    public final void m7700a(Activity activity) {
        if (m7703a() && !this.f7406u && !this.f7388c.m7715d() && !m7697k()) {
            this.f7395j = 0;
            this.f7404s = new WeakReference(activity);
            if (this.f7388c.m7713b() != null) {
                m7699m();
            } else if (m7695i() == null) {
            } else {
                if (!this.f7388c.m7716e() || m7694g() == null) {
                    FetchISRConfigResult d = m7704d();
                    if (d != null && d.a() && !d.b() && d.shouldAskUser) {
                        this.f7406u = true;
                        HandlerDetour.b(this.f7390e, this.f7400o, d.delayAskingMillis, 1796197477);
                        return;
                    }
                    return;
                }
                m7698l(this);
            }
        }
    }

    public final void m7706f() {
        if (m7703a()) {
            this.f7406u = false;
            HandlerDetour.a(this.f7390e, this.f7400o);
            if (this.f7404s != null) {
                this.f7404s.clear();
                this.f7404s = null;
            }
        }
    }

    private boolean m7697k() {
        FragmentManager j = m7696j();
        if (j == null || j.a("appirater_isr_dialog_fragment") == null) {
            return false;
        }
        return true;
    }

    public static void m7698l(InternalStarRatingController internalStarRatingController) {
        internalStarRatingController.f7406u = false;
        internalStarRatingController.f7395j = 0;
        FragmentManager j = internalStarRatingController.m7696j();
        if (j != null && j.c() && j.a("appirater_isr_dialog_fragment") == null) {
            RatingDialogSaveState g = internalStarRatingController.m7694g();
            AppiraterRatingDialogFragment appiraterRatingDialogFragment = new AppiraterRatingDialogFragment();
            Bundle bundle = new Bundle();
            if (g != null) {
                bundle.putInt("rating", g.rating);
                bundle.putString("rating_comment", g.ratingComment);
                bundle.putInt("current_screen", Screen.valueOf(g.lastScreen).toInt());
            }
            appiraterRatingDialogFragment.g(bundle);
            appiraterRatingDialogFragment.a(j, "appirater_isr_dialog_fragment");
            internalStarRatingController.f7388c.f7408b.edit().putBoolean(InternalStarRatingPrefKeys.d, true).commit();
        }
    }

    private void m7699m() {
        if (!this.f7405t) {
            if (this.f7403r == null) {
                this.f7403r = this.f7388c.m7713b();
            }
            Parcelable parcelable = this.f7403r;
            if (parcelable != null) {
                this.f7405t = true;
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("app_rater_report", parcelable);
                Futures.a(BlueServiceOperationFactoryDetour.a(this.f7389d, "appirater_create_report", bundle, 84630961).c(), new 2(this));
            }
        }
    }
}
