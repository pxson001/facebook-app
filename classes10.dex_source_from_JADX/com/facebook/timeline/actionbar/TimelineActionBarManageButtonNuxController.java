package com.facebook.timeline.actionbar;

import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: groups/files/{%s} */
public class TimelineActionBarManageButtonNuxController implements InterstitialController {
    public static final PrefKey f10297a = ((PrefKey) SharedPrefKeys.h.a("memorialization/has_seen_manage_nux"));
    private FbSharedPreferences f10298b;
    private Resources f10299c;
    public boolean f10300d = false;

    public static TimelineActionBarManageButtonNuxController m10429b(InjectorLike injectorLike) {
        return new TimelineActionBarManageButtonNuxController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineActionBarManageButtonNuxController(FbSharedPreferences fbSharedPreferences, Resources resources) {
        this.f10298b = fbSharedPreferences;
        this.f10299c = resources;
    }

    public final String m10435b() {
        return "3226";
    }

    public static TimelineActionBarManageButtonNuxController m10428a(InjectorLike injectorLike) {
        return m10429b(injectorLike);
    }

    public final InterstitialControllerState m10430a(InterstitialTrigger interstitialTrigger) {
        return (!this.f10300d || this.f10298b.a(f10297a, false)) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m10436c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final void m10432a(Parcelable parcelable) {
    }

    public final void m10431a(long j) {
    }

    public final long hI_() {
        return 0;
    }

    public final void m10433a(View view, String str) {
        Tooltip tooltip = new Tooltip(view.getContext(), 2);
        tooltip.t = -1;
        tooltip.a(this.f10299c.getString(2131234870, new Object[]{str}));
        tooltip.b(2131234871);
        tooltip.b(0.2f);
        tooltip.a(view);
    }

    public final void m10437d() {
        this.f10298b.edit().putBoolean(f10297a, true).commit();
    }

    public final void m10434a(boolean z) {
        this.f10300d = z;
    }
}
