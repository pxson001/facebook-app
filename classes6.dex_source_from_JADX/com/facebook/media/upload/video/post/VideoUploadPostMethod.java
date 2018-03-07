package com.facebook.media.upload.video.post;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.media.upload.MediaAttachementBody;
import com.facebook.media.upload.MediaUploadParameters;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: joinable_mode */
class VideoUploadPostMethod implements ApiMethod<VideoUploadPostParams, Boolean> {
    VideoUploadPostMethod() {
    }

    public final ApiRequest m18875a(Object obj) {
        ImmutableList immutableList;
        VideoUploadPostParams videoUploadPostParams = (VideoUploadPostParams) obj;
        Builder builder = ImmutableList.builder();
        MediaUploadParameters mediaUploadParameters = videoUploadPostParams.f11937b;
        String str = mediaUploadParameters.f11891a;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        builder.c(new BasicNameValuePair("upload_session_id", videoUploadPostParams.f11936a));
        builder.c(new BasicNameValuePair("upload_phase", "finish"));
        if (mediaUploadParameters.f11896f == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(mediaUploadParameters.f11896f);
        }
        builder.b(immutableList);
        String str2 = "v2.3/" + mediaUploadParameters.f11892b + "/videos";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "media-upload-video-chunk-post";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str2;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        if (mediaUploadParameters.f11897g == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(mediaUploadParameters.f11897g);
        }
        List<MediaAttachementBody> list = immutableList;
        List list2 = null;
        if (!(list == null || list.isEmpty())) {
            List arrayList = new ArrayList(list.size());
            for (MediaAttachementBody a : list) {
                arrayList.add(a.m18846a());
            }
            list2 = arrayList;
        }
        apiRequestBuilder2.l = list2;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.n = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.p = true;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.A = str;
        return apiRequestBuilder2.C();
    }

    public final Object m18876a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().b("success").F());
    }
}
