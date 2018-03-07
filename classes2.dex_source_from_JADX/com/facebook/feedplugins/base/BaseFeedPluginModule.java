package com.facebook.feedplugins.base;

import android.content.res.Resources;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: is_perf_testing */
public class BaseFeedPluginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static EdgeToEdgeFooterBackgroundStyleConfig m26664a(Resources resources, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        return new EdgeToEdgeFooterBackgroundStyleConfig(defaultPaddingStyleResolver, resources);
    }
}
