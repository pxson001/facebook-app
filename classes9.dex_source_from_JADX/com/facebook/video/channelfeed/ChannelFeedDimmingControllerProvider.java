package com.facebook.video.channelfeed;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tax_info */
public class ChannelFeedDimmingControllerProvider extends AbstractAssistedProvider<ChannelFeedDimmingController> {
    public final <V> ChannelFeedDimmingController<V> m2138a(String str, float f) {
        return new ChannelFeedDimmingController(str, f, ChannelFeedFocusDimmingManager.m2177a((InjectorLike) this));
    }
}
