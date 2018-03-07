package com.facebook.debug.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/* compiled from: pinOrPassword */
public class FileReporter$RequestReport {
    @JsonProperty("body")
    public String mBody;
    @JsonProperty("headers")
    public Map<String, String> mHeaders;
    @JsonProperty("method")
    public String mMethod;
    @JsonProperty("request_id")
    public String mRequestId;
    @JsonProperty("timestamp")
    public long mTimeStamp;
    @JsonProperty("uri")
    public String mURI;
}
