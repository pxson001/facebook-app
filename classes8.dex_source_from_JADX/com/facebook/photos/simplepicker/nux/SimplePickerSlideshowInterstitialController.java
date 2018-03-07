package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.photos.simplepicker.controller.SimplePickerSlideshowEntrypointController;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: setSource */
public class SimplePickerSlideshowInterstitialController extends SimplePickerNux {
    private final Context f3219a;
    public final TipSeenTracker f3220b;
    public final SlideshowLogger f3221c;
    public Tooltip f3222d;
    public boolean f3223e;
    public int f3224f;
    public SimplePickerSlideshowEntrypointController f3225g;

    /* compiled from: setSource */
    class C04121 implements OnTooltipClickListener {
        final /* synthetic */ SimplePickerSlideshowInterstitialController f3217a;

        C04121(SimplePickerSlideshowInterstitialController simplePickerSlideshowInterstitialController) {
            this.f3217a = simplePickerSlideshowInterstitialController;
        }

        public final void m3186a() {
            this.f3217a.f3222d.l();
        }
    }

    /* compiled from: setSource */
    class C04132 implements OnDismissListener {
        final /* synthetic */ SimplePickerSlideshowInterstitialController f3218a;

        C04132(SimplePickerSlideshowInterstitialController simplePickerSlideshowInterstitialController) {
            this.f3218a = simplePickerSlideshowInterstitialController;
        }

        public final boolean m3187a(PopoverWindow popoverWindow) {
            this.f3218a.f3225g.m3153c();
            this.f3218a.f3221c.m10729b();
            this.f3218a.f3220b.a();
            return true;
        }
    }

    @Inject
    public SimplePickerSlideshowInterstitialController(Context context, TipSeenTracker tipSeenTracker, SlideshowLogger slideshowLogger) {
        this.f3219a = context;
        this.f3220b = tipSeenTracker;
        this.f3221c = slideshowLogger;
    }

    public final void m3192e() {
        if (this.f3225g != null) {
            this.f3222d = new Tooltip(this.f3219a, 2);
            this.f3222d.t = -1;
            this.f3222d.a(new C04121(this));
            this.f3222d.H = new C04132(this);
            this.f3222d.a(Position.BELOW);
            this.f3222d.a(this.f3219a.getString(2131234437));
            this.f3222d.b(this.f3219a.getString(2131234438, new Object[]{Integer.valueOf(this.f3224f)}));
            this.f3221c.m10726a();
            this.f3225g.m3151a();
            this.f3222d.f(this.f3225g.f3148c.findViewById(2131567491));
        }
    }

    public final void m3191d() {
        this.f3225g = null;
    }

    public final String m3189b() {
        return "4194";
    }

    public final InterstitialControllerState m3188a(InterstitialTrigger interstitialTrigger) {
        return (this.f3223e && this.f3220b.c() && this.f3225g != null) ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3190c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PHOTO_PICKER));
    }

    public final long hI_() {
        return 0;
    }
}
