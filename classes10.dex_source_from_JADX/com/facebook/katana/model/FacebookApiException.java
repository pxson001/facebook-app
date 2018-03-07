package com.facebook.katana.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/* compiled from: updateMessageRequestsSnippet */
public class FacebookApiException extends Exception {
    protected Throwable mCause;
    protected ServerExceptionData mData;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FacebookApiException_ServerExceptionDataDeserializer.class)
    /* compiled from: updateMessageRequestsSnippet */
    public class ServerExceptionData {
        @JsonProperty("error_code")
        final int mErrorCode;
        @JsonProperty("error_data")
        final String mErrorData;
        @JsonProperty("error_msg")
        final String mErrorMsg;

        protected ServerExceptionData() {
            this.mErrorCode = -1;
            this.mErrorMsg = null;
            this.mErrorData = null;
        }

        public ServerExceptionData(int i, String str) {
            this.mErrorCode = i;
            this.mErrorMsg = str;
            this.mErrorData = null;
        }
    }

    protected FacebookApiException() {
    }

    public FacebookApiException(int i, String str) {
        this.mData = new ServerExceptionData(i, str);
    }

    public Throwable getCause() {
        return this.mCause;
    }

    public final int m982a() {
        return this.mData.mErrorCode;
    }

    public final String m983b() {
        return this.mData.mErrorMsg;
    }
}
