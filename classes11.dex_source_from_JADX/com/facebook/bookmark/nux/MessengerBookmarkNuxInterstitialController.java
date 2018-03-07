package com.facebook.bookmark.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.widget.titlebar.TitlebarHost;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: mediaSelectedFromPicker */
public class MessengerBookmarkNuxInterstitialController implements InterstitialActionController, InterstitialController {
    private final FbSharedPreferences f5489a;

    @Inject
    public MessengerBookmarkNuxInterstitialController(FbSharedPreferences fbSharedPreferences) {
        this.f5489a = fbSharedPreferences;
    }

    public final void m6698a(Context context, Object obj) {
        if (context instanceof ProvidesInterface) {
            TitlebarHost titlebarHost = (TitlebarHost) ((ProvidesInterface) context).a(TitlebarHost.class);
            if (titlebarHost != null) {
                Tooltip tooltip = new Tooltip(context, 2);
                tooltip.t = -1;
                tooltip.b(context.getResources().getString(2131230841));
                titlebarHost.a(tooltip);
                this.f5489a.edit().putBoolean(BookmarkNuxPrefKeys.f5487a, true).commit();
            }
        }
    }

    public final String m6700b() {
        return "3086";
    }

    public final void m6699a(Parcelable parcelable) {
    }

    public final void m6697a(long j) {
    }

    public final ImmutableList<InterstitialTrigger> m6701c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TAB_NAVIGATION_ATTACHED));
    }

    public final InterstitialControllerState m6696a(InterstitialTrigger interstitialTrigger) {
        if (this.f5489a.a(BookmarkNuxPrefKeys.f5487a, false)) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final long hI_() {
        return 0;
    }
}
