package com.facebook.media.upload.video.post;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.Assisted;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.upload.MediaUploadParameters;
import com.facebook.media.upload.common.CancelHandler;
import com.facebook.media.upload.video.VideoUploadErrorHandler;
import com.facebook.media.upload.video.VideoUploadErrorHandlerProvider;
import com.facebook.media.upload.video.start.VideoUploadStartResponse;
import javax.inject.Inject;

/* compiled from: job_title */
public class VideoUploadPostRequestManager {
    private static final CallerContext f11938a = CallerContext.a(VideoUploadPostRequestManager.class);
    private AbstractSingleMethodRunner f11939b;
    private VideoUploadPostMethod f11940c = new VideoUploadPostMethod();
    private ApiMethodRunnerParams f11941d = new ApiMethodRunnerParams();
    private VideoUploadErrorHandlerProvider f11942e;
    private MediaLogger f11943f;

    @Inject
    public VideoUploadPostRequestManager(AbstractSingleMethodRunner abstractSingleMethodRunner, VideoUploadErrorHandlerProvider videoUploadErrorHandlerProvider, @Assisted MediaLogger mediaLogger) {
        this.f11939b = abstractSingleMethodRunner;
        this.f11942e = videoUploadErrorHandlerProvider;
        this.f11943f = mediaLogger;
    }

    public final Boolean m18877a(VideoUploadStartResponse videoUploadStartResponse, MediaUploadParameters mediaUploadParameters, CancelHandler cancelHandler) {
        Boolean bool;
        String a = videoUploadStartResponse.m18900a();
        VideoUploadPostParams videoUploadPostParams = new VideoUploadPostParams(a, mediaUploadParameters);
        VideoUploadErrorHandler a2 = this.f11942e.m18867a(cancelHandler);
        this.f11941d.a(cancelHandler.m18857a());
        this.f11943f.m18805c(a);
        while (true) {
            try {
                cancelHandler.m18858a("Before sending post request");
                bool = (Boolean) this.f11939b.a(this.f11940c, videoUploadPostParams, this.f11941d, f11938a);
                a2.m18866c();
                this.f11943f.m18807d(a);
                break;
            } catch (Exception e) {
                try {
                    a2.m18864a(e);
                } catch (Exception e2) {
                    this.f11943f.m18797a(a, e2);
                    throw e2;
                }
            }
        }
        return bool;
    }
}
