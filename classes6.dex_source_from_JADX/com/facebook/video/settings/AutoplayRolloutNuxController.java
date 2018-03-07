package com.facebook.video.settings;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.content.SecureContextHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.maps.model.internal.IPolylineDelegate */
public class AutoplayRolloutNuxController implements InterstitialController {
    public static final PrefKey f19607a = ((PrefKey) InterstitialPrefKeys.a.a("autoplay/count_seen_autoplay_nux"));
    public final FbSharedPreferences f19608b;
    public SecureContextHelper f19609c;
    public final AutoPlaySettingValue f19610d;

    /* compiled from: com.google.android.gms.maps.model.internal.IPolylineDelegate */
    public class TooltipButtonClickListener {
        public Context f19605a;
        public final /* synthetic */ AutoplayRolloutNuxController f19606b;

        public TooltipButtonClickListener(AutoplayRolloutNuxController autoplayRolloutNuxController, Context context) {
            this.f19606b = autoplayRolloutNuxController;
            this.f19605a = context;
        }
    }

    @Inject
    public AutoplayRolloutNuxController(AutoPlaySettingValue autoPlaySettingValue, SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences) {
        this.f19608b = fbSharedPreferences;
        this.f19609c = secureContextHelper;
        this.f19610d = autoPlaySettingValue;
    }

    public final String m28310b() {
        return "3507";
    }

    public final InterstitialControllerState m28307a(InterstitialTrigger interstitialTrigger) {
        if (m28313e() >= 3) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m28311c() {
        return ImmutableList.of(new InterstitialTrigger(Action.VIDEO_AUTOPLAY));
    }

    public final void m28309a(Parcelable parcelable) {
    }

    public final void m28308a(long j) {
    }

    public final long hI_() {
        return 86400000;
    }

    public final void m28312d() {
        this.f19608b.edit().a(f19607a, 3).commit();
    }

    public final int m28313e() {
        Object c = this.f19608b.c(f19607a);
        if (c instanceof Integer) {
            return ((Integer) c).intValue();
        }
        return 0;
    }
}
