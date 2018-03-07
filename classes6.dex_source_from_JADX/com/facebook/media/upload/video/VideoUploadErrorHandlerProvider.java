package com.facebook.media.upload.video;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.media.upload.common.CancelHandler;

/* compiled from: keystroke_count */
public class VideoUploadErrorHandlerProvider extends AbstractAssistedProvider<VideoUploadErrorHandler> {
    public final VideoUploadErrorHandler m18867a(CancelHandler cancelHandler) {
        return new VideoUploadErrorHandler(cancelHandler, FbObjectMapperMethodAutoProvider.a(this));
    }
}
