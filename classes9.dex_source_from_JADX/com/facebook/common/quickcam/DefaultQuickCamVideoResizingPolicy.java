package com.facebook.common.quickcam;

import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoResizeConfig;

/* compiled from: proxy_login_params */
public class DefaultQuickCamVideoResizingPolicy extends AbstractVideoResizingPolicy {
    public static DefaultQuickCamVideoResizingPolicy m6335a(InjectorLike injectorLike) {
        return new DefaultQuickCamVideoResizingPolicy();
    }

    protected final VideoResizeConfig m6336a() {
        return new VideoResizeConfig(640, 655360, 30.0f, 1);
    }
}
