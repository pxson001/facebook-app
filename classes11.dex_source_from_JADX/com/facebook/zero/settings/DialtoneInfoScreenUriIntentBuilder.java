package com.facebook.zero.settings;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: Ljava/lang/Class */
public class DialtoneInfoScreenUriIntentBuilder extends UriIntentBuilder {
    @Inject
    public DialtoneInfoScreenUriIntentBuilder() {
        a(FBLinks.bS, DialtoneManualSwitcherInfoActivity.class);
    }

    public static DialtoneInfoScreenUriIntentBuilder m15115a(InjectorLike injectorLike) {
        return new DialtoneInfoScreenUriIntentBuilder();
    }
}
