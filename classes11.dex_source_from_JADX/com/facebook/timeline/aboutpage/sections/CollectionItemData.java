package com.facebook.timeline.aboutpage.sections;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.google.common.collect.ImmutableList;

/* compiled from: MOBILE_RADIO */
public class CollectionItemData {
    public final CollectionWithItemsAndSuggestions f13512a;
    public final ItemData f13513b;
    public final GraphQLTimelineAppCollectionStyle f13514c;
    public final ImmutableList<?> f13515d;

    public CollectionItemData(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, ItemData itemData, GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, ImmutableList<?> immutableList) {
        this.f13512a = collectionWithItemsAndSuggestions;
        this.f13513b = itemData;
        this.f13514c = graphQLTimelineAppCollectionStyle;
        this.f13515d = immutableList;
    }
}
