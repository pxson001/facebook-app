package com.facebook.http.entity.mime;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* compiled from: relevant_comment_id */
public class UnwrappableHttpEntityWrapper extends HttpEntityWrapper {
    public UnwrappableHttpEntityWrapper(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public final HttpEntity m12193a() {
        return this.wrappedEntity;
    }
}
