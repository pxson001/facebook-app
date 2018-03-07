package com.facebook.http.protocol;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: fetch_zero_optin_content_request */
public class JsonResponseHandler implements ResponseHandler<JsonNode> {
    private final ObjectMapper f23812a;
    private final ApiResponseChecker f23813b;
    private HttpResponse f23814c;

    public /* synthetic */ Object handleResponse(HttpResponse httpResponse) {
        return m32207a(httpResponse);
    }

    public JsonResponseHandler(ObjectMapper objectMapper, ApiResponseChecker apiResponseChecker) {
        this.f23812a = objectMapper;
        this.f23813b = apiResponseChecker;
    }

    public final JsonNode m32207a(HttpResponse httpResponse) {
        this.f23814c = httpResponse;
        this.f23813b.m11768a(httpResponse);
        return this.f23812a.m6635a(httpResponse.getEntity().getContent());
    }
}
