package com.facebook.nux.interstitial;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: isLazy */
public class PageStoryAdminAttributionNuxDelegate extends BaseNuxDelegate {
    private static PageStoryAdminAttributionNuxDelegate m19153b(InjectorLike injectorLike) {
        return new PageStoryAdminAttributionNuxDelegate((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InterstitialManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageStoryAdminAttributionNuxDelegate(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, InterstitialManager interstitialManager, Clock clock) {
        super(objectMapper, abstractFbErrorReporter, fbSharedPreferences, interstitialManager, clock);
    }
}
