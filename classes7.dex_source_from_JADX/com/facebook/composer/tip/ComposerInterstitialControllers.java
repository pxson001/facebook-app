package com.facebook.composer.tip;

import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: composer_stickers_enter_store */
public enum ComposerInterstitialControllers {
    MINUTIAE_RESHARE_NUX(MinutiaeNuxBubbleInterstitialController.class, "2923", MinutiaePrefKeys.f1615c, "Minutiae Reshare NUX"),
    RIDGE_NUX(RidgeNuxBubbleInterstitialController.class, "2377", MinutiaePrefKeys.f1621i, "Ridge NUX"),
    PUBLISH_MODE_SELECTOR_NUX(PublishModeSelectorNuxBubbleInterstitialController.class, "2752", ComposerPrefKeys.h, "Publish Mode Selector NUX"),
    TOPIC_COMPOSER_NUX(TopicComposerNuxInterstitialController.class, "4096", ComposerPrefKeys.u, "Topic Composer NUX"),
    FEED_ONLY_POST_NUX(FeedOnlyPostInterstitialController.class, "4155", ComposerPrefKeys.w, "Feed-only post NUX");
    
    public final Class<? extends ComposerInterstitialTip> controllerClass;
    public final String description;
    public final String interstitialId;
    public final PrefKey prefKey;

    private ComposerInterstitialControllers(Class<? extends ComposerInterstitialTip> cls, String str, PrefKey prefKey, String str2) {
        this.controllerClass = cls;
        this.interstitialId = str;
        this.prefKey = prefKey;
        this.description = str2;
    }

    public static ComposerInterstitialControllers forControllerClass(Class<? extends ComposerInterstitialTip> cls) {
        for (ComposerInterstitialControllers composerInterstitialControllers : values()) {
            if (composerInterstitialControllers.controllerClass == cls) {
                return composerInterstitialControllers;
            }
        }
        throw new IllegalArgumentException("Unknown controller class: " + cls);
    }
}
