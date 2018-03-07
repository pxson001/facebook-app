package com.facebook.zero.settings;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: Ljava/io/File; */
public class FreeFacebookSettingsUriIntentBuilder extends UriIntentBuilder {
    @Inject
    public FreeFacebookSettingsUriIntentBuilder() {
        a(FBLinks.bR, FreeFacebookSettingsActivity.class);
    }

    public static FreeFacebookSettingsUriIntentBuilder m15155a(InjectorLike injectorLike) {
        return new FreeFacebookSettingsUriIntentBuilder();
    }
}
