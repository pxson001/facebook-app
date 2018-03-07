package com.facebook.friending.jewel;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.friending.jewel.adapter.FriendingJewelAdapter;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: finished_loading_raw_time */
public class FriendingJewelImagePreloaderProvider extends AbstractAssistedProvider<FriendingJewelImagePreloader> {
    public final FriendingJewelImagePreloader m14876a(CallerContext callerContext, ScrollingViewProxy scrollingViewProxy, FriendingJewelAdapter friendingJewelAdapter, int i) {
        return new FriendingJewelImagePreloader(ImagePipelineMethodAutoProvider.a(this), callerContext, scrollingViewProxy, friendingJewelAdapter, i);
    }
}
