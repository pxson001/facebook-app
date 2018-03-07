package com.facebook.feedplugins.base;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleConfig;
import com.facebook.inject.AbstractProvider;

/* compiled from: newcomer_audience_seen_selector */
public class FooterBackgroundStyleConfigMethodAutoProvider extends AbstractProvider<FooterBackgroundStyleConfig> {
    public Object get() {
        return BaseFeedPluginModule.a(ResourcesMethodAutoProvider.a(this), DefaultPaddingStyleResolver.a(this));
    }
}
