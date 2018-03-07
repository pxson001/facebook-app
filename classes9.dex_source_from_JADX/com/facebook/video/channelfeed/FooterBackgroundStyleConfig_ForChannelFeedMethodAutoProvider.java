package com.facebook.video.channelfeed;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: success_update_pickup_location */
public class FooterBackgroundStyleConfig_ForChannelFeedMethodAutoProvider extends AbstractProvider<FooterBackgroundStyleConfig> {
    public static EdgeToEdgeFooterBackgroundStyleConfig m2520b(InjectorLike injectorLike) {
        return ChannelFeedModule.m2312a(ResourcesMethodAutoProvider.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public Object get() {
        return ChannelFeedModule.m2312a(ResourcesMethodAutoProvider.a(this), DefaultPaddingStyleResolver.a(this));
    }
}
