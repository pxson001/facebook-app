package com.facebook.photos.upload.uploaders;

import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.VideoUploadSlowEvent;
import com.facebook.photos.upload.operation.UploadOperation;
import java.util.concurrent.TimeUnit;

/* compiled from: friend_request_send */
public class VideoUploaderSlowNetworkHandler {
    public static void m22167a(UploadOperation uploadOperation, MediaUploadEventBus mediaUploadEventBus, long j, float f) {
        if (f != 0.0f) {
            long toHours = TimeUnit.MILLISECONDS.toHours((long) (((float) j) / f));
            if (toHours >= 48 && !uploadOperation.f13769R) {
                uploadOperation.f13769R = true;
                mediaUploadEventBus.a(new VideoUploadSlowEvent(uploadOperation, BaseMediaUploadEvent$Status.UPLOADING, -1, toHours));
            }
        }
    }
}
