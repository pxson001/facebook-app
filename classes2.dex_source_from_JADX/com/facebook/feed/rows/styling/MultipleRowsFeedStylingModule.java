package com.facebook.feed.rows.styling;

import android.content.res.Resources;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: name=' */
public class MultipleRowsFeedStylingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static EdgeToEdgePaddingStyleConfig m19184a(Resources resources) {
        return new EdgeToEdgePaddingStyleConfig(resources);
    }
}
