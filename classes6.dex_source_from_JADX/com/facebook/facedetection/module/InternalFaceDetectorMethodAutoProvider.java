package com.facebook.facedetection.module;

import com.facebook.facedetection.detector.InternalFaceDetector;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: null edge for keyword suggestions */
public class InternalFaceDetectorMethodAutoProvider extends AbstractProvider<InternalFaceDetector> {
    public Object get() {
        return FaceDetectionModule.m15586a((QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.a(this, 5762), IdBasedProvider.a(this, 5760));
    }
}
