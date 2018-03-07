package com.facebook.photos.creativecam.ui;

import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraPreviewView;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.8;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.ui.toaster.Toaster;
import java.util.concurrent.ExecutorService;

/* compiled from: state_current_privacy */
public class CameraPreviewControllerProvider extends AbstractAssistedProvider<CameraPreviewController> {
    public final CameraPreviewController m2358a(8 8, CameraPreviewView cameraPreviewView, FocusView focusView, CameraFacing cameraFacing, CreativeCamCaptureButton creativeCamCaptureButton, CreativeEditingLogger creativeEditingLogger, CreativeCamSource creativeCamSource) {
        return new CameraPreviewController(8, cameraPreviewView, focusView, cameraFacing, creativeCamCaptureButton, creativeEditingLogger, creativeCamSource, NativeImageProcessor.a(this), IdBasedSingletonScopeProvider.b(this, 2301), BitmapUtils.a(this), IdBasedSingletonScopeProvider.b(this, 600), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), DefaultAndroidThreadUtil.a(this), Toaster.a(this), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
