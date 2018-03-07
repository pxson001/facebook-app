package com.facebook.api.feed;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: attachment_id */
public class SubmitSurveyResponseMethod implements ApiMethod<SubmitSurveyResponseParams, SubmitSurveyResponseResult> {
    public final ApiRequest m14656a(Object obj) {
        SubmitSurveyResponseParams submitSurveyResponseParams = (SubmitSurveyResponseParams) obj;
        String str = submitSurveyResponseParams.f8755b;
        String str2 = submitSurveyResponseParams.f8756c;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        arrayNode.h(str2);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.c(str, arrayNode);
        str = objectNode.toString();
        List a = Lists.a();
        a.add(new BasicNameValuePair("answers", str));
        a.add(new BasicNameValuePair("response", submitSurveyResponseParams.f8757d));
        return new ApiRequest("postResponse", "POST", submitSurveyResponseParams.f8754a + "/responses", a, ApiResponseType.JSON);
    }

    public final Object m14657a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new SubmitSurveyResponseResult(JSONUtil.b(c.b("response").b("id")), JSONUtil.b(c.b("state").b("next_page").a(0)));
    }
}
