package com.facebook.facecast;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: button_res */
public class FacecastCameraProvider extends AbstractAssistedProvider<FacecastCamera> {
    public final FacecastCamera m21853a(int i) {
        return new FacecastCamera(FacecastAnalyticsLogger.m21959a((InjectorLike) this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), i);
    }
}
