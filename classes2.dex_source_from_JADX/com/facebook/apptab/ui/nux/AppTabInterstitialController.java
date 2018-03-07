package com.facebook.apptab.ui.nux;

import android.content.ComponentName;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.facebook.apptab.state.AppTabPrefKeys;
import com.facebook.apptab.state.TabTag;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: spdy/3.1 */
public class AppTabInterstitialController implements InterstitialController {
    private static volatile AppTabInterstitialController f4253d;
    private final FbSharedPreferences f4254a;
    public final FbMainTabActivityNuxController f4255b;
    private final Provider<ComponentName> f4256c;

    public static com.facebook.apptab.ui.nux.AppTabInterstitialController m7868a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4253d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.apptab.ui.nux.AppTabInterstitialController.class;
        monitor-enter(r1);
        r0 = f4253d;	 Catch:{ all -> 0x003a }
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
        r0 = m7869b(r0);	 Catch:{ all -> 0x0035 }
        f4253d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4253d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.apptab.ui.nux.AppTabInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.apptab.ui.nux.AppTabInterstitialController");
    }

    private static AppTabInterstitialController m7869b(InjectorLike injectorLike) {
        return new AppTabInterstitialController(FbSharedPreferencesImpl.m1826a(injectorLike), new FbMainTabActivityNuxController(FbSharedPreferencesImpl.m1826a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike)), IdBasedSingletonScopeProvider.m1809a(injectorLike, 11));
    }

    @Inject
    public AppTabInterstitialController(FbSharedPreferences fbSharedPreferences, FbMainTabActivityNuxController fbMainTabActivityNuxController, Provider<ComponentName> provider) {
        this.f4254a = fbSharedPreferences;
        this.f4255b = fbMainTabActivityNuxController;
        this.f4256c = provider;
    }

    public final String mo1173b() {
        return "1862";
    }

    public final void mo1172a(Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        return m7870e();
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.ACTIVITY_CREATED, ((ComponentName) this.f4256c.get()).getClassName()), new InterstitialTrigger(Action.ACTIVITY_CONFIGURATION_CHANGED, ((ComponentName) this.f4256c.get()).getClassName()));
    }

    public final long hI_() {
        return 0;
    }

    public final void m7874a(ViewGroup viewGroup, List<TabTag> list) {
        TracerDetour.a("AppTabInterstitialController.setup", 106205856);
        try {
            if (m7870e() == InterstitialControllerState.ELIGIBLE) {
                this.f4255b.m7885a(viewGroup, (List) list);
            }
            TracerDetour.a(-568946361);
        } catch (Throwable th) {
            TracerDetour.a(-841294137);
        }
    }

    private InterstitialControllerState m7870e() {
        return this.f4254a.mo286a(AppTabPrefKeys.f8143d, false) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }
}
