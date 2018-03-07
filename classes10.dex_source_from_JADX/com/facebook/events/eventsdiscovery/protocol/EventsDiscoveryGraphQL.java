package com.facebook.events.eventsdiscovery.protocol;

import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventDiscoveryCategoryListModel;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS */
public final class EventsDiscoveryGraphQL {

    /* compiled from: com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS */
    public class FetchEventDiscoveryCategoryListString extends TypedGraphQlQueryString<FetchEventDiscoveryCategoryListModel> {
        public FetchEventDiscoveryCategoryListString() {
            super(FetchEventDiscoveryCategoryListModel.class, false, "FetchEventDiscoveryCategoryList", "6ca229a58431ab80f823cc72f1068081", "viewer", "10154643869826729", RegularImmutableSet.a);
        }
    }

    /* compiled from: com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS */
    public class FetchEventsDiscoveryFiltersString extends TypedGraphQlQueryString<FetchEventsDiscoveryFiltersModel> {
        public FetchEventsDiscoveryFiltersString() {
            super(FetchEventsDiscoveryFiltersModel.class, false, "FetchEventsDiscoveryFilters", "6ee099c73fd55794a978d86b376f8d22", "viewer", "10154187184171729", RegularImmutableSet.a);
        }
    }
}
