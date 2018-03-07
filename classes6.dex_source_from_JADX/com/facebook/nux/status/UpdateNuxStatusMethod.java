package com.facebook.nux.status;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.nux.status.UpdateNuxStatusParams.Status;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: isCurrentLocation */
public class UpdateNuxStatusMethod implements ApiMethod<UpdateNuxStatusParams, Boolean> {
    public final ApiRequest m19167a(Object obj) {
        String str;
        UpdateNuxStatusParams updateNuxStatusParams = (UpdateNuxStatusParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "JSON"));
        a.add(new BasicNameValuePair("nux_id", updateNuxStatusParams.f12263a.toUpperCase(Locale.US)));
        a.add(new BasicNameValuePair("step", updateNuxStatusParams.f12265c));
        String str2 = "status";
        if (updateNuxStatusParams.f12266d == Status.COMPLETE) {
            str = "COMPLETE";
        } else {
            str = "SKIPPED";
        }
        a.add(new BasicNameValuePair(str2, str));
        str2 = "extra_data";
        ImmutableMap immutableMap = updateNuxStatusParams.f12267e;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            objectNode.a((String) entry.getKey(), (String) entry.getValue());
        }
        a.add(new BasicNameValuePair(str2, objectNode.toString()));
        return new ApiRequest("updateNuxStatus", "GET", "method/user.updateNuxStatus", a, ApiResponseType.JSON);
    }

    public final Object m19168a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().a(false));
    }
}
