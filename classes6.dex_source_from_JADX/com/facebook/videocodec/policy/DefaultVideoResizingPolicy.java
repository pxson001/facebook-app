package com.facebook.videocodec.policy;

import com.facebook.inject.InjectorLike;

/* compiled from: retail_carrier */
public class DefaultVideoResizingPolicy extends AbstractVideoResizingPolicy {
    public static DefaultVideoResizingPolicy m8245a(InjectorLike injectorLike) {
        return new DefaultVideoResizingPolicy();
    }

    protected final VideoResizeConfig m8246a() {
        return VideoResizeConfig.f5563e;
    }
}
