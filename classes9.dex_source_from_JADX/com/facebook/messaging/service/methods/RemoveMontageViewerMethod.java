package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.RemoveMontageViewerParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: cta_promotion_key */
public class RemoveMontageViewerMethod implements ApiMethod<RemoveMontageViewerParams, Void> {
    public final ApiRequest m17020a(Object obj) {
        RemoveMontageViewerParams removeMontageViewerParams = (RemoveMontageViewerParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("viewer_id", removeMontageViewerParams.f17279a));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "removeMontageViewer";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "DELETE";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "/me/montage_thread_viewers";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    public final Object m17021a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
