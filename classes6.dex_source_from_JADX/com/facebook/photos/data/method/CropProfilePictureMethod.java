package com.facebook.photos.data.method;

import android.graphics.RectF;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: imageURIMap */
public class CropProfilePictureMethod implements ApiMethod<CropProfilePictureParams, Boolean> {
    private static final Class<?> f12905a = CropProfilePictureMethod.class;

    public static CropProfilePictureMethod m20285a(InjectorLike injectorLike) {
        return new CropProfilePictureMethod();
    }

    public final ApiRequest m20286a(Object obj) {
        CropProfilePictureParams cropProfilePictureParams = (CropProfilePictureParams) obj;
        String a = StringFormatUtil.a("me/picture/%s", new Object[]{cropProfilePictureParams.f12906a});
        RectF rectF = cropProfilePictureParams.f12907b;
        Map c = Maps.c();
        c.put("x", Float.toString(rectF.left));
        c.put("y", Float.toString(rectF.top));
        c.put("width", Float.toString(rectF.width()));
        c.put("height", Float.toString(rectF.height()));
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("scaled_crop_rect", JSONUtil.a(c).toString()));
        a2.add(new BasicNameValuePair("format", "json"));
        a2.add(new BasicNameValuePair("profile_pic_method", cropProfilePictureParams.f12910e));
        long j = cropProfilePictureParams.f12908c;
        if (j != 0) {
            a2.add(new BasicNameValuePair("expiration_time", String.valueOf(j)));
        }
        String str = cropProfilePictureParams.f12909d;
        if (str != null) {
            a2.add(new BasicNameValuePair("sticker_id", str));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12905a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a2;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20287a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
