package com.facebook.timeline.aboutpage.views;

import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;

/* compiled from: Ljava/util/concurrent/Executor; */
public interface ICollectionItemView {
    void mo424a(AppCollectionItemModel appCollectionItemModel);

    void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType);
}
