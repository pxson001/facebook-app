package com.facebook.debug.http;

import com.fasterxml.jackson.annotation.JsonProperty;

/* compiled from: pinOrPassword */
public class FileReporter$ErrorResponseReport {
    @JsonProperty("error")
    public String mError;
    @JsonProperty("request_id")
    public String mRequestId;
    @JsonProperty("response")
    public FileReporter$ResponseReport mResponse;
    @JsonProperty("timestamp")
    public long mTimeStamp;
}
