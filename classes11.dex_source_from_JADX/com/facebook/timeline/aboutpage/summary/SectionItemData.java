package com.facebook.timeline.aboutpage.summary;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionWithItemsOrRequestables;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: Location not received */
public class SectionItemData {
    public final CollectionsAppSectionWithItemsOrRequestablesModel f13649a;
    public final ItemData f13650b;
    public final GraphQLTimelineAppCollectionStyle f13651c;
    public final ImmutableList<?> f13652d;

    public SectionItemData(CollectionsAppSectionWithItemsOrRequestables collectionsAppSectionWithItemsOrRequestables, ItemData itemData, GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, ImmutableList<?> immutableList) {
        this.f13649a = (CollectionsAppSectionWithItemsOrRequestablesModel) Preconditions.checkNotNull(collectionsAppSectionWithItemsOrRequestables);
        this.f13650b = (ItemData) Preconditions.checkNotNull(itemData);
        this.f13651c = (GraphQLTimelineAppCollectionStyle) Preconditions.checkNotNull(graphQLTimelineAppCollectionStyle);
        this.f13652d = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }
}
