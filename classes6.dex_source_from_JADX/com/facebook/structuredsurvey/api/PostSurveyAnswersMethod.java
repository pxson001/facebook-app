package com.facebook.structuredsurvey.api;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: downloadsize */
public class PostSurveyAnswersMethod implements ApiMethod<PostSurveyAnswersParams, Void> {
    public final ApiRequest m24816a(Object obj) {
        PostSurveyAnswersParams postSurveyAnswersParams = (PostSurveyAnswersParams) obj;
        Map map = postSurveyAnswersParams.f17132d;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            ParcelableStringArrayList parcelableStringArrayList = (ParcelableStringArrayList) entry.getValue();
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            Iterator it = parcelableStringArrayList.iterator();
            while (it.hasNext()) {
                arrayNode.h((String) it.next());
            }
            objectNode.c(str, arrayNode);
        }
        String objectNode2 = objectNode.toString();
        String a = m24813a((List) postSurveyAnswersParams.f17133e);
        String b = m24814b((List) postSurveyAnswersParams.f17134f);
        String b2 = m24815b((Map) postSurveyAnswersParams.f17135g);
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("answers", objectNode2));
        a2.add(new BasicNameValuePair("pages", a));
        a2.add(new BasicNameValuePair("session_blob", postSurveyAnswersParams.f17130b));
        a2.add(new BasicNameValuePair("page_numbers", b));
        a2.add(new BasicNameValuePair("context", b2));
        a2.add(new BasicNameValuePair("disable_event_logging", Boolean.toString(postSurveyAnswersParams.f17131c)));
        return new ApiRequest("postResponse", "POST", postSurveyAnswersParams.f17129a + "/responses", RequestPriority.CAN_WAIT, a2, ApiResponseType.JSON);
    }

    private static String m24813a(List<ParcelableStringArrayList> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ParcelableStringArrayList parcelableStringArrayList : list) {
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
            Iterator it = parcelableStringArrayList.iterator();
            while (it.hasNext()) {
                arrayNode2.h((String) it.next());
            }
            arrayNode.a(arrayNode2);
        }
        return arrayNode.toString();
    }

    private static String m24814b(List<Integer> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Integer num : list) {
            arrayNode.h(num.toString());
        }
        return arrayNode.toString();
    }

    private static String m24815b(Map<String, String> map) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : map.entrySet()) {
            objectNode.a((String) entry.getKey(), (String) entry.getValue());
        }
        return objectNode.toString();
    }

    public final Object m24817a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
