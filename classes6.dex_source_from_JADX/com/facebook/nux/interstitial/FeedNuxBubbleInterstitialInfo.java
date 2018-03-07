package com.facebook.nux.interstitial;

import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.nux.NuxBubbleManager.NuxDelegate;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: isOxygenEnabled */
public enum FeedNuxBubbleInterstitialInfo {
    SAVE_NUX(SaveNuxBubbleInterstitialController.class, SaveNuxBubbleDelegate.class, "2447", FeedPrefKeys.k, "NUX bubble for the save button"),
    PAGE_STORY_ADMIN_ATTRIBUTION_NUX(PageStoryAdminAtrributionNuxInterstitialController.class, PageStoryAdminAttributionNuxDelegate.class, "2449", FeedPrefKeys.m, "NUX bubble for admin attribution on Page stories"),
    MUSIC_STORY_NUX(MusicPreviewNuxBubbleInterstitialController.class, MusicPreviewNuxBubbleDelegate.class, "2438", FeedPrefKeys.r, "NUX bubble for music preview stories"),
    FOLLOW_VIDEOS_BUTTON_NUX(FollowVideosButtonNuxBubbleInterstitialController.class, FollowVideosNuxBubbleDelegate.class, "4141", FeedPrefKeys.l, "NUX bubble for follow videos button");
    
    public final Class<? extends FeedNuxBubbleInterstitialController> controllerClass;
    public final String description;
    public final String interstitialId;
    public final Class<? extends NuxDelegate> nuxDelegate;
    public final PrefKey prefKey;

    private FeedNuxBubbleInterstitialInfo(Class<? extends FeedNuxBubbleInterstitialController> cls, Class<? extends NuxDelegate> cls2, String str, PrefKey prefKey, String str2) {
        this.controllerClass = cls;
        this.nuxDelegate = cls2;
        this.interstitialId = str;
        this.prefKey = prefKey;
        this.description = str2;
    }

    public static FeedNuxBubbleInterstitialInfo forControllerClass(Class<? extends FeedNuxBubbleInterstitialController> cls) {
        for (FeedNuxBubbleInterstitialInfo feedNuxBubbleInterstitialInfo : values()) {
            if (feedNuxBubbleInterstitialInfo.controllerClass == cls) {
                return feedNuxBubbleInterstitialInfo;
            }
        }
        throw new IllegalArgumentException("Unknown controller class: " + cls);
    }

    public static FeedNuxBubbleInterstitialInfo forNuxDelegate(Class<? extends NuxDelegate> cls) {
        for (FeedNuxBubbleInterstitialInfo feedNuxBubbleInterstitialInfo : values()) {
            if (feedNuxBubbleInterstitialInfo.nuxDelegate == cls) {
                return feedNuxBubbleInterstitialInfo;
            }
        }
        throw new IllegalArgumentException("Unknown nux delegate class: " + cls);
    }
}
