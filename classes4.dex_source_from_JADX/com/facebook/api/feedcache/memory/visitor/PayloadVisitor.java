package com.facebook.api.feedcache.memory.visitor;

import com.facebook.controller.mutation.util.RecursiveFeedbackTransform;

/* compiled from: rtt_high */
public abstract class PayloadVisitor<T> extends RecursiveFeedbackTransform {
    public volatile T f3025a;

    public PayloadVisitor(String str, T t) {
        super(str);
        this.f3025a = t;
    }
}
