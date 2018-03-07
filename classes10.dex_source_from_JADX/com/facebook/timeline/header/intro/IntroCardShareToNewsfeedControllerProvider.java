package com.facebook.timeline.header.intro;

import android.content.Context;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.header.IntroCardAbstractInterstitialController;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedController.FeedSharingSwitchNuxProvider;

/* compiled from: fetch_nearby_friends_contacts_tab */
public class IntroCardShareToNewsfeedControllerProvider extends AbstractAssistedProvider<IntroCardShareToNewsfeedController> {
    public final IntroCardShareToNewsfeedController m11889a(Context context, IntroCardAbstractInterstitialController introCardAbstractInterstitialController, FeedSharingSwitchNuxProvider feedSharingSwitchNuxProvider) {
        return new IntroCardShareToNewsfeedController(context, introCardAbstractInterstitialController, feedSharingSwitchNuxProvider, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), RTLUtil.a(this));
    }
}
