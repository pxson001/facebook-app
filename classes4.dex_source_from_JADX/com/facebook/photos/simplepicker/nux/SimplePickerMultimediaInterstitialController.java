package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: registration_time */
public class SimplePickerMultimediaInterstitialController extends SimplePickerNux {
    private final Context f3519a;
    public final TipSeenTracker f3520b;
    public Tooltip f3521c;
    public View f3522d;
    public boolean f3523e;

    @Inject
    public SimplePickerMultimediaInterstitialController(Context context, TipSeenTracker tipSeenTracker) {
        this.f3519a = context;
        this.f3520b = tipSeenTracker;
    }

    public final void mo281d() {
        this.f3522d = null;
    }

    public final void mo282e() {
        this.f3521c = new NoArrowTooltip(this.f3519a, 2);
        this.f3521c.f5777t = -1;
        this.f3521c.m6255a(new 1(this));
        this.f3521c.f5789H = new 2(this);
        this.f3521c.mo540a(Position.ABOVE);
        this.f3521c.m6256a(this.f3519a.getString(2131234428));
        this.f3521c.m6259b(this.f3519a.getString(2131234429));
        this.f3521c.m6297f(this.f3522d);
    }

    public final String m3839b() {
        return "3883";
    }

    public final InterstitialControllerState m3838a(InterstitialTrigger interstitialTrigger) {
        if (this.f3523e && this.f3520b.m3736c()) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3840c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PHOTO_PICKER_DETECTED_RECENT_VIDEO));
    }
}
