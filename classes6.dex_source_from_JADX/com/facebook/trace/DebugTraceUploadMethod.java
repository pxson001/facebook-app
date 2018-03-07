package com.facebook.trace;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: segment_type */
public class DebugTraceUploadMethod implements ApiMethod<DebugTraceUploadParams, Boolean> {
    private static final Class<?> f5072a = DebugTraceUploadMethod.class;

    public final ApiRequest m7833a(Object obj) {
        DebugTraceUploadParams debugTraceUploadParams = (DebugTraceUploadParams) obj;
        File file = debugTraceUploadParams.f5073a;
        FormBodyPart formBodyPart = new FormBodyPart("TraceFile", new DataStreamBody(file, "application/octet-stream", file.getName()));
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("perf_name", DebugTraceUtils.c(debugTraceUploadParams.f5073a.getName()).group(2)));
        arrayList.add(new BasicNameValuePair("timestamp", DebugTraceUtils.c(debugTraceUploadParams.f5073a.getName()).group(1)));
        arrayList.add(new BasicNameValuePair("phone_model", debugTraceUploadParams.f5075c));
        arrayList.add(new BasicNameValuePair("android_version", debugTraceUploadParams.f5076d));
        arrayList.add(new BasicNameValuePair("app_version", debugTraceUploadParams.f5077e));
        file.getName();
        Long.valueOf(file.length());
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "PerfTraceUpload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/mobile_perftraces";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder.a(RequestPriority.CAN_WAIT);
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = ImmutableList.of(formBodyPart);
        newBuilder = newBuilder;
        newBuilder.w = PostEntityType.MULTI_PART_ENTITY;
        return newBuilder.C();
    }

    public final Object m7834a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().b("success")));
    }
}
