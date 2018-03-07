package com.facebook.composer.capability;

import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: cover_photo_fbid */
public class ComposerPostCompositionViewCapability {
    public final Lazy<QeAccessor> f16699a;

    @Inject
    public ComposerPostCompositionViewCapability(Lazy<QeAccessor> lazy) {
        this.f16699a = lazy;
    }
}
