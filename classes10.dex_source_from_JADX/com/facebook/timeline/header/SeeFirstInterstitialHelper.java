package com.facebook.timeline.header;

import android.view.View;
import com.facebook.fbui.widget.inlineactionbar.InlineActionButton;
import com.facebook.feed.seefirst.seefirstnux.SeeFirstNuxManager;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.nux.interstitial.SeeFirstPromptNuxController;
import com.facebook.timeline.actionbar.TimelineActionBar;
import javax.inject.Inject;

/* compiled from: friends_nearby/ */
public class SeeFirstInterstitialHelper {
    public InterstitialManager f11317a;
    public SeeFirstNuxManager f11318b;
    public boolean f11319c = false;

    /* compiled from: friends_nearby/ */
    public class C16401 implements Runnable {
        final /* synthetic */ TimelineActionBar f11314a;
        final /* synthetic */ SeeFirstPromptNuxController f11315b;
        final /* synthetic */ SeeFirstInterstitialHelper f11316c;

        public C16401(SeeFirstInterstitialHelper seeFirstInterstitialHelper, TimelineActionBar timelineActionBar, SeeFirstPromptNuxController seeFirstPromptNuxController) {
            this.f11316c = seeFirstInterstitialHelper;
            this.f11314a = timelineActionBar;
            this.f11315b = seeFirstPromptNuxController;
        }

        public void run() {
            for (int i = 0; i < this.f11314a.getChildCount(); i++) {
                View childAt = this.f11314a.getChildAt(i);
                if (childAt instanceof InlineActionButton) {
                    InlineActionButton inlineActionButton = (InlineActionButton) childAt;
                    if (inlineActionButton.getText().equals(this.f11314a.getContext().getString(2131234865))) {
                        SeeFirstPromptNuxController.a(inlineActionButton);
                        this.f11316c.f11317a.a().a(this.f11315b.b());
                        this.f11316c.f11318b.b();
                        this.f11316c.f11319c = true;
                        return;
                    }
                }
            }
        }
    }

    public static SeeFirstInterstitialHelper m11405b(InjectorLike injectorLike) {
        return new SeeFirstInterstitialHelper(InterstitialManager.a(injectorLike), SeeFirstNuxManager.a(injectorLike));
    }

    @Inject
    public SeeFirstInterstitialHelper(InterstitialManager interstitialManager, SeeFirstNuxManager seeFirstNuxManager) {
        this.f11317a = interstitialManager;
        this.f11318b = seeFirstNuxManager;
    }
}
