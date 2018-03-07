package com.facebook.common.errorreporting.memory;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: uBlurType */
public class MemoryDumpUploadMethod implements ApiMethod<MemoryDumpUploadMethodParams, Boolean> {
    private static final Class<?> f1154a = MemoryDumpUploadMethod.class;

    public final ApiRequest m1241a(Object obj) {
        MemoryDumpUploadMethodParams memoryDumpUploadMethodParams = (MemoryDumpUploadMethodParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("filetype", String.valueOf(memoryDumpUploadMethodParams.f1171b)));
        a.add(new BasicNameValuePair("crash_id", memoryDumpUploadMethodParams.f1172c));
        a.add(new BasicNameValuePair("extras", memoryDumpUploadMethodParams.m1255d()));
        File file = memoryDumpUploadMethodParams.f1170a;
        file.getName();
        Long.valueOf(file.length());
        FormBodyPart formBodyPart = new FormBodyPart("file", new DataStreamBody(file, "application/octet-stream", file.getName()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "hprofUpload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/hprof";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = ImmutableList.of(formBodyPart);
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.w = PostEntityType.MULTI_PART_ENTITY;
        return apiRequestBuilder.C();
    }

    public final Object m1242a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().b("success")));
    }
}
