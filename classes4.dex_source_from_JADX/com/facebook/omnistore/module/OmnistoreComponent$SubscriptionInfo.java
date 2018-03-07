package com.facebook.omnistore.module;

import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.SubscriptionParams;
import javax.annotation.Nullable;

/* compiled from: language_switcher_login_no_suggestions */
public final class OmnistoreComponent$SubscriptionInfo {
    public static final OmnistoreComponent$SubscriptionInfo IGNORED_INFO = new OmnistoreComponent$SubscriptionInfo(OmnistoreComponent$SubscriptionState.IGNORED, null, null);
    @Nullable
    public final CollectionName collectionName;
    @Nullable
    public final SubscriptionParams subscriptionParams;
    public final OmnistoreComponent$SubscriptionState subscriptionState;

    public static OmnistoreComponent$SubscriptionInfo forOpenSubscription(CollectionName collectionName) {
        return forOpenSubscription(collectionName, null);
    }

    public static OmnistoreComponent$SubscriptionInfo forOpenSubscription(CollectionName collectionName, @Nullable SubscriptionParams subscriptionParams) {
        return new OmnistoreComponent$SubscriptionInfo(OmnistoreComponent$SubscriptionState.SUBSCRIBED, collectionName, subscriptionParams);
    }

    public static OmnistoreComponent$SubscriptionInfo forDeleteExistingSubscription(CollectionName collectionName) {
        return new OmnistoreComponent$SubscriptionInfo(OmnistoreComponent$SubscriptionState.UNSUBSCRIBED, collectionName, null);
    }

    private OmnistoreComponent$SubscriptionInfo(OmnistoreComponent$SubscriptionState omnistoreComponent$SubscriptionState, @Nullable CollectionName collectionName, @Nullable SubscriptionParams subscriptionParams) {
        this.subscriptionState = omnistoreComponent$SubscriptionState;
        this.collectionName = collectionName;
        this.subscriptionParams = subscriptionParams;
    }
}
