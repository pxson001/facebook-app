package com.facebook.timeline.header;

import android.view.View;
import com.facebook.fbui.widget.inlineactionbar.InlineActionButton;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.timeline.actionbar.TimelineActionBar;
import com.facebook.timeline.actionbar.TimelineActionBarManageButtonNuxController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import javax.inject.Inject;

/* compiled from: friends_nearby_dashboard_map_impression */
public class ManageInterstitialHelper {
    public final InterstitialManager f11293a;

    public static ManageInterstitialHelper m11395b(InjectorLike injectorLike) {
        return new ManageInterstitialHelper(InterstitialManager.a(injectorLike));
    }

    @Inject
    public ManageInterstitialHelper(InterstitialManager interstitialManager) {
        this.f11293a = interstitialManager;
    }

    public final void m11396a(final TimelineActionBar timelineActionBar, final TimelineHeaderUserData timelineHeaderUserData) {
        try {
            final TimelineActionBarManageButtonNuxController timelineActionBarManageButtonNuxController = (TimelineActionBarManageButtonNuxController) this.f11293a.a("3226", TimelineActionBarManageButtonNuxController.class);
            timelineActionBar.post(new Runnable(this) {
                final /* synthetic */ ManageInterstitialHelper f11292d;

                public void run() {
                    for (int i = 0; i < timelineActionBar.getChildCount(); i++) {
                        View childAt = timelineActionBar.getChildAt(i);
                        if (childAt instanceof InlineActionButton) {
                            InlineActionButton inlineActionButton = (InlineActionButton) childAt;
                            if (inlineActionButton.getText().equals(inlineActionButton.getContext().getString(2131234869))) {
                                timelineActionBarManageButtonNuxController.f10300d = true;
                                ManageInterstitialHelper manageInterstitialHelper = this.f11292d;
                                TimelineHeaderUserData timelineHeaderUserData = timelineHeaderUserData;
                                if (inlineActionButton != null) {
                                    TimelineActionBarManageButtonNuxController timelineActionBarManageButtonNuxController = (TimelineActionBarManageButtonNuxController) manageInterstitialHelper.f11293a.a(new InterstitialTrigger(Action.TIMELINE), TimelineActionBarManageButtonNuxController.class);
                                    if (timelineActionBarManageButtonNuxController != null) {
                                        timelineActionBarManageButtonNuxController.m10433a(inlineActionButton, timelineHeaderUserData.y());
                                        manageInterstitialHelper.f11293a.a().a(timelineActionBarManageButtonNuxController.m10435b());
                                        timelineActionBarManageButtonNuxController.m10437d();
                                    }
                                }
                                timelineActionBarManageButtonNuxController.f10300d = false;
                            }
                        }
                    }
                    timelineActionBarManageButtonNuxController.f10300d = false;
                }
            });
        } catch (Exception e) {
        }
    }
}
