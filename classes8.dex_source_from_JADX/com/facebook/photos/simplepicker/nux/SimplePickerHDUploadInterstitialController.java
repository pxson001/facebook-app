package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.net.NetworkInfo;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: setup_tag_suggestions */
public class SimplePickerHDUploadInterstitialController extends SimplePickerNux {
    private final FbNetworkManager f3191a;
    public final FbUriIntentHandler f3192b;
    public final TipSeenTracker f3193c;
    private final Provider<Boolean> f3194d;
    public Context f3195e;
    public View f3196f;
    public Tooltip f3197g;

    /* compiled from: setup_tag_suggestions */
    class C04101 implements OnTooltipClickListener {
        final /* synthetic */ SimplePickerHDUploadInterstitialController f3189a;

        C04101(SimplePickerHDUploadInterstitialController simplePickerHDUploadInterstitialController) {
            this.f3189a = simplePickerHDUploadInterstitialController;
        }

        public final void m3172a() {
            this.f3189a.f3197g.l();
            this.f3189a.f3192b.a(this.f3189a.f3195e, FBLinks.co);
        }
    }

    /* compiled from: setup_tag_suggestions */
    class C04112 implements OnDismissListener {
        final /* synthetic */ SimplePickerHDUploadInterstitialController f3190a;

        C04112(SimplePickerHDUploadInterstitialController simplePickerHDUploadInterstitialController) {
            this.f3190a = simplePickerHDUploadInterstitialController;
        }

        public final boolean m3173a(PopoverWindow popoverWindow) {
            this.f3190a.f3193c.a();
            return true;
        }
    }

    /* compiled from: setup_tag_suggestions */
    class NoArrowTooltip extends Tooltip {
        public NoArrowTooltip(Context context, int i) {
            super(context, i);
        }

        protected final void m3174a(View view, boolean z, LayoutParams layoutParams) {
            super.a(view, z, layoutParams);
            View findViewById = this.f.findViewById(2131561861);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    @Inject
    public SimplePickerHDUploadInterstitialController(FbNetworkManager fbNetworkManager, FbUriIntentHandler fbUriIntentHandler, TipSeenTracker tipSeenTracker, Provider<Boolean> provider) {
        this.f3191a = fbNetworkManager;
        this.f3192b = fbUriIntentHandler;
        this.f3193c = tipSeenTracker;
        this.f3194d = provider;
    }

    public final void m3178d() {
        this.f3195e = null;
        this.f3196f = null;
        this.f3197g = null;
    }

    public final void m3179e() {
        View findViewById = this.f3196f.findViewById(2131558756);
        this.f3197g = new NoArrowTooltip(this.f3195e, 2);
        this.f3197g.t = -1;
        this.f3197g.a(new C04101(this));
        this.f3197g.H = new C04112(this);
        this.f3197g.a(Position.ABOVE);
        this.f3197g.a(this.f3195e.getString(2131234432));
        this.f3197g.b(this.f3195e.getString(2131234433));
        this.f3197g.f(findViewById);
    }

    public final String m3176b() {
        return "4169";
    }

    public final InterstitialControllerState m3175a(InterstitialTrigger interstitialTrigger) {
        NetworkInfo i = this.f3191a.i();
        if (((Boolean) this.f3194d.get()).booleanValue() || i == null || !this.f3193c.c() || this.f3196f.getVisibility() != 0) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (i.getType() != 1) {
            Object obj;
            if (i.getType() == 0 && i.getSubtype() == 13) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return InterstitialControllerState.INELIGIBLE;
            }
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3177c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PHOTO_PICKER));
    }
}
