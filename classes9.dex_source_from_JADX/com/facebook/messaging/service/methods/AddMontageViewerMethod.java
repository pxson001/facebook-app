package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.AddMontageViewerParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: dccb3e24a820cb7f990933921db42c20 */
public class AddMontageViewerMethod implements ApiMethod<AddMontageViewerParams, Void> {
    public final ApiRequest m16854a(Object obj) {
        AddMontageViewerParams addMontageViewerParams = (AddMontageViewerParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("viewer_id", addMontageViewerParams.f17011a));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "addMontageViewer";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "/me/montage_thread_viewers";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    public final Object m16855a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
