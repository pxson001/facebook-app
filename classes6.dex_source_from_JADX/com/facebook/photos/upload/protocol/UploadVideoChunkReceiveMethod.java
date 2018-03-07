package com.facebook.photos.upload.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBodyWithOffset;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.uploaders.UploadAssetSegment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: generic_map_my_location_button_clicked */
public class UploadVideoChunkReceiveMethod implements ApiMethod<UploadVideoChunkReceiveParams, UploadVideoChunkReceiveResponse> {
    public static UploadVideoChunkReceiveMethod m21844a(InjectorLike injectorLike) {
        return new UploadVideoChunkReceiveMethod();
    }

    public final ApiRequest m21845a(Object obj) {
        UploadVideoChunkReceiveParams uploadVideoChunkReceiveParams = (UploadVideoChunkReceiveParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("start_offset", Long.toString(uploadVideoChunkReceiveParams.f14179c)));
        String g = uploadVideoChunkReceiveParams.m21853g();
        if (!StringUtil.a(g)) {
            builder.c(new BasicNameValuePair("composer_session_id", g));
        }
        builder.c(new BasicNameValuePair("target", Long.toString(uploadVideoChunkReceiveParams.m21850d())));
        builder.c(new BasicNameValuePair("upload_speed", Float.toString(uploadVideoChunkReceiveParams.m21854h())));
        String str = "v2.3/" + uploadVideoChunkReceiveParams.m21850d() + "/videos";
        builder.c(new BasicNameValuePair("upload_phase", "transfer"));
        builder.c(new BasicNameValuePair("upload_session_id", Long.toString(uploadVideoChunkReceiveParams.m21847a())));
        if (uploadVideoChunkReceiveParams.m21860n()) {
            builder.c(new BasicNameValuePair("fbuploader_video_file_chunk", uploadVideoChunkReceiveParams.m21859m()));
            if (uploadVideoChunkReceiveParams.m21855i()) {
                builder.c(new BasicNameValuePair("partition_start_offset", Long.toString(uploadVideoChunkReceiveParams.m21856j())));
                builder.c(new BasicNameValuePair("partition_end_offset", Long.toString(uploadVideoChunkReceiveParams.m21857k())));
            }
            ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
            newBuilder.b = "upload-video-chunk-receive";
            newBuilder = newBuilder;
            newBuilder.c = "POST";
            newBuilder = newBuilder;
            newBuilder.d = str;
            newBuilder = newBuilder;
            newBuilder.k = ApiResponseType.JSON;
            newBuilder = newBuilder;
            newBuilder.g = builder.b();
            newBuilder = newBuilder;
            newBuilder.n = true;
            newBuilder = newBuilder;
            newBuilder.p = true;
            newBuilder = newBuilder;
            newBuilder.A = g;
            return newBuilder.C();
        }
        Object e = uploadVideoChunkReceiveParams.m21851e();
        if (StringUtil.a(e)) {
            throw new FileNotFoundException();
        }
        AbstractContentBody dataStreamBodyWithOffset;
        File file = new File(e);
        UploadAssetSegment l = uploadVideoChunkReceiveParams.m21858l();
        if (l != null) {
            builder.c(new BasicNameValuePair("partition_start_offset", Long.toString(l.f14444e)));
            builder.c(new BasicNameValuePair("partition_end_offset", Long.toString(l.f14445f)));
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("segment_type", Long.toString((long) l.f14442c.getValue()));
            objectNode.a("segment_start_offset", Long.toString(l.f14444e));
            objectNode.a("segment_end_offset", Long.toString(l.f14445f));
            builder.c(new BasicNameValuePair("metadata", objectNode.toString()));
            dataStreamBodyWithOffset = new DataStreamBodyWithOffset(file, uploadVideoChunkReceiveParams.m21852f(), file.getName(), uploadVideoChunkReceiveParams.m21848b() - l.f14444e, uploadVideoChunkReceiveParams.m21849c());
        } else if (uploadVideoChunkReceiveParams.m21855i()) {
            builder.c(new BasicNameValuePair("start_offset", Long.toString(uploadVideoChunkReceiveParams.m21848b())));
            builder.c(new BasicNameValuePair("partition_start_offset", Long.toString(uploadVideoChunkReceiveParams.m21856j())));
            builder.c(new BasicNameValuePair("partition_end_offset", Long.toString(uploadVideoChunkReceiveParams.m21857k())));
            dataStreamBodyWithOffset = new DataStreamBodyWithOffset(file, uploadVideoChunkReceiveParams.m21852f(), file.getName(), uploadVideoChunkReceiveParams.m21848b(), uploadVideoChunkReceiveParams.m21849c());
        } else {
            builder.c(new BasicNameValuePair("start_offset", Long.toString(uploadVideoChunkReceiveParams.m21848b())));
            dataStreamBodyWithOffset = new DataStreamBodyWithOffset(file, uploadVideoChunkReceiveParams.m21852f(), file.getName(), uploadVideoChunkReceiveParams.m21848b(), uploadVideoChunkReceiveParams.m21849c());
        }
        FormBodyPart formBodyPart = new FormBodyPart("video_file_chunk", dataStreamBodyWithOffset);
        newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-video-chunk-receive";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = ImmutableList.of(formBodyPart);
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.n = true;
        newBuilder = newBuilder;
        newBuilder.p = true;
        newBuilder = newBuilder;
        newBuilder.A = g;
        return newBuilder.C();
    }

    public final Object m21846a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new UploadVideoChunkReceiveResponse(c.b("start_offset").D(), c.b("end_offset").D());
    }
}
