package com.facebook.search.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: nearby_places_scroll_results */
public class LogSelectedSuggestionToActivityLogMethod implements ApiMethod<LogSelectedSuggestionToActivityLogParams, Void> {
    public final ApiRequest m8987a(Object obj) {
        LogSelectedSuggestionToActivityLogParams logSelectedSuggestionToActivityLogParams = (LogSelectedSuggestionToActivityLogParams) obj;
        List a = Lists.a();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("user_input", logSelectedSuggestionToActivityLogParams.f8109a);
        objectNode.a("selected_type", logSelectedSuggestionToActivityLogParams.f8110b);
        objectNode.a("selected_text", logSelectedSuggestionToActivityLogParams.f8111c);
        objectNode.a("selected_semantic", logSelectedSuggestionToActivityLogParams.f8112d);
        objectNode.a("timestamp", logSelectedSuggestionToActivityLogParams.f8113e);
        objectNode.a("skip_activity_log", logSelectedSuggestionToActivityLogParams.f8115g);
        a.add(new BasicNameValuePair("search_type", logSelectedSuggestionToActivityLogParams.f8114f.getParamName()));
        a.add(new BasicNameValuePair("message", objectNode.toString()));
        return new ApiRequest("mobilesearchactivitylog", "POST", "method/mobilesearchactivitylog", a, ApiResponseType.STRING);
    }

    public final Object m8988a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
