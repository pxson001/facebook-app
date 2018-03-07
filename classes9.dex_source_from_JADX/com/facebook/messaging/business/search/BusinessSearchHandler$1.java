package com.facebook.messaging.business.search;

import com.facebook.graphql.enums.GraphQLCommercePageType;

/* compiled from: mm_bymm_impressions */
public /* synthetic */ class BusinessSearchHandler$1 {
    public static final /* synthetic */ int[] f9430a = new int[GraphQLCommercePageType.values().length];

    static {
        try {
            f9430a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_AGENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9430a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_BANK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9430a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_BUSINESS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9430a[GraphQLCommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
