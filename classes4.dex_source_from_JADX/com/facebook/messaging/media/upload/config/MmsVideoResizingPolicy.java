package com.facebook.messaging.media.upload.config;

import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoResizeConfig;

/* compiled from: mEnabledEventProviders */
public class MmsVideoResizingPolicy extends AbstractVideoResizingPolicy {
    protected final VideoResizeConfig m8999a() {
        return new VideoResizeConfig(480, 131072, 10.0f, 10);
    }
}
