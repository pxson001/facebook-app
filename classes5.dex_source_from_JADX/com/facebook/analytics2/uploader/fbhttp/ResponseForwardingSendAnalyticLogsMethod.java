package com.facebook.analytics2.uploader.fbhttp;

import com.facebook.analytics.webmethod.AbstractSendAnalyticLogsMethod;
import com.facebook.analytics2.logger.UploadProcessor.UploadProcessorUploaderCallback;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;

/* compiled from: temporal_event_info */
class ResponseForwardingSendAnalyticLogsMethod extends AbstractSendAnalyticLogsMethod<Void> {
    private final UploadProcessorUploaderCallback f2095a;

    public ResponseForwardingSendAnalyticLogsMethod(UploadProcessorUploaderCallback uploadProcessorUploaderCallback) {
        super(ApiResponseType.STREAM);
        this.f2095a = uploadProcessorUploaderCallback;
    }

    public final Object m2795a(Object obj, ApiResponse apiResponse) {
        this.f2095a.m2775a(apiResponse.b, apiResponse.e());
        return null;
    }
}
