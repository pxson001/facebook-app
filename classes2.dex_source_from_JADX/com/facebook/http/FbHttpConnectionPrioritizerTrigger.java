package com.facebook.http;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.ConnectionPrioritizerTrigger;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;

/* compiled from: related_share_article_hide */
public class FbHttpConnectionPrioritizerTrigger implements ConnectionPrioritizerTrigger {
    private final FbHttpRequestProcessor f7720a;
    private final FbHttpRequest f7721b;

    public FbHttpConnectionPrioritizerTrigger(FbHttpRequestProcessor fbHttpRequestProcessor, FbHttpRequest fbHttpRequest) {
        this.f7720a = (FbHttpRequestProcessor) Preconditions.checkNotNull(fbHttpRequestProcessor);
        this.f7721b = (FbHttpRequest) Preconditions.checkNotNull(fbHttpRequest);
    }

    public final void mo1675a(RequestPriority requestPriority) {
        this.f7720a.m12268a(this.f7721b, requestPriority);
    }
}
