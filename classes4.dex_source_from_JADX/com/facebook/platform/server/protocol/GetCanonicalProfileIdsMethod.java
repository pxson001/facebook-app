package com.facebook.platform.server.protocol;

import android.text.TextUtils;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.platform.server.handler.ParcelableString;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fullRefreshReason */
public class GetCanonicalProfileIdsMethod implements ApiMethod<Params, HashMap<String, ParcelableString>> {
    private static final Class<?> f11325a = GetCanonicalProfileIdsMethod.class;

    public final ApiRequest m11769a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.a);
        ArrayList arrayList = params.a;
        List a = Lists.a();
        a.add(new BasicNameValuePair("ids", TextUtils.join(",", params.a)));
        a.add(new BasicNameValuePair("fields", "canonical_id"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "getCanonicalProfileId";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = "";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = a;
        return newBuilder.C();
    }

    public final Object m11770a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        HashMap hashMap = new HashMap();
        Iterator H = c.H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            JsonNode b = ((JsonNode) entry.getValue()).b("canonical_id");
            if (b != null) {
                hashMap.put(entry.getKey(), new ParcelableString(b.B()));
            }
        }
        return hashMap;
    }
}
