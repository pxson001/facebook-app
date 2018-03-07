package com.facebook.appdiscovery.lite.model.unit;

import com.facebook.appdiscovery.lite.model.contract.AppDiscoverySeeMoreQueryable;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.graphql.enums.GraphQLMoreAppsUnitRenderStyle;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: is_expiration_date_valid */
public class LiteRelatedAppsFeedUnit extends AppDiscoveryBaseFeedUnit implements AppDiscoverySeeMoreQueryable {
    public final ImmutableList<AppStoryQueryFragment> f10587a;
    private final GraphQLMoreAppsUnitRenderStyle f10588b;
    private final String f10589c;
    private final String f10590d;

    public LiteRelatedAppsFeedUnit(String str, String str2, GraphQLMoreAppsUnitRenderStyle graphQLMoreAppsUnitRenderStyle, ImmutableList<AppStoryQueryFragment> immutableList) {
        this.f10590d = str;
        this.f10589c = str2;
        this.f10588b = graphQLMoreAppsUnitRenderStyle;
        this.f10587a = immutableList;
    }

    public final String mo746a() {
        return this.f10589c;
    }
}
