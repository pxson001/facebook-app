package com.facebook.common.quickcam;

import android.hardware.Camera;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: proxyLogin */
public class FocusOverlayManagerProvider extends AbstractAssistedProvider<FocusOverlayManager> {
    public final FocusOverlayManager m6349a(Camera camera, Boolean bool) {
        return new FocusOverlayManager(camera, bool, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), CameraUtil.m6329b((InjectorLike) this));
    }
}
