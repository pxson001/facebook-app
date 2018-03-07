package com.facebook.media.upload.video;

import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.upload.common.CancelHandler;
import com.facebook.media.upload.video.post.VideoUploadPostRequestManagerProvider;
import com.facebook.media.upload.video.receive.VideoUploadReceiveRequestManagerProvider;
import com.facebook.media.upload.video.start.VideoUploadStartRequestManagerProvider;

/* compiled from: jsonBlob */
public class VideoUploadSessionProvider extends AbstractAssistedProvider<VideoUploadSession> {
    public final VideoUploadSession m18874a(MediaLogger mediaLogger) {
        return new VideoUploadSession((VideoUploadStartRequestManagerProvider) getOnDemandAssistedProviderForStaticDi(VideoUploadStartRequestManagerProvider.class), (VideoUploadReceiveRequestManagerProvider) getOnDemandAssistedProviderForStaticDi(VideoUploadReceiveRequestManagerProvider.class), (VideoUploadPostRequestManagerProvider) getOnDemandAssistedProviderForStaticDi(VideoUploadPostRequestManagerProvider.class), new CancelHandler(FbUploaderSingletonWrapper.m15786a(this)), mediaLogger);
    }
}
