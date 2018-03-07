package com.facebook.facerec.module;

import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: non_chunked */
public class FaceBoxPrioritizerMethodAutoProvider extends AbstractProvider<FaceBoxPrioritizer> {
    public Object get() {
        return FaceRecognitionModule.m15659b(IdBasedSingletonScopeProvider.a(this, 3966), IdBasedProvider.a(this, 5766), IdBasedProvider.a(this, 5768));
    }
}
