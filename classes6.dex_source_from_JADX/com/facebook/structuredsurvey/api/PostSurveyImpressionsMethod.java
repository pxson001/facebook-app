package com.facebook.structuredsurvey.api;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: download_start_time */
public class PostSurveyImpressionsMethod implements ApiMethod<PostSurveyImpressionsParams, Void> {
    public final ApiRequest m24818a(Object obj) {
        PostSurveyImpressionsParams postSurveyImpressionsParams = (PostSurveyImpressionsParams) obj;
        Map map = postSurveyImpressionsParams.f17139d;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : map.entrySet()) {
            objectNode.a((String) entry.getKey(), (String) entry.getValue());
        }
        String objectNode2 = objectNode.toString();
        List a = Lists.a();
        a.add(new BasicNameValuePair("session_blob", postSurveyImpressionsParams.f17137b));
        a.add(new BasicNameValuePair("impression_event", postSurveyImpressionsParams.f17138c));
        a.add(new BasicNameValuePair("device_time", String.valueOf(System.currentTimeMillis())));
        a.add(new BasicNameValuePair("context", objectNode2));
        return new ApiRequest("postResponse", "POST", postSurveyImpressionsParams.f17136a + "/impressions", RequestPriority.CAN_WAIT, a, ApiResponseType.JSON);
    }

    public final Object m24819a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
