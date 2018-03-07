package com.facebook.commerce.publishing.event;

import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Status;

/* compiled from: post_with_minutiae */
public class CommerceShopMutationEvent extends CommercePublishingMutationEvent {

    /* compiled from: post_with_minutiae */
    public abstract class CommerceShopMutationEventSubscriber extends CommercePublishingEventSubscriber<CommerceShopMutationEvent> {
        public final Class<CommerceShopMutationEvent> m10702a() {
            return CommerceShopMutationEvent.class;
        }
    }

    private CommerceShopMutationEvent(Status status, Method method) {
        super(status, method);
    }

    public static CommerceShopMutationEvent m10703a(Method method) {
        return new CommerceShopMutationEvent(Status.SUCCESS, method);
    }
}
