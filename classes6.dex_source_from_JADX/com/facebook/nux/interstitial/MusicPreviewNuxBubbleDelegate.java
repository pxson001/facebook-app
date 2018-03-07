package com.facebook.nux.interstitial;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: isMatched */
public class MusicPreviewNuxBubbleDelegate extends BaseNuxDelegate {
    @Inject
    public MusicPreviewNuxBubbleDelegate(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, InterstitialManager interstitialManager, Clock clock) {
        super(objectMapper, abstractFbErrorReporter, fbSharedPreferences, interstitialManager, clock);
    }
}
