package com.facebook.media.upload.video;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.Assisted;
import com.facebook.media.upload.common.CancelHandler;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.inject.Inject;

/* compiled from: keyword */
public class VideoUploadErrorHandler {
    private int f11918a;
    private CancelHandler f11919b;
    private FbObjectMapper f11920c;

    @AutoGenJsonDeserializer
    /* compiled from: keyword */
    class InvalidOffsetErrorData {
        @JsonProperty("end_offset")
        public long endOffset = -1;
        @JsonProperty("start_offset")
        public long startOffset = -1;

        InvalidOffsetErrorData() {
        }
    }

    @Inject
    public VideoUploadErrorHandler(@Assisted CancelHandler cancelHandler, FbObjectMapper fbObjectMapper) {
        this.f11919b = cancelHandler;
        this.f11920c = fbObjectMapper;
        m18865b();
    }

    public final int m18863a() {
        return this.f11918a;
    }

    public final void m18865b() {
        this.f11918a = 0;
    }

    public final void m18866c() {
        m18865b();
    }

    public final void m18864a(Exception exception) {
        this.f11919b.m18858a("Start of exception handler");
        ExceptionInterpreter exceptionInterpreter = new ExceptionInterpreter(exception);
        int e = exceptionInterpreter.mo1091e();
        if (e == 1 || e == 6000 || e == 100 || e == 200) {
            throw exceptionInterpreter.m19959a();
        }
        if (exception instanceof ApiException) {
            ApiErrorResult b = ((ApiException) exception).b();
            if (b != null && b.b() == 1363037) {
                InvalidOffsetErrorData invalidOffsetErrorData = null;
                try {
                    invalidOffsetErrorData = (InvalidOffsetErrorData) this.f11920c.a(b.d(), InvalidOffsetErrorData.class);
                } catch (Exception e2) {
                }
                if (invalidOffsetErrorData != null && invalidOffsetErrorData.startOffset >= 0 && invalidOffsetErrorData.endOffset >= 0) {
                    throw new InvalidOffsetException(exception, invalidOffsetErrorData.startOffset, invalidOffsetErrorData.endOffset);
                }
            }
        }
        if (exceptionInterpreter.m19969j()) {
            e = this.f11918a;
            this.f11918a = e + 1;
            if (e < 3) {
                Thread.sleep(m18862d());
                return;
            }
            throw exceptionInterpreter.m19959a();
        }
        throw exceptionInterpreter.m19959a();
    }

    private long m18862d() {
        return (long) Math.pow(5000.0d, (double) this.f11918a);
    }
}
