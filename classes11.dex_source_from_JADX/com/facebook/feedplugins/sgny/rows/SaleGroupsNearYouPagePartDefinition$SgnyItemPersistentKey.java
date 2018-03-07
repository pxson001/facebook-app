package com.facebook.feedplugins.sgny.rows;

import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;

/* compiled from: buildTime */
public class SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentKey implements ContextStateKey<String, SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState> {
    public static final String f9406a = SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentKey.class.getName();
    private final String f9407b;

    public SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentKey(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
        String str;
        if (graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j() == null || StringUtil.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j().I())) {
            str = f9406a + graphQLSaleGroupsNearYouFeedUnitGroupsEdge.hashCode();
        } else {
            str = f9406a + graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j().I();
        }
        this.f9407b = str;
    }

    public final Object m9983b() {
        return this.f9407b;
    }

    public final Object m9982a() {
        return new SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState();
    }
}
