package com.facebook.feed.rows.styling;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: name='active_session_info' */
public class PaddingStyleConfigMethodAutoProvider extends AbstractProvider<PaddingStyleConfig> {
    public static EdgeToEdgePaddingStyleConfig m19183b(InjectorLike injectorLike) {
        return MultipleRowsFeedStylingModule.m19184a(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    public Object get() {
        return MultipleRowsFeedStylingModule.m19184a(ResourcesMethodAutoProvider.m6510a(this));
    }
}
