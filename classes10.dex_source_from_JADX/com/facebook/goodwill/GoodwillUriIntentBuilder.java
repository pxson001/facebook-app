package com.facebook.goodwill;

import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.goodwill.composer.GoodwillVideoComposerLauncher;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: WHOLE */
public class GoodwillUriIntentBuilder extends UriIntentBuilder {
    public static GoodwillUriIntentBuilder m21992a(InjectorLike injectorLike) {
        return new GoodwillUriIntentBuilder();
    }

    @Inject
    public GoodwillUriIntentBuilder() {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.ek, "{source unknown}", "{campaign_id none}", "{story_id none}"), FragmentChromeActivity.class, ContentFragmentType.THROWBACK_FEED_FRAGMENT.ordinal());
        a(StringFormatUtil.a(FBLinks.es, new Object[]{"{campaign_id}", "{campaign_type}", "{source}", "{direct_source}", "{share_preview}", "{default_share_message}", "{placeholder_text}"}), GoodwillVideoComposerLauncher.class);
        Bundle bundle = new Bundle();
        bundle.putString("campaign_type", "friends_day_2016");
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eq, "{campaign_id}", "{source}", "{share_preview}", "{default_share_message}"), GoodwillVideoComposerLauncher.class, bundle);
    }
}
