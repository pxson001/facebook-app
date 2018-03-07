package com.facebook.growth.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.growth.nux.NUXStepsValidator;
import com.facebook.growth.nux.UserAccountNUXActivity;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.api.InterstitialNUXFetchResult;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialNUXController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.model.NuxStep;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pacing_type */
public class UserAccountNUXInterstitialController implements InterstitialControllerWithContextClass, InterstitialIntentController, InterstitialNUXController {
    private static volatile UserAccountNUXInterstitialController f7398e;
    private final FbSharedPreferences f7399a;
    private final NUXStepsValidator f7400b;
    private List<NuxStep> f7401c;
    private Map<String, String> f7402d;

    public static com.facebook.growth.interstitial.UserAccountNUXInterstitialController m7718a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7398e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.growth.interstitial.UserAccountNUXInterstitialController.class;
        monitor-enter(r1);
        r0 = f7398e;	 Catch:{ all -> 0x003a }
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
        r0 = m7719b(r0);	 Catch:{ all -> 0x0035 }
        f7398e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7398e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.growth.interstitial.UserAccountNUXInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.growth.interstitial.UserAccountNUXInterstitialController");
    }

    private static UserAccountNUXInterstitialController m7719b(InjectorLike injectorLike) {
        return new UserAccountNUXInterstitialController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NUXStepsValidator.m7734a(injectorLike));
    }

    public final Optional<Intent> m7722a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public UserAccountNUXInterstitialController(FbSharedPreferences fbSharedPreferences, NUXStepsValidator nUXStepsValidator) {
        this.f7399a = fbSharedPreferences;
        this.f7400b = nUXStepsValidator;
    }

    public final String m7725b() {
        return "1630";
    }

    public final Class<? extends Parcelable> m7727d() {
        return InterstitialNUXFetchResult.class;
    }

    public final void m7724a(Parcelable parcelable) {
        if (parcelable != null && (parcelable instanceof InterstitialNUXFetchResult)) {
            InterstitialNUXFetchResult interstitialNUXFetchResult = (InterstitialNUXFetchResult) parcelable;
            this.f7401c = interstitialNUXFetchResult.steps;
            this.f7402d = interstitialNUXFetchResult.extraData;
        }
    }

    public final void m7723a(long j) {
    }

    public final InterstitialControllerState m7721a(InterstitialTrigger interstitialTrigger) {
        if (this.f7399a.a(GrowthPrefKeys.b, false)) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f7401c == null || this.f7401c.isEmpty()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f7400b.m7736a(this.f7401c).isEmpty()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m7726c() {
        return ImmutableList.of(new InterstitialTrigger(Action.APP_FOREGROUND), new InterstitialTrigger(Action.SESSION_COLD_START));
    }

    public final Intent m7720a(Context context) {
        return new Intent(context, UserAccountNUXActivity.class);
    }

    public final List<NuxStep> m7728e() {
        return this.f7401c;
    }

    public final long hI_() {
        return 0;
    }
}
