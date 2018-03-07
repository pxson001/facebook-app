package com.facebook.fbreact.persistedqueries;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sprout_source */
public class RelayPersistedQueriesPreloaderMethod implements ApiMethod<Map<String, String>, ApiResponse> {
    public final ApiRequest m4210a(Object obj) {
        Map map = (Map) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("queries", (String) map.get("queries")));
        a.add(new BasicNameValuePair("format", "JSON"));
        a.add(new BasicNameValuePair("xhrEncoding", "gzip"));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = (String) map.get("entryName");
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.c = "GET";
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.d = "graphqlbatch?locale=user";
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = a;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m4211a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse;
    }
}
