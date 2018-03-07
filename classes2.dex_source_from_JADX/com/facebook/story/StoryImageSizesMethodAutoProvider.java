package com.facebook.story;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;

/* compiled from: scan_duration_ms */
public class StoryImageSizesMethodAutoProvider extends AbstractProvider<StoryImageSizes> {
    public static StoryImageSizes m10232b(InjectorLike injectorLike) {
        return StoryModule.m10233a(ResourcesMethodAutoProvider.m6510a(injectorLike), (Context) injectorLike.getInstance(Context.class), TabletExperimentConfiguration.m7856a(injectorLike), TabletColumnLayoutManager.m8710a(injectorLike), Boolean_IsTabletMethodAutoProvider.m7864a(injectorLike));
    }

    public Object get() {
        return StoryModule.m10233a(ResourcesMethodAutoProvider.m6510a(this), (Context) getInstance(Context.class), TabletExperimentConfiguration.m7856a(this), TabletColumnLayoutManager.m8710a((InjectorLike) this), Boolean_IsTabletMethodAutoProvider.m7864a(this));
    }
}
