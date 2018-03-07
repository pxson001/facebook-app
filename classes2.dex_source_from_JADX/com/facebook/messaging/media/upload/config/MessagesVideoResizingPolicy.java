package com.facebook.messaging.media.upload.config;

import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoResizeConfig;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: mRequests */
public class MessagesVideoResizingPolicy extends AbstractVideoResizingPolicy {
    private final XConfigReader f15476a;

    public static MessagesVideoResizingPolicy m22035b(InjectorLike injectorLike) {
        return new MessagesVideoResizingPolicy(XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public MessagesVideoResizingPolicy(XConfigReader xConfigReader) {
        this.f15476a = xConfigReader;
    }

    protected final VideoResizeConfig mo2853a() {
        return new VideoResizeConfig(this.f15476a.m2683a(MediaUploadXConfig.h, 640), this.f15476a.m2683a(MediaUploadXConfig.i, 720) * 1024, (float) this.f15476a.m2683a(MediaUploadXConfig.g, 30), this.f15476a.m2683a(MediaUploadXConfig.f, 2));
    }
}
