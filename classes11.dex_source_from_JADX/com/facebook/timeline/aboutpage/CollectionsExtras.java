package com.facebook.timeline.aboutpage;

import android.os.Bundle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;

/* compiled from: NOTIFY * HTTP/1.1 */
public class CollectionsExtras {
    public static void m13750a(Bundle bundle, String str, CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, DefaultImageFields defaultImageFields, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, String str2) {
        bundle.putString("view_name", str);
        FlatBufferModelHelper.a(bundle, "collection", CollectionWithItemsAndSuggestionsModel.m14673a(collectionWithItemsAndSuggestions));
        bundle.putSerializable("collections_section_type", graphQLTimelineAppSectionType);
        FlatBufferModelHelper.a(bundle, "collections_icon", DefaultImageFieldsModel.a(defaultImageFields));
        m13749a(bundle, graphQLFriendshipStatus, graphQLSubscribeStatus);
        if (str2 != null) {
            bundle.putString("section_tracking", str2);
        }
    }

    public static void m13749a(Bundle bundle, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        bundle.putString("friendship_status", graphQLFriendshipStatus.toString());
        bundle.putString("subscribe_status", graphQLSubscribeStatus.toString());
    }
}
