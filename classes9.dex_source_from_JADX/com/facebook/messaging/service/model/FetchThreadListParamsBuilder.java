package com.facebook.messaging.service.model;

import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: could not find a size that matches picture aspect ratio. */
public class FetchThreadListParamsBuilder {
    public DataFreshnessParam f17124a;
    public FolderName f17125b;
    public ThreadTypeFilter f17126c = ThreadTypeFilter.ALL;
    public boolean f17127d;
    public long f17128e = -1;
    public int f17129f = 20;
    public RequestPriority f17130g = RequestPriority.DEFAULT_PRIORITY;

    FetchThreadListParamsBuilder() {
    }

    public final FetchThreadListParamsBuilder m17112a(DataFreshnessParam dataFreshnessParam) {
        this.f17124a = dataFreshnessParam;
        return this;
    }

    public final FetchThreadListParamsBuilder m17115a(FetchThreadListParams fetchThreadListParams) {
        this.f17124a = fetchThreadListParams.f17117a;
        this.f17125b = fetchThreadListParams.f17118b;
        this.f17126c = fetchThreadListParams.f17119c;
        this.f17127d = fetchThreadListParams.f17120d;
        this.f17128e = fetchThreadListParams.f17121e;
        this.f17129f = fetchThreadListParams.m17109f();
        return this;
    }

    public final FetchThreadListParamsBuilder m17114a(FolderName folderName) {
        this.f17125b = folderName;
        return this;
    }

    public final FetchThreadListParamsBuilder m17111a(long j) {
        this.f17128e = j;
        return this;
    }

    public final FetchThreadListParamsBuilder m17113a(RequestPriority requestPriority) {
        this.f17130g = requestPriority;
        return this;
    }

    public final FetchThreadListParams m17116h() {
        return new FetchThreadListParams(this);
    }
}
