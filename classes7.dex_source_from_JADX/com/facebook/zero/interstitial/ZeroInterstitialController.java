package com.facebook.zero.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.activity.NativeOptinInterstitialActivity;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: {SouvenirPhotoItem %s} */
public class ZeroInterstitialController implements InterstitialIntentController {
    private final FbZeroFeatureVisibilityHelper f114a;

    public static ZeroInterstitialController m110b(InjectorLike injectorLike) {
        return new ZeroInterstitialController(FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    @Inject
    public ZeroInterstitialController(FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f114a = fbZeroFeatureVisibilityHelper;
    }

    public final Optional<Intent> m113a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    public final String m116b() {
        return "1710";
    }

    public final void m115a(Parcelable parcelable) {
    }

    public final void m114a(long j) {
    }

    public final InterstitialControllerState m112a(InterstitialTrigger interstitialTrigger) {
        if (this.f114a.a(ZeroFeatureKey.NATIVE_OPTIN_INTERSTITIAL)) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m117c() {
        return ImmutableList.of(new InterstitialTrigger(Action.APP_FOREGROUND), new InterstitialTrigger(Action.SESSION_COLD_START));
    }

    public final Intent m111a(Context context) {
        return new Intent(context, NativeOptinInterstitialActivity.class);
    }

    public final long hI_() {
        return 86400000;
    }
}
