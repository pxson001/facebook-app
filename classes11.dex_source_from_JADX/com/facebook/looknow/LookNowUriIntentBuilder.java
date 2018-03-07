package com.facebook.looknow;

import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: utm_source */
public class LookNowUriIntentBuilder extends UriIntentBuilder {
    public static LookNowUriIntentBuilder m294a(InjectorLike injectorLike) {
        return new LookNowUriIntentBuilder();
    }

    @Inject
    public LookNowUriIntentBuilder() {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eZ), FragmentChromeActivity.class, ContentFragmentType.LOOK_NOW_FRAGMENT.ordinal());
    }
}
