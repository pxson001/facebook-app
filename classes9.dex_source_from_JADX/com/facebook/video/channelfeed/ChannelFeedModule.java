package com.facebook.video.channelfeed;

import android.content.res.Resources;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: t._ROWID_ AS _id */
public class ChannelFeedModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForChannelFeed
    static EdgeToEdgeFooterBackgroundStyleConfig m2312a(Resources resources, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        return new ChannelFeedFooterBackgroundStyleConfig(defaultPaddingStyleResolver, resources);
    }

    @ProviderMethod
    @ForMultiShareChannelFeed
    public static EdgeToEdgeFooterBackgroundStyleConfig m2313b(Resources resources, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        return new MultiShareChannelFeedFooterBackgroundStyleConfig(defaultPaddingStyleResolver, resources);
    }
}
