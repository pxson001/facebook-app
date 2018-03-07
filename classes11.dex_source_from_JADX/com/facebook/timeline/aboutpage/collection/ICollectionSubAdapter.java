package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.collection.CollectionsCollectionAdapter.ViewType;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;

/* compiled from: Missing search area info in intent */
public interface ICollectionSubAdapter {
    int mo371a();

    View mo372a(Context context, ViewType viewType, ViewGroup viewGroup);

    DefaultPageInfoFields mo373a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType);

    Object mo374a(int i);

    void mo375a(Object obj, View view, ProfileViewerContext profileViewerContext);

    int mo376b();

    ViewType mo377b(int i);

    void mo378c();

    int mo379d();

    GraphQLTimelineAppCollectionStyle mo380e();
}
