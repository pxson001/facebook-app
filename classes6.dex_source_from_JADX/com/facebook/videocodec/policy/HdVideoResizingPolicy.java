package com.facebook.videocodec.policy;

import com.facebook.inject.InjectorLike;

/* compiled from: retail_cancellation */
public class HdVideoResizingPolicy extends AbstractVideoResizingPolicy {
    private VideoResizeConfig f5561a = VideoResizeConfig.f5563e;

    public static HdVideoResizingPolicy m8247a(InjectorLike injectorLike) {
        return new HdVideoResizingPolicy();
    }

    protected final VideoResizeConfig m8248a() {
        return this.f5561a;
    }

    public final void m8249a(int i) {
        this.f5561a = new VideoResizeConfig(1280, i * 1024, 30.0f, 10);
    }
}
