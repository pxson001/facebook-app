package com.facebook.config.application;

import com.facebook.inject.AbstractProvider;

/* compiled from: serializeCodeFormatter */
public class IntendedAudienceMethodAutoProvider extends AbstractProvider<IntendedAudience> {
    public Object get() {
        return FbAppTypeModule.c((FbAppType) getInstance(FbAppType.class));
    }
}
