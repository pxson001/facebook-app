package com.facebook.platform.server.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.platform.server.handler.ParcelableString;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: full width is not supported by recycler view yet */
public class ResolveTaggableProfileIdsMethod implements ApiMethod<Params, HashMap<String, ParcelableString>> {
    private static final Class<?> f11326a = ResolveTaggableProfileIdsMethod.class;

    public final ApiRequest m11774a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.a);
        List list = params.a;
        JSONArray jSONArray = new JSONArray(params.a);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", "resolvedtaggablefriend"));
        arrayList.add(new BasicNameValuePair("taggable_ids", jSONArray.toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "resolveTaggableFriendIds";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = "search";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        return newBuilder.C();
    }

    public final Object m11775a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        HashMap hashMap = new HashMap();
        c = c.b("data");
        if (c != null) {
            Iterator G = c.G();
            while (G.hasNext()) {
                c = (JsonNode) G.next();
                JsonNode b = c.b("id");
                c = c.b("taggable_id");
                if (!(b == null || c == null)) {
                    hashMap.put(c.B(), new ParcelableString(b.B()));
                }
            }
        }
        return hashMap;
    }
}
