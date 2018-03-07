package com.facebook.composer.publish.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.ipc.composer.model.PublishMode;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_picker_swipes_to_left_count */
public class SimplePhotoUploadMethod implements ApiMethod<SimplePhotoUploadParams, SimplePhotoUploadResult> {
    public final ApiRequest m11660a(Object obj) {
        boolean z;
        SimplePhotoUploadParams simplePhotoUploadParams = (SimplePhotoUploadParams) obj;
        String str = simplePhotoUploadParams.f8072c;
        Long valueOf = Long.valueOf(simplePhotoUploadParams.f8071b);
        Preconditions.checkArgument(!StringUtil.a(str));
        if (valueOf.longValue() != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        List a = Lists.a();
        String str2 = simplePhotoUploadParams.f8070a;
        if (!StringUtil.a(str2)) {
            a.add(new BasicNameValuePair("composer_session_id", str2));
        }
        str2 = simplePhotoUploadParams.f8073d;
        if (!StringUtil.a(str2)) {
            a.add(new BasicNameValuePair("caption", str2));
        }
        if (simplePhotoUploadParams.f8075f != PublishMode.NORMAL) {
            a.add(new BasicNameValuePair("published", Boolean.FALSE.toString()));
            a.add(new BasicNameValuePair("unpublished_content_type", simplePhotoUploadParams.f8075f.getContentType()));
        }
        if (simplePhotoUploadParams.f8074e != 0) {
            a.add(new BasicNameValuePair("scheduled_publish_time", String.valueOf(simplePhotoUploadParams.f8074e)));
        }
        File file = new File(str);
        FormBodyPart formBodyPart = new FormBodyPart("source", new DataStreamBody(file, "image/jpeg", file.getName()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "graphObjectPhoto";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.a("/%d/photos", new Object[]{valueOf});
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.l = ImmutableList.of(formBodyPart);
        return apiRequestBuilder2.C();
    }

    public final Object m11661a(Object obj, ApiResponse apiResponse) {
        String B;
        String str = null;
        JsonNode c = apiResponse.c();
        JsonNode b = c.b("post_id");
        JsonNode b2 = c.b("id");
        if (b != null) {
            B = b.B();
        } else {
            B = null;
        }
        if (b2 != null) {
            str = b2.B();
        }
        return new SimplePhotoUploadResult(B, str);
    }
}
