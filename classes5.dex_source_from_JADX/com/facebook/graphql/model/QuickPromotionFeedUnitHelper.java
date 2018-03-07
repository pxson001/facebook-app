package com.facebook.graphql.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TV_MOVIES */
public class QuickPromotionFeedUnitHelper {
    private QuickPromotionFeedUnitHelper() {
    }

    @Nullable
    public static GraphQLQuickPromotionFeedUnitItem m22569a(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        ImmutableList l = graphQLQuickPromotionFeedUnit.l();
        if (l == null || l.isEmpty()) {
            return null;
        }
        return (GraphQLQuickPromotionFeedUnitItem) l.get(0);
    }

    @Nullable
    public static GraphQLQuickPromotion m22570b(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        GraphQLQuickPromotionFeedUnitItem a = m22569a(graphQLQuickPromotionFeedUnit);
        return a != null ? a.m21243l() : null;
    }

    @Nullable
    public static GraphQLQuickPromotionCreative m22571c(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        GraphQLQuickPromotion b = m22570b(graphQLQuickPromotionFeedUnit);
        if (b == null) {
            return null;
        }
        ImmutableList j = b.m21198j();
        if (j == null || j.isEmpty()) {
            return null;
        }
        return (GraphQLQuickPromotionCreative) j.get(0);
    }

    @Nullable
    public static String m22572d(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        GraphQLQuickPromotion b = m22570b(graphQLQuickPromotionFeedUnit);
        if (b == null) {
            return null;
        }
        GraphQLTextWithEntities m = b.m21201m();
        if (m != null) {
            return m.a();
        }
        return null;
    }
}
