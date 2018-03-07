package com.facebook.messaging.blocking.api;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: onMomentumScrollBegin */
public class GetBlockedPeopleMethod implements ApiMethod<Void, ArrayList<BlockedPerson>> {
    private static final Class<?> f8303b = GetBlockedPeopleMethod.class;
    private final ObjectMapper f8304a;

    @Inject
    public GetBlockedPeopleMethod(ObjectMapper objectMapper) {
        this.f8304a = objectMapper;
    }

    public final ApiRequest m8556a(Object obj) {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("fields", StringFormatUtil.formatStrLocaleSafe("%1$s,%2$s,%3$s,%4$s", "fbid", "name", "block_type", "block_time")));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "getBlockedPeople";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "me/blocked";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m8557a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode b = apiResponse.c().b("data");
        ArrayList arrayList = new ArrayList();
        if (b == null) {
            BLog.b(f8303b, "Missing data node in response");
            return arrayList;
        } else if (b.h()) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                arrayList.add(this.f8304a.a((JsonNode) it.next(), BlockedPerson.class));
            }
            return arrayList;
        } else {
            BLog.b(f8303b, "Unexpected type of json type: %s", new Object[]{b.k()});
            return arrayList;
        }
    }
}
