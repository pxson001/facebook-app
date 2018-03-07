package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.google.common.collect.ImmutableList;

/* compiled from: Sandbox */
public class InstantShoppingBlockDataHelper {
    public static boolean m24958b(ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.SHOW_INTERACTION_HINT);
    }

    public static boolean m24959c(ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.EXPANDABLE);
    }

    public static boolean m24957a(ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.PHOTO_GRAY_OVERLAY);
    }

    public static boolean m24960e(ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.FIT_TO_HEIGHT);
    }

    public static boolean m24961f(ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.contains(GraphQLInstantShoppingPresentationStyle.ADJUSTED_FIT_TO_HEIGHT);
    }
}
