package com.facebook.appirater;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import com.facebook.appirater.DefaultAppiraterDialogMaker.1;
import com.facebook.appirater.DefaultAppiraterDialogMaker.2;
import com.facebook.appirater.DefaultAppiraterDialogMaker.3;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.appirater.Fb4aAppiraterParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: multi_batch */
public class Appirater {
    private static volatile Appirater f7366l;
    public boolean f7367a = false;
    public final Fb4aAppiraterParams f7368b;
    private final Provider<TriState> f7369c;
    public final AppVersionInfo f7370d;
    public final Clock f7371e;
    public final Lazy<AppiraterDialogMaker> f7372f;
    public final FbSharedPreferences f7373g;
    private final DefaultAndroidThreadUtil f7374h;
    private final Lazy<InternalStarRatingController> f7375i;
    public C03551 f7376j;
    private long f7377k = -1;

    /* compiled from: multi_batch */
    public class C03551 {
        public final /* synthetic */ Appirater f7384a;

        C03551(Appirater appirater) {
            this.f7384a = appirater;
        }
    }

    public static com.facebook.appirater.Appirater m7681a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7366l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.appirater.Appirater.class;
        monitor-enter(r1);
        r0 = f7366l;	 Catch:{ all -> 0x003a }
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
        r0 = m7682b(r0);	 Catch:{ all -> 0x0035 }
        f7366l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7366l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appirater.Appirater.a(com.facebook.inject.InjectorLike):com.facebook.appirater.Appirater");
    }

    private static Appirater m7682b(InjectorLike injectorLike) {
        return new Appirater(new Fb4aAppiraterParams(), IdBasedProvider.a(injectorLike, 634), AppVersionInfoMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 4860), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 288));
    }

    @Inject
    public Appirater(AppiraterParams appiraterParams, Provider<TriState> provider, AppVersionInfo appVersionInfo, Clock clock, Lazy<AppiraterDialogMaker> lazy, FbSharedPreferences fbSharedPreferences, AndroidThreadUtil androidThreadUtil, Lazy<InternalStarRatingController> lazy2) {
        this.f7368b = appiraterParams;
        this.f7369c = provider;
        this.f7370d = appVersionInfo;
        this.f7371e = clock;
        this.f7372f = lazy;
        this.f7373g = fbSharedPreferences;
        this.f7374h = androidThreadUtil;
        this.f7375i = lazy2;
        this.f7376j = new C03551(this);
    }

    public final void m7685a() {
        m7683d();
    }

    public final void m7687b() {
        m7683d();
        PrefKey prefKey = AppiraterPrefKeys.f2845d;
        this.f7373g.edit().a(prefKey, this.f7373g.a(prefKey, 0) + 1).commit();
        this.f7375i.get();
    }

    public final void m7686a(Activity activity) {
        this.f7374h.a();
        m7683d();
        if (((InternalStarRatingController) this.f7375i.get()).m7703a()) {
            this.f7375i.get();
        } else if (m7684e()) {
            this.f7367a = true;
            DefaultAppiraterDialogMaker defaultAppiraterDialogMaker = (DefaultAppiraterDialogMaker) this.f7372f.get();
            Fb4aAppiraterParams fb4aAppiraterParams = this.f7368b;
            String str = "Facebook";
            Fb4aAppiraterParams fb4aAppiraterParams2 = this.f7368b;
            String str2 = "com.facebook.katana";
            C03551 c03551 = this.f7376j;
            if (!(activity == null || activity.isFinishing())) {
                Builder builder = new Builder(new ContextThemeWrapper(activity, 2131625233));
                builder.m14337a(defaultAppiraterDialogMaker.b.getString(2131238486, new Object[]{str}));
                builder.m14346b(defaultAppiraterDialogMaker.b.getString(2131238485, new Object[]{str}));
                builder.mo963a(defaultAppiraterDialogMaker.b.getString(2131238487, new Object[]{str}), new 1(defaultAppiraterDialogMaker, c03551, str2, activity));
                builder.mo965b(2131238488, new 2(defaultAppiraterDialogMaker, c03551));
                builder.m14331a(new 3(defaultAppiraterDialogMaker, c03551));
                builder.m14349b();
            }
        }
    }

    private void m7683d() {
        String a = this.f7370d.a();
        if (!this.f7373g.a(AppiraterPrefKeys.f2847f, "").equals(a)) {
            this.f7373g.edit().a(AppiraterPrefKeys.f2843b, this.f7371e.a()).a(AppiraterPrefKeys.f2845d, 0).a(AppiraterPrefKeys.f2846e, 0).a(AppiraterPrefKeys.f2847f, a).commit();
        }
    }

    private boolean m7684e() {
        if (this.f7367a) {
            return false;
        }
        if (this.f7369c.get() != TriState.YES) {
            return false;
        }
        long a = this.f7371e.a();
        long a2 = this.f7373g.a(AppiraterPrefKeys.f2843b, this.f7377k);
        long a3 = this.f7373g.a(AppiraterPrefKeys.f2844c, this.f7377k);
        long j = a - a2;
        long c = 86400000 * ((long) this.f7368b.m7688c());
        a -= a3;
        long f = 86400000 * ((long) this.f7368b.m7691f());
        int a4 = this.f7373g.a(AppiraterPrefKeys.f2845d, 0);
        int a5 = this.f7373g.a(AppiraterPrefKeys.f2846e, 0);
        String a6 = this.f7373g.a(AppiraterPrefKeys.f2849h, "");
        String a7 = this.f7373g.a(AppiraterPrefKeys.f2848g, "");
        if ((a2 == this.f7377k || j >= c) && a4 >= this.f7368b.m7689d() && a5 >= this.f7368b.m7690e()) {
            if (!a6.equals(this.f7370d.a())) {
                if (!a7.equals(this.f7370d.a()) && (a3 == this.f7377k || a >= f)) {
                    return true;
                }
            }
        }
        return false;
    }
}
