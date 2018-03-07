package com.facebook.mqttlite;

import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: rtcCallLogs */
public class FetchMqttParametersMethod implements ApiMethod<Void, Map<String, JsonNode>> {
    public final Object m3530a(@Nullable Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        if (c == null) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{"mqtt_config"};
        Map hashMap = new HashMap();
        JsonNode g = c.g("data");
        for (int i = 0; i <= 0; i++) {
            JsonNode jsonNode;
            Object obj2 = strArr[0];
            Iterator it = g.iterator();
            while (it.hasNext()) {
                jsonNode = (JsonNode) it.next();
                if (jsonNode.c("section_name").B().equals(obj2)) {
                    jsonNode = jsonNode.c("value");
                    break;
                }
            }
            jsonNode = MissingNode.f10325a;
            JsonNode jsonNode2 = jsonNode;
            if (!jsonNode2.g()) {
                hashMap.put(obj2, jsonNode2);
            }
        }
        return hashMap;
    }

    public final ApiRequest m3529a(@Nullable Object obj) {
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("format", "JSON"));
        builder.c(new BasicNameValuePair("config_sections[]", "mqtt_config"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.MQTT_CONFIG.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = "/me/mobile_configs";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        return newBuilder.C();
    }
}
