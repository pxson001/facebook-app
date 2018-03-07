package com.facebook.proxygen;

import com.facebook.http.common.NetworkException;

/* compiled from: data */
public class HttpNetworkException extends NetworkException {
    public final HTTPRequestError mError;

    public HttpNetworkException(HTTPRequestError hTTPRequestError) {
        super(hTTPRequestError.mErrMsg);
        this.mError = hTTPRequestError;
    }
}
