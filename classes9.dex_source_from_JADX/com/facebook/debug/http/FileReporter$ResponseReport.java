package com.facebook.debug.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/* compiled from: pinOrPassword */
public class FileReporter$ResponseReport {
    @JsonProperty("body")
    public String mBody;
    @JsonProperty("headers")
    public Map<String, String> mHeaders;
    @JsonProperty("reason_phrase")
    public String mReasonPhrase;
    @JsonProperty("request_id")
    public String mRequestId;
    @JsonProperty("status_code")
    public String mStatusCode;
    @JsonProperty("timestamp")
    public long mTimeStamp;
}
