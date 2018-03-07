package com.facebook.katana.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.SecureContextHelper;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.fragment.FbChromeFragment;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionInterstitialController;
import com.facebook.quickpromotion.ui.QuickPromotionThreadListInterstitialController;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SCROLLING */
public final class TabQuickPromotionLauncher {
    private final Context f24303a;
    private final SecureContextHelper f24304b;
    private final InterstitialManager f24305c;
    private final ComponentName f24306d;

    /* compiled from: SCROLLING */
    public /* synthetic */ class C34891 {
        public static final /* synthetic */ int[] f24302a = new int[TabTag.values().length];

        static {
            try {
                f24302a[TabTag.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24302a[TabTag.Notifications.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24302a[TabTag.FriendRequests.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24302a[TabTag.Bookmark.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public TabQuickPromotionLauncher(Context context, SecureContextHelper secureContextHelper, InterstitialManager interstitialManager, @FragmentChromeActivity ComponentName componentName) {
        this.f24303a = context;
        this.f24304b = secureContextHelper;
        this.f24305c = interstitialManager;
        this.f24306d = componentName;
    }

    public final void m25601a(TabTag tabTag, @Nullable FbChromeFragment fbChromeFragment) {
        if (fbChromeFragment == null || !(fbChromeFragment.aq() instanceof QuickPromotionFragment)) {
            InterstitialTrigger interstitialTrigger;
            switch (C34891.f24302a[tabTag.ordinal()]) {
                case 1:
                    interstitialTrigger = new InterstitialTrigger(Action.TAB_NAVIGATION_FEED);
                    break;
                case 2:
                    interstitialTrigger = new InterstitialTrigger(Action.TAB_NAVIGATION_NOTIFICATIONS);
                    break;
                case 3:
                    interstitialTrigger = new InterstitialTrigger(Action.TAB_NAVIGATION_FRIEND_REQUESTS);
                    break;
                case 4:
                    interstitialTrigger = new InterstitialTrigger(Action.TAB_NAVIGATION_MORE);
                    break;
                default:
                    interstitialTrigger = null;
                    break;
            }
            InterstitialTrigger interstitialTrigger2 = interstitialTrigger;
            if (interstitialTrigger2 != null) {
                m25600a(interstitialTrigger2, tabTag);
            }
        }
    }

    private boolean m25600a(InterstitialTrigger interstitialTrigger, TabTag tabTag) {
        QuickPromotionController quickPromotionController = (QuickPromotionController) this.f24305c.a(interstitialTrigger, QuickPromotionController.class);
        if (quickPromotionController == null) {
            return false;
        }
        Intent a;
        if (QuickPromotionInterstitialController.a.equals(quickPromotionController.b()) || "2610".equals(quickPromotionController.b())) {
            a = quickPromotionController.a(this.f24303a);
            if (a == null) {
                return false;
            }
            this.f24304b.a(a, this.f24303a);
            return true;
        } else if (!QuickPromotionThreadListInterstitialController.a.equals(quickPromotionController.b())) {
            return false;
        } else {
            a = quickPromotionController.a(this.f24303a);
            if (a == null) {
                return false;
            }
            a.setComponent(this.f24306d);
            a.putExtra("target_fragment", ContentFragmentType.QUICK_PROMOTION_FRAGMENT.ordinal());
            a.putExtra("target_tab_name", tabTag.name());
            this.f24304b.a(a, this.f24303a);
            return true;
        }
    }
}
