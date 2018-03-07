package com.facebook.timeline.aboutpage;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.timeline.aboutpage.collection.CollectionsCollectionFragment;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;

/* compiled from: NOT_SET */
public class CollectionsCollectionFragmentFactory implements IFragmentFactory {
    public final Fragment m13743a(Intent intent) {
        DefaultImageFields defaultImageFields = (DefaultImageFields) FlatBufferModelHelper.a(intent, "collections_icon");
        return CollectionsCollectionFragment.m13867a(intent.getStringExtra("com.facebook.katana.profile.id"), intent.getStringExtra("section_id"), intent.getStringExtra("collection_id"), intent.getStringExtra("friendship_status"), intent.getStringExtra("subscribe_status"), (GraphQLTimelineAppSectionType) intent.getSerializableExtra("collections_section_type"), intent.getStringExtra("view_name"), defaultImageFields, (CollectionWithItemsAndSuggestions) FlatBufferModelHelper.a(intent, "collection"));
    }
}
