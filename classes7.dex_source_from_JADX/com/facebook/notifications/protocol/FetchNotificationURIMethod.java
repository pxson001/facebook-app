package com.facebook.notifications.protocol;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.notifications.model.SMSNotificationURL;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: negativeFeedbackMessageActions */
public class FetchNotificationURIMethod implements ApiMethod<String, FetchNotificationURIResult> {
    private static final String f8442a = BootstrapRequestName.GET_NOTIFICATION_URI.requestNameString;

    public final ApiRequest m10031a(Object obj) {
        String str = (String) obj;
        List a = Lists.a(2);
        a.add(new BasicNameValuePair("type", "shorturl"));
        a.add(new BasicNameValuePair("url", str));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f8442a;
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "search";
        newBuilder = newBuilder.a(RequestPriority.INTERACTIVE);
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    public final Object m10032a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return new FetchNotificationURIResult((SMSNotificationURL) apiResponse.d().a(SMSNotificationURL.class), DataFreshnessResult.FROM_SERVER, 0);
    }
}
