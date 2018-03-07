package com.facebook.friendsnearby.pingdialog;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ^/?v\d+\.\d+/(.*) */
public class LocationPingDeleteMethod implements ApiMethod<LocationPingDeleteParams, Boolean> {
    public final ApiRequest m21032a(Object obj) {
        LocationPingDeleteParams locationPingDeleteParams = (LocationPingDeleteParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("recipient", locationPingDeleteParams.f20617a));
        return new ApiRequest("locationPingDelete", "DELETE", "/me/locationping", a, ApiResponseType.STRING);
    }

    public final Object m21033a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.b()));
    }
}
