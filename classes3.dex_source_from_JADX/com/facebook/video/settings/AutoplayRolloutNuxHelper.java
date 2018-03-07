package com.facebook.video.settings;

import android.content.Context;
import android.view.View;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.video.settings.tooltip.VideoTooltip;
import javax.inject.Inject;

/* compiled from: ufi/reactions/v2/face_models/anger */
public class AutoplayRolloutNuxHelper {
    private final FbSharedPreferences f95a;
    private final InterstitialManager f96b;

    public static AutoplayRolloutNuxHelper m90a(InjectorLike injectorLike) {
        return new AutoplayRolloutNuxHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InterstitialManager.a(injectorLike));
    }

    @Inject
    public AutoplayRolloutNuxHelper(FbSharedPreferences fbSharedPreferences, InterstitialManager interstitialManager) {
        this.f95a = fbSharedPreferences;
        this.f96b = interstitialManager;
    }

    public final void m91a(View view) {
        if (this.f95a.a(VideoPrefs.h)) {
            AutoplayRolloutNuxController autoplayRolloutNuxController = (AutoplayRolloutNuxController) this.f96b.a(new InterstitialTrigger(Action.VIDEO_AUTOPLAY), AutoplayRolloutNuxController.class);
            if (autoplayRolloutNuxController != null) {
                int e = autoplayRolloutNuxController.e();
                Context context = view.getContext();
                VideoTooltip videoTooltip = new VideoTooltip(view.getContext(), 2);
                videoTooltip.w = -1;
                AutoPlaySettingValue valueOf = AutoPlaySettingValue.valueOf(VideoAutoPlayListPreferenceSettings.a(autoplayRolloutNuxController.d, autoplayRolloutNuxController.b));
                AutoPlaySettingValue valueOf2 = AutoPlaySettingValue.valueOf(autoplayRolloutNuxController.b.a(VideoPrefs.h, autoplayRolloutNuxController.d.toString()));
                if (valueOf2 == AutoPlaySettingValue.OFF && valueOf == AutoPlaySettingValue.ON) {
                    videoTooltip.a(2131236199);
                    videoTooltip.b(2131236201);
                } else if (valueOf2 == AutoPlaySettingValue.OFF && valueOf == AutoPlaySettingValue.WIFI_ONLY) {
                    videoTooltip.a(2131236199);
                    videoTooltip.b(2131236202);
                } else {
                    if (valueOf2 == AutoPlaySettingValue.WIFI_ONLY && valueOf == AutoPlaySettingValue.ON) {
                        videoTooltip.a(2131236200);
                        videoTooltip.b(2131236203);
                    }
                    if (autoplayRolloutNuxController.e() > e) {
                        this.f96b.a().a(autoplayRolloutNuxController.b());
                    }
                }
                videoTooltip.a(context.getString(2131236204), new TooltipButtonClickListener(autoplayRolloutNuxController, context));
                videoTooltip.b(context.getString(2131236205), new TooltipButtonClickListener(autoplayRolloutNuxController, context));
                videoTooltip.b(0.2f);
                videoTooltip.a(view);
                autoplayRolloutNuxController.b.edit().a(AutoplayRolloutNuxController.a, autoplayRolloutNuxController.e() + 1).commit();
                if (autoplayRolloutNuxController.e() > e) {
                    this.f96b.a().a(autoplayRolloutNuxController.b());
                }
            }
        }
    }
}
