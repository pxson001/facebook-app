package com.facebook.messaging.service.model;

import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: country_code_key */
public class FetchPinnedThreadsParamsBuilder {
    public DataFreshnessParam f17097a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
    public long f17098b = 0;

    public final FetchPinnedThreadsParams m17092c() {
        return new FetchPinnedThreadsParams(this);
    }
}
