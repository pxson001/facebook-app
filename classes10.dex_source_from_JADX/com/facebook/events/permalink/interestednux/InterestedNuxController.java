package com.facebook.events.permalink.interestednux;

import android.view.View;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: birthday_view_entry */
public class InterestedNuxController {
    public final TipSeenTracker f18562a;
    public final InterstitialManager f18563b;
    private int f18564c;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: birthday_view_entry */
    public @interface NuxState {
    }

    public static InterestedNuxController m18900b(InjectorLike injectorLike) {
        return new InterestedNuxController(TipSeenTracker.b(injectorLike), InterstitialManager.a(injectorLike));
    }

    @Inject
    public InterestedNuxController(TipSeenTracker tipSeenTracker, InterstitialManager interstitialManager) {
        this.f18562a = tipSeenTracker;
        this.f18563b = interstitialManager;
        this.f18562a.a(EventsPrefKeys.f19010d);
        this.f18562a.b = 1;
        if (this.f18562a.c()) {
            this.f18564c = 0;
        } else {
            this.f18564c = 1;
        }
    }

    public final boolean m18902a() {
        return this.f18564c == 0;
    }

    public final void m18901a(@Nullable final View view) {
        if (view != null && this.f18564c == 0) {
            InterestedNuxInterstitialController interestedNuxInterstitialController = (InterestedNuxInterstitialController) this.f18563b.a(InterestedNuxInterstitialController.a, InterestedNuxInterstitialController.class);
            if (interestedNuxInterstitialController == null || !Objects.equal(interestedNuxInterstitialController.b(), "3884")) {
                this.f18564c = 1;
                return;
            }
            this.f18564c = 2;
            view.post(new Runnable(this) {
                final /* synthetic */ InterestedNuxController f18561b;

                public void run() {
                    Tooltip tooltip = new Tooltip(view.getContext(), 2);
                    tooltip.b(2131233851);
                    tooltip.a(Position.BELOW);
                    tooltip.t = -1;
                    tooltip.d(true);
                    tooltip.a(view);
                    this.f18561b.f18562a.a();
                    this.f18561b.f18563b.a().a("3884");
                }
            });
        }
    }
}
