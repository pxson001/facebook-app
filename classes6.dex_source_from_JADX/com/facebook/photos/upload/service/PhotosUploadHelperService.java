package com.facebook.photos.upload.service;

import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.service.FbService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.manager.UploadManager$RequestType;
import com.facebook.photos.upload.manager.UploadNotificationManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.ui.toaster.Toaster;

/* compiled from: ftp */
public class PhotosUploadHelperService extends FbService {
    private static final Class<?> f14254a = PhotosUploadHelperService.class;

    public final int m21933a(Intent intent, int i, int i2) {
        if (intent != null) {
            UploadOperation uploadOperation;
            InjectorLike injectorLike = FbInjector.get(this);
            try {
                uploadOperation = (UploadOperation) intent.getParcelableExtra("uploadOp");
            } catch (Exception e) {
                Exception exception = e;
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)).b(f14254a.getSimpleName(), "can't read operation: " + exception.getClass().getSimpleName() + ", " + exception.getMessage());
                uploadOperation = null;
            }
            if (uploadOperation != null) {
                String action = intent.getAction();
                if (action != null && action.startsWith("com.facebook.photos.upload.service.retry")) {
                    uploadOperation.m21509N();
                    UploadManager.a(injectorLike).c(uploadOperation, UploadManager$RequestType.UserRetry, "User retry");
                    Toaster.a(this, 2131236062);
                } else if (action == null || !action.startsWith("com.facebook.photos.upload.service.success")) {
                    ((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)).b(f14254a.getSimpleName(), "invalid action for " + uploadOperation.m21509N() + ": " + action);
                } else {
                    action = intent.getStringExtra("success_result");
                    if (action != null) {
                        UploadNotificationManager.m21400a(injectorLike).m21416a(uploadOperation, action);
                    }
                }
            }
        }
        stopSelf(i2);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
