package com.facebook.commerce.publishing.event;

/* compiled from: post_without_prompt */
public class CommercePublishingMutationEvent extends CommercePublishingEvent {
    public final Status f7564a;
    public final Method f7565b;

    /* compiled from: post_without_prompt */
    public enum Method {
        CREATE,
        EDIT,
        DELETE
    }

    /* compiled from: post_without_prompt */
    public enum Status {
        SUCCESS,
        FAILED
    }

    public CommercePublishingMutationEvent(Status status, Method method) {
        this.f7564a = status;
        this.f7565b = method;
    }
}
