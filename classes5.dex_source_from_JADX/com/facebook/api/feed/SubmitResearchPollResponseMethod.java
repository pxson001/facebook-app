package com.facebook.api.feed;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: attachment_name */
public class SubmitResearchPollResponseMethod implements ApiMethod<SubmitResearchPollResponseParams, Void> {
    public final ApiRequest m14654a(Object obj) {
        SubmitResearchPollResponseParams submitResearchPollResponseParams = (SubmitResearchPollResponseParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("client_token", submitResearchPollResponseParams.f8752d));
        a.add(new BasicNameValuePair("from_cta", Boolean.toString(submitResearchPollResponseParams.f8751c.booleanValue())));
        if (!submitResearchPollResponseParams.f8751c.booleanValue()) {
            a.add(new BasicNameValuePair("question", submitResearchPollResponseParams.f8750b));
            String str = "answers";
            List<String> list = submitResearchPollResponseParams.f8753e;
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            a.add(new BasicNameValuePair(str, jSONArray.toString()));
        }
        return new ApiRequest("postResponse", "POST", submitResearchPollResponseParams.f8749a + "/responses", a, ApiResponseType.JSON);
    }

    public final Object m14655a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
