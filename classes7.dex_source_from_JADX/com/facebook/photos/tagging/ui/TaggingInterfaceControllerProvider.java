package com.facebook.photos.tagging.ui;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.TaggingInterfaceControllerHostImpl;
import com.facebook.photos.tagging.shared.TagTypeahead;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.ContactsDbTaggingDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;

/* compiled from: internet.org */
public class TaggingInterfaceControllerProvider extends AbstractAssistedProvider<TaggingInterfaceController> {
    public final TaggingInterfaceController m13003a(Context context, TaggingInterfaceControllerHostImpl taggingInterfaceControllerHostImpl, TagTypeahead tagTypeahead, int i, String str) {
        return new TaggingInterfaceController(context, taggingInterfaceControllerHostImpl, tagTypeahead, i, str, (TagTypeaheadDataSource) ContactsDbTaggingDataSource.a(this), (GroupMembersTaggingTypeaheadDataSourceProvider) getOnDemandAssistedProviderForStaticDi(GroupMembersTaggingTypeaheadDataSourceProvider.class), TypeaheadAnimationHelper.b(this), TagStore.a(this), FaceBoxStore.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
