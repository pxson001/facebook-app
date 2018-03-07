package com.facebook.loom.upload;

import com.facebook.inject.AbstractProvider;
import com.facebook.loom.core.BackgroundUploadService;

/* compiled from: getOrCreateThreadId failed with uri  */
public class BackgroundUploadServiceMethodAutoProvider extends AbstractProvider<BackgroundUploadService> {
    public Object get() {
        return LoomUploadModule.m11580a((BackgroundUploadServiceImplProvider) getOnDemandAssistedProviderForStaticDi(BackgroundUploadServiceImplProvider.class));
    }
}
