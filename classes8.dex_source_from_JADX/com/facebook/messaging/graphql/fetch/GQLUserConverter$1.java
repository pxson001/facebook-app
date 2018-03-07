package com.facebook.messaging.graphql.fetch;

import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLCommercePageType;

/* compiled from: tosTransitionType */
/* synthetic */ class GQLUserConverter$1 {
    static final /* synthetic */ int[] f1533a = new int[GraphQLCommercePageType.values().length];
    static final /* synthetic */ int[] f1534b = new int[GraphQLCommercePageSetting.values().length];

    static {
        try {
            f1534b[GraphQLCommercePageSetting.COMMERCE_FAQ_ENABLED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1534b[GraphQLCommercePageSetting.IN_MESSENGER_SHOPPING_ENABLED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1534b[GraphQLCommercePageSetting.COMMERCE_NUX_ENABLED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1533a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_AGENT.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1533a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_BANK.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1533a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_BUSINESS.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1533a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f1533a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_NONE.ordinal()] = 5;
        } catch (NoSuchFieldError e8) {
        }
    }
}
