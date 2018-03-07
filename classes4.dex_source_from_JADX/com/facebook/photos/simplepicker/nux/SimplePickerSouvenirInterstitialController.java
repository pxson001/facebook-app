package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: reindexContactsNames (%d contacts) */
public class SimplePickerSouvenirInterstitialController extends SimplePickerNux {
    public final Context f3510a;
    public final TipSeenTracker f3511b;
    private Tooltip f3512c;
    public View f3513d;
    public View f3514e;
    public View f3515f;
    public boolean f3516g;
    public SouvenirsLogger f3517h;

    @Inject
    public SimplePickerSouvenirInterstitialController(Context context, TipSeenTracker tipSeenTracker, SouvenirsLogger souvenirsLogger) {
        this.f3510a = context;
        this.f3511b = tipSeenTracker;
        this.f3517h = souvenirsLogger;
    }

    public final void mo281d() {
        this.f3513d = null;
        this.f3515f = null;
        this.f3514e = null;
    }

    public final void mo282e() {
        Preconditions.checkState(this.f3516g);
        this.f3512c = new Tooltip(this.f3510a, 2);
        this.f3512c.f5777t = -1;
        this.f3512c.m6255a(new 1(this));
        this.f3512c.f5789H = new 2(this);
        this.f3512c.mo540a(Position.BELOW);
        this.f3512c.m6256a(this.f3510a.getString(2131234430));
        this.f3512c.m6259b(this.f3510a.getString(2131234431));
        PopoverWindow popoverWindow = this.f3512c;
        popoverWindow.m6258b(popoverWindow.getContext().getResources().getDrawable(2130843387));
        this.f3512c.m6297f(this.f3515f);
        this.f3514e.setVisibility(0);
        this.f3514e.setOnClickListener(new 3(this));
        this.f3517h.b();
    }

    public final void m3828f() {
        this.f3512c.mo542l();
        this.f3514e.setVisibility(8);
    }

    public final String m3824b() {
        return "3993";
    }

    public final InterstitialControllerState m3823a(InterstitialTrigger interstitialTrigger) {
        if (this.f3511b.m3736c() && this.f3516g) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3825c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PHOTO_PICKER));
    }
}
