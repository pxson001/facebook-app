package com.facebook.groups.docsandfiles.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: Unknown or non-public guest list type. */
public class GroupDocsAndFilesUploadMethod implements ApiMethod<GroupDocsAndFilesUploadParams, GroupDocsAndFilesUploadResponse> {
    public static GroupDocsAndFilesUploadMethod m22515a(InjectorLike injectorLike) {
        return new GroupDocsAndFilesUploadMethod();
    }

    public final ApiRequest m22516a(Object obj) {
        GroupDocsAndFilesUploadParams groupDocsAndFilesUploadParams = (GroupDocsAndFilesUploadParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("id", Long.toString(groupDocsAndFilesUploadParams.f21496a)));
        builder.c(new BasicNameValuePair("name", groupDocsAndFilesUploadParams.f21499d));
        builder.c(new BasicNameValuePair("message", groupDocsAndFilesUploadParams.f21497b));
        for (String basicNameValuePair : groupDocsAndFilesUploadParams.f21498c) {
            builder.c(new BasicNameValuePair("file_attachment_urls[]", basicNameValuePair));
        }
        String str = groupDocsAndFilesUploadParams.f21496a + "/files";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload_group_docs_or_files";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    public final Object m22517a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.b == 200) {
            JsonNode c = apiResponse.c();
            return new GroupDocsAndFilesUploadResponse(c.b("id").D(), c.b("success").F());
        }
        throw new HttpException("Group file upload failed," + apiResponse.toString());
    }
}
