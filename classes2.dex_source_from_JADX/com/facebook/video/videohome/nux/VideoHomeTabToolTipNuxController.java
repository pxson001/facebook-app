package com.facebook.video.videohome.nux;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.video.videohome.prefs.VideoHomePrefKeys;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: goodwill_lcau_survey_new_ui */
public class VideoHomeTabToolTipNuxController implements InterstitialActionController, InterstitialController {
    private final GlyphColorizer f22155a;
    private final FbSharedPreferences f22156b;
    public View f22157c;

    @Inject
    public VideoHomeTabToolTipNuxController(GlyphColorizer glyphColorizer, FbSharedPreferences fbSharedPreferences) {
        this.f22155a = glyphColorizer;
        this.f22156b = fbSharedPreferences;
    }

    public final void mo1752a(Context context, Object obj) {
        Preconditions.checkNotNull(this.f22157c);
        Tooltip tooltip = new Tooltip(context, 2);
        tooltip.b(this.f22155a.m11489a(2130840030, -1));
        tooltip.a(2131237320);
        tooltip.b(2131237321);
        tooltip.a(Position.BELOW);
        tooltip.t = -1;
        tooltip.f(this.f22157c);
    }

    public final String mo1173b() {
        return "4111";
    }

    public final void mo1172a(Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        if (this.f22156b.mo286a(VideoHomePrefKeys.f22154c, false) || this.f22156b.mo276a(VideoHomePrefKeys.f22153b, 0) < 3) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.VIDEO_HOME_TAB_TOOLTIP));
    }

    public final long hI_() {
        return 86400000;
    }
}
