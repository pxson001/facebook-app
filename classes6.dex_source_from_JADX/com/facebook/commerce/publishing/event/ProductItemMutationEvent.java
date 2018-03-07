package com.facebook.commerce.publishing.event;

import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Status;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel;
import javax.annotation.Nullable;

/* compiled from: post_surfaces_blacklist */
public class ProductItemMutationEvent extends CommercePublishingMutationEvent {
    public AdminCommerceProductItemModel f7567a;
    public String f7568b;

    /* compiled from: post_surfaces_blacklist */
    public abstract class ProductItemMutationEventSubscriber extends CommercePublishingEventSubscriber<ProductItemMutationEvent> {
        public final Class<ProductItemMutationEvent> m10704a() {
            return ProductItemMutationEvent.class;
        }
    }

    private ProductItemMutationEvent(Status status, Method method, @Nullable AdminCommerceProductItemModel adminCommerceProductItemModel, @Nullable String str) {
        super(status, method);
        this.f7567a = adminCommerceProductItemModel;
        this.f7568b = str;
    }

    public static ProductItemMutationEvent m10705a(Method method, AdminCommerceProductItemModel adminCommerceProductItemModel, @Nullable String str) {
        return new ProductItemMutationEvent(Status.SUCCESS, method, adminCommerceProductItemModel, str);
    }

    public static ProductItemMutationEvent m10706a(Method method, @Nullable String str) {
        return new ProductItemMutationEvent(Status.FAILED, method, null, str);
    }
}
