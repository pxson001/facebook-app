package com.facebook.facedetection.module;

import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.NativeImageLibraries;
import com.facebook.debug.log.BLog;
import com.facebook.device.CpuCapabilities;
import com.facebook.facedetection.FaceDetectionAnalyticsLogger;
import com.facebook.facedetection.FaceDetectionAssetDownloader;
import com.facebook.facedetection.detector.InternalFaceDetector;
import com.facebook.facedetection.detector.MacerFaceDetector;
import com.facebook.facedetection.detector.NativeFaceDetector;
import com.facebook.facerec.abtest.ExperimentsForFaceRecAbTestModule;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: null edge or node */
public class FaceDetectionModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static InternalFaceDetector m15586a(QeAccessor qeAccessor, Provider<NativeFaceDetector> provider, Provider<MacerFaceDetector> provider2) {
        boolean a = qeAccessor.a(ExperimentsForFaceRecAbTestModule.f9834a, false);
        Boolean.valueOf(a);
        return a ? (InternalFaceDetector) provider2.get() : (InternalFaceDetector) provider.get();
    }

    @ProviderMethod
    @Singleton
    static NativeFaceDetector m15587a(FaceDetectionAssetDownloader faceDetectionAssetDownloader, CpuCapabilities cpuCapabilities, FaceDetectionAnalyticsLogger faceDetectionAnalyticsLogger, ImageResizer imageResizer, NativeImageLibraries nativeImageLibraries, ExecutorService executorService, QeAccessor qeAccessor, Boolean bool) {
        try {
            return new NativeFaceDetector(bool, faceDetectionAssetDownloader, cpuCapabilities, faceDetectionAnalyticsLogger, imageResizer, nativeImageLibraries, executorService, qeAccessor);
        } catch (Throwable e) {
            BLog.b("FaceDetectionModule", "Unable to instantiate NativeFaceDetector", e);
            return null;
        }
    }
}
