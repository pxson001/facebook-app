package com.facebook.messaging.service.model;

import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.messaging.model.threads.ThreadCriteria;

/* compiled from: conversations_feedback_id */
public class FetchThreadParamsBuilder {
    public ThreadCriteria f17163a;
    public DataFreshnessParam f17164b;
    public DataFreshnessParam f17165c;
    public long f17166d = -1;
    public boolean f17167e;
    public int f17168f = 50;
    public long f17169g = -1;
    public boolean f17170h;

    public final FetchThreadParamsBuilder m17137a(ThreadCriteria threadCriteria) {
        this.f17163a = threadCriteria;
        return this;
    }

    public final FetchThreadParamsBuilder m17136a(DataFreshnessParam dataFreshnessParam) {
        this.f17164b = dataFreshnessParam;
        return this;
    }

    public final FetchThreadParamsBuilder m17138a(FetchThreadParams fetchThreadParams) {
        this.f17163a = fetchThreadParams.f17155a;
        this.f17164b = fetchThreadParams.f17156b;
        this.f17165c = fetchThreadParams.f17157c;
        this.f17167e = fetchThreadParams.f17158d;
        this.f17166d = fetchThreadParams.f17159e;
        this.f17168f = fetchThreadParams.f17160f;
        this.f17169g = fetchThreadParams.f17161g;
        this.f17170h = fetchThreadParams.f17162h;
        return this;
    }

    public final FetchThreadParamsBuilder m17135a(int i) {
        this.f17168f = i;
        return this;
    }

    public final FetchThreadParamsBuilder m17139b(long j) {
        this.f17169g = j;
        return this;
    }

    public final FetchThreadParams m17140i() {
        return new FetchThreadParams(this);
    }
}
