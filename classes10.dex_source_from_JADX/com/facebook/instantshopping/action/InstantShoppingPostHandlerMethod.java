package com.facebook.instantshopping.action;

import android.net.Uri;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: Sizes don't match */
public class InstantShoppingPostHandlerMethod implements ApiMethod<String, Boolean> {
    public final ApiRequest m24804a(Object obj) {
        Uri parse = Uri.parse((String) obj);
        String substring = parse.getPath().startsWith("/") ? parse.getPath().substring(1) : parse.getPath();
        List arrayList = new ArrayList();
        for (String str : parse.getQueryParameterNames()) {
            arrayList.add(new BasicNameValuePair(str, parse.getQueryParameter(str)));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "InstantShoppingPostAction";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = substring;
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m24805a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
