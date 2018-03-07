package com.facebook.katana.urimap;

import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.customsettings.CustomSettingsActivity;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: timeline_story_like_fail */
public class TermsAndPoliciesIntentUriBuilder extends UriIntentBuilder {
    public static TermsAndPoliciesIntentUriBuilder m1270a(InjectorLike injectorLike) {
        return new TermsAndPoliciesIntentUriBuilder();
    }

    @Inject
    public TermsAndPoliciesIntentUriBuilder() {
        Bundle bundle = new Bundle();
        bundle.putInt("extra_layout", 2130907375);
        a(FBLinks.cG, CustomSettingsActivity.class, bundle);
    }
}
