package com.facebook.push.fbpushtoken;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: i2o_ul_pl */
public class ReportAppDeletionMethod implements ApiMethod<ReportAppDeletionParams, Void> {
    public final ApiRequest m11093a(Object obj) {
        ReportAppDeletionParams reportAppDeletionParams = (ReportAppDeletionParams) obj;
        ImmutableList of = ImmutableList.of(new BasicNameValuePair("package_name", reportAppDeletionParams.a), new BasicNameValuePair("device_id", reportAppDeletionParams.b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "reportAppDeletion";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/user.reportAppDeletionCallback";
        newBuilder = newBuilder;
        newBuilder.g = of;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a.k = ApiResponseType.STRING;
        return a.C();
    }

    public final Object m11094a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
