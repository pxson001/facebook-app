package com.facebook.photos.upload.uploaders;

import android.util.Pair;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

/* compiled from: friend_requestees */
public class VideoUploaderExceptionHandler {
    private final MediaUploadCancelHandler f14557a;
    private ImmediateRetryPolicy f14558b;
    private final DefaultPhotoFlowLogger f14559c;
    private final ExceptionInterpreter f14560d = new ExceptionInterpreter(true);
    private final UploadBaseParams f14561e;
    private final UploadOperation f14562f;
    private VideoUploaderProgressListener f14563g;
    private FbObjectMapper f14564h;

    @AutoGenJsonDeserializer
    /* compiled from: friend_requestees */
    class InvalidOffsetErrorData {
        @JsonProperty("end_offset")
        public int endOffset = -1;
        @JsonProperty("start_offset")
        public int startOffset = -1;

        InvalidOffsetErrorData() {
        }
    }

    public VideoUploaderExceptionHandler(MediaUploadCancelHandler mediaUploadCancelHandler, ImmediateRetryPolicy immediateRetryPolicy, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, UploadOperation uploadOperation, VideoUploaderProgressListener videoUploaderProgressListener, FbObjectMapper fbObjectMapper) {
        Preconditions.checkNotNull(immediateRetryPolicy, "VideoUploaderExceptionHandler requires non null retry policy");
        this.f14557a = mediaUploadCancelHandler;
        this.f14558b = immediateRetryPolicy;
        this.f14559c = defaultPhotoFlowLogger;
        this.f14561e = uploadBaseParams;
        this.f14562f = uploadOperation;
        this.f14563g = videoUploaderProgressListener;
        this.f14564h = fbObjectMapper;
    }

    public final VideoUploaderExceptionHandler m22148a(ImmediateRetryPolicy immediateRetryPolicy) {
        Preconditions.checkNotNull(this.f14563g, "You probably wanted this to have a progress listener. If not remove this check :)");
        return new VideoUploaderExceptionHandler(this.f14557a, immediateRetryPolicy, this.f14559c, this.f14561e, this.f14562f, this.f14563g, this.f14564h);
    }

    public final void m22149a(VideoUploaderProgressListener videoUploaderProgressListener) {
        this.f14563g = videoUploaderProgressListener;
    }

    public final ImmediateRetryPolicy m22147a() {
        return this.f14558b;
    }

    public final Pair<Integer, Integer> m22146a(Exception exception, VideoUploadStage videoUploadStage, long j, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        this.f14560d.m19960a(exception);
        if (this.f14563g != null) {
            this.f14563g.m22159a(this.f14560d, videoUploadStage, chunkUploadProgressStatus);
        }
        if (videoUploadStage == VideoUploadStage.RECEIVE && j >= ((long) this.f14558b.mo1151b()) && this.f14563g != null) {
            this.f14563g.m22158a(this.f14560d);
        }
        this.f14557a.m22001a("while uploading video");
        int e = this.f14560d.mo1091e();
        if (e == 1 || e == 6000 || e == 100 || e == 200) {
            throw this.f14560d.m19959a();
        }
        Pair<Integer, Integer> create;
        Object obj;
        if (this.f14557a.m22007e()) {
            if (videoUploadStage == VideoUploadStage.START) {
                this.f14559c.m19936e(this.f14561e, this.f14562f);
            }
            this.f14557a.m22001a("Cancel video upload");
        }
        if (exception instanceof ApiException) {
            ApiErrorResult b = ((ApiException) exception).b();
            if (b != null && b.b() == 1363037) {
                InvalidOffsetErrorData invalidOffsetErrorData;
                try {
                    invalidOffsetErrorData = (InvalidOffsetErrorData) this.f14564h.a(b.d(), InvalidOffsetErrorData.class);
                } catch (Exception e2) {
                    invalidOffsetErrorData = null;
                }
                if (invalidOffsetErrorData != null && invalidOffsetErrorData.startOffset >= 0 && invalidOffsetErrorData.endOffset >= 0) {
                    create = Pair.create(Integer.valueOf(invalidOffsetErrorData.startOffset), Integer.valueOf(invalidOffsetErrorData.endOffset - invalidOffsetErrorData.startOffset));
                    obj = 1;
                    if (obj == null) {
                        this.f14558b.mo1147a(this.f14560d);
                    }
                    return create;
                }
            }
        }
        create = null;
        obj = null;
        if (obj == null) {
            this.f14558b.mo1147a(this.f14560d);
        }
        return create;
    }

    public final void m22150b() {
        this.f14558b.mo1146a();
    }

    public final int m22151c() {
        return this.f14558b.mo1151b();
    }
}
