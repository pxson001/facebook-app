package com.facebook.timeline.aboutpage;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.sections.CollectionsSectionFragment;

/* compiled from: NONE_SELECTED */
public class CollectionsSectionFragmentFactory implements IFragmentFactory {
    public final Fragment m13780a(Intent intent) {
        return CollectionsSectionFragment.m14762a(intent.getStringExtra("com.facebook.katana.profile.id"), intent.getStringExtra("section_id"), intent.getStringExtra("section_tracking"), intent.getStringExtra("view_name"), (DefaultImageFields) FlatBufferModelHelper.a(intent, "collections_icon"), (CollectionWithItemsAndSuggestions) FlatBufferModelHelper.a(intent, "collection"), intent.getStringExtra("friendship_status"), intent.getStringExtra("subscribe_status"));
    }
}
