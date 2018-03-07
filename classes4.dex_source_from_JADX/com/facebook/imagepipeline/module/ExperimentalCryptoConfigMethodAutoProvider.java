package com.facebook.imagepipeline.module;

import com.facebook.imagepipeline.internal.ExperimentalCryptoConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: secondary_action */
public class ExperimentalCryptoConfigMethodAutoProvider extends AbstractProvider<ExperimentalCryptoConfig> {
    public Object get() {
        return ImagePipelineModule.a((QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
