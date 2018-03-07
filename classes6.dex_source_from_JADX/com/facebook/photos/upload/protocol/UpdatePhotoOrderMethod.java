package com.facebook.photos.upload.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: getCurrentMediaTimeResetable got a negative value  */
public class UpdatePhotoOrderMethod implements ApiMethod<UpdatePhotoOrderParams, Boolean> {
    public static UpdatePhotoOrderMethod m21743a(InjectorLike injectorLike) {
        return new UpdatePhotoOrderMethod();
    }

    public final ApiRequest m21745a(Object obj) {
        UpdatePhotoOrderParams updatePhotoOrderParams = (UpdatePhotoOrderParams) obj;
        String str = updatePhotoOrderParams.f14032a;
        List list = updatePhotoOrderParams.f14033b;
        boolean z = (StringUtil.a(str) || list == null || list.isEmpty()) ? false : true;
        Preconditions.checkArgument(z);
        Builder builder = ImmutableList.builder();
        if (updatePhotoOrderParams.f14034c) {
            builder.c(new BasicNameValuePair("reorder_pids", m21744a(list)));
        } else {
            builder.c(new BasicNameValuePair("photo_order", m21744a(list)));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update-photo-order";
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

    public final Object m21746a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        boolean z = apiResponse.b == 200 && (apiResponse.c instanceof BooleanNode) && ((BooleanNode) apiResponse.c).F();
        return Boolean.valueOf(z);
    }

    @Nullable
    private static String m21744a(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return "[" + Joiner.on(',').skipNulls().join(list) + "]";
    }
}
