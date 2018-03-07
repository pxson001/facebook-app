package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: simple_search_loader_key */
public class ViewerSuggestLocationInterstitialController extends BaseInterstitialController implements InterstitialActionController {
    private final FbLocationStatusUtil f2836a;
    public OnTooltipClickListener f2837b;
    public View f2838c;

    @Inject
    public ViewerSuggestLocationInterstitialController(FbLocationStatusUtil fbLocationStatusUtil) {
        this.f2836a = fbLocationStatusUtil;
    }

    public final void m2878a(Context context, Object obj) {
        if (this.f2838c != null) {
            Tooltip tooltip = new Tooltip(this.f2838c.getContext(), 2);
            tooltip.t = -1;
            tooltip.b(context.getString(2131237858));
            tooltip.a(Position.BELOW);
            tooltip.a(this.f2837b);
            tooltip.a(this.f2838c);
        }
    }

    public final String m2879b() {
        return "4003";
    }

    public final InterstitialControllerState m2877a(InterstitialTrigger interstitialTrigger) {
        if (this.f2836a.b().a == State.OKAY) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m2880c() {
        return ImmutableList.of(new InterstitialTrigger(Action.MEDIA_GALLERY_OPENED));
    }

    public final long hI_() {
        return 86400000;
    }
}
