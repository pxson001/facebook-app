package com.facebook.crudolib.netfb;

import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: TimelineNuxQuery */
public class FbApiException extends IOException {
    private final int apiErrorCode;
    @Nullable
    private final String errorData;
    private final ErrorDomain errorDomain;
    @Nullable
    private final String errorMessage;

    /* compiled from: TimelineNuxQuery */
    public enum ErrorDomain {
        API_EC_DOMAIN,
        GRAPHQL_KERROR_DOMAIN
    }

    public FbApiException(int i, @Nullable String str, @Nullable String str2, ErrorDomain errorDomain) {
        super(m26035a(str, i, errorDomain));
        this.apiErrorCode = i;
        this.errorMessage = str;
        this.errorData = str2;
        this.errorDomain = errorDomain;
    }

    private static String m26035a(@Nullable String str, int i, ErrorDomain errorDomain) {
        return str != null ? str : errorDomain + ": code=" + i;
    }

    public String toString() {
        return "{apiErrorCode=" + this.apiErrorCode + ", errorMessage=" + this.errorMessage + ", errorData=" + this.errorData + ", errorDomain=" + this.errorDomain + "}";
    }
}
