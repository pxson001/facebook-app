package com.facebook.photos.upload.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.CheckinEntryPoint;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: getDimensionsFromMediaStore failed */
public class UpdatePhotoInfoMethod implements ApiMethod<UploadPhotoParams, String> {
    public static UpdatePhotoInfoMethod m21740a(InjectorLike injectorLike) {
        return new UpdatePhotoInfoMethod();
    }

    public final ApiRequest m21741a(Object obj) {
        boolean z;
        UploadPhotoParams uploadPhotoParams = (UploadPhotoParams) obj;
        if (uploadPhotoParams.f14084B != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Builder builder = ImmutableList.builder();
        String str = uploadPhotoParams.f14117k;
        if (!StringUtil.a(str)) {
            if (uploadPhotoParams.f14118l) {
                builder.c(new BasicNameValuePair("name", str));
            } else {
                builder.c(new BasicNameValuePair("caption", str));
            }
        }
        Object f = uploadPhotoParams.m21817f();
        if (!StringUtil.a(f)) {
            builder.c(new BasicNameValuePair("profile_id", f));
        }
        CharSequence h = uploadPhotoParams.m21819h();
        if (!StringUtil.a(h)) {
            builder.c(new BasicNameValuePair("place", h));
        }
        String str2 = uploadPhotoParams.f14111e;
        if (!StringUtil.a(h)) {
            builder.c(new BasicNameValuePair("text_only_place", str2));
        }
        builder.c(new BasicNameValuePair("checkin_entry_point", CheckinEntryPoint.a(uploadPhotoParams.f14112f)));
        if (uploadPhotoParams.f14127u) {
            ImmutableList immutableList = uploadPhotoParams.f14119m;
            if (!(immutableList == null || immutableList.isEmpty())) {
                String str3;
                String str4 = "tags";
                if (immutableList == null || immutableList.isEmpty()) {
                    str3 = null;
                } else {
                    str3 = "[" + Joiner.on(',').skipNulls().join(immutableList) + "]";
                }
                builder.c(new BasicNameValuePair(str4, str3));
            }
        }
        int i = uploadPhotoParams.f14086D;
        if (i != -1) {
            builder.c(new BasicNameValuePair("publish_order", Integer.toString(i)));
        }
        str = uploadPhotoParams.f14123q;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("idempotence_token", str));
        }
        builder.b(uploadPhotoParams.f14121o.a());
        str = uploadPhotoParams.f14122p;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("qn", str));
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        i = uploadPhotoParams.f14124r;
        if (i != 0) {
            builder.c(new BasicNameValuePair("orientation", String.valueOf(i)));
        }
        ComposerAppAttribution composerAppAttribution = uploadPhotoParams.f14128v;
        if (composerAppAttribution != null) {
            builder.c(new BasicNameValuePair("proxied_app_id", composerAppAttribution.m7689a()));
            builder.c(new BasicNameValuePair("proxied_app_name", composerAppAttribution.m7690b()));
            builder.c(new BasicNameValuePair("android_key_hash", composerAppAttribution.m7691c()));
            builder.c(new BasicNameValuePair("user_selected_tags", String.valueOf(uploadPhotoParams.f14129w)));
            builder.c(new BasicNameValuePair("user_selected_place", String.valueOf(uploadPhotoParams.f14130x)));
        }
        str = Long.toString(uploadPhotoParams.f14084B);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update-photo-info";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = builder.b();
        return apiRequestBuilder.C();
    }

    public final Object m21742a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.b();
    }
}
