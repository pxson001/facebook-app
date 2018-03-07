package com.facebook.facecast;

import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import java.io.File;
import javax.inject.Inject;

/* compiled from: buildNativeModuleRegistry */
public class LiveStreamDvrUploader {
    private static final String f18058a = LiveStreamDvrUploader.class.getName();
    private final UploadOperationFactory f18059b;
    private final UploadManager f18060c;

    public static LiveStreamDvrUploader m21892b(InjectorLike injectorLike) {
        return new LiveStreamDvrUploader(UploadOperationFactory.b(injectorLike), UploadManager.a(injectorLike));
    }

    @Inject
    public LiveStreamDvrUploader(UploadOperationFactory uploadOperationFactory, UploadManager uploadManager) {
        this.f18059b = uploadOperationFactory;
        this.f18060c = uploadManager;
    }

    public final void m21893a(File file, String str) {
        try {
            this.f18060c.a(this.f18059b.a(file.getAbsolutePath(), str));
        } catch (Throwable e) {
            BLog.b(f18058a, "Failed to Upload DVR ", e);
        }
    }

    public static LiveStreamDvrUploader m21891a(InjectorLike injectorLike) {
        return m21892b(injectorLike);
    }
}
