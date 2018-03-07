package com.facebook.http.protocol;

import com.facebook.http.protocol.ApiErrorResult.Builder;

/* compiled from: dialtone_wrong_carrier_flag */
public class BatchMethodNotExecutedException extends ApiException {
    public BatchMethodNotExecutedException(String str) {
        Builder a = ApiErrorResult.a(-1, "Batch method not executed");
        a.d = str;
        super(a.a());
    }
}
