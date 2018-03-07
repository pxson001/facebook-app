package com.facebook.facerec.module;

import com.facebook.facerec.manager.FaceRecManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: node_type */
public class FaceRecManagerMethodAutoProvider extends AbstractProvider<FaceRecManager> {
    public Object get() {
        return FaceRecognitionModule.m15656a(IdBasedSingletonScopeProvider.a(this, 3966), IdBasedProvider.a(this, 5767), IdBasedProvider.a(this, 5769));
    }
}
