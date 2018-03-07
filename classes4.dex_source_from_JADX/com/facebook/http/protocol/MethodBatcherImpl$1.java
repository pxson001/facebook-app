package com.facebook.http.protocol;

import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;

/* compiled from: features_extra_data */
/* synthetic */ class MethodBatcherImpl$1 {
    static final /* synthetic */ int[] f11934a = new int[HttpConfig.values().length];
    static final /* synthetic */ int[] f11935b = new int[RequestIdempotency.values().length];

    static {
        try {
            f11935b[RequestIdempotency.CONSERVATIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11935b[RequestIdempotency.RETRY_SAFE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11934a[HttpConfig.PROD.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11934a[HttpConfig.BOOTSTRAP.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
