package com.facebook.vault.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: thread_id=' */
public class FetchBlacklistedSyncPaths implements ApiMethod<Void, String> {
    public final ApiRequest m1926a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "JSON"));
        return new ApiRequest("fetch_blacklised_sync_paths", "GET", "method/vault.androidBlacklistedSyncPaths", a, ApiResponseType.STRING);
    }

    public final Object m1927a(Object obj, ApiResponse apiResponse) {
        return apiResponse.b();
    }
}
