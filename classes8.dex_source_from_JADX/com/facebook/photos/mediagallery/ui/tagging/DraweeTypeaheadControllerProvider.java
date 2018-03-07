package com.facebook.photos.mediagallery.ui.tagging;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediagallery.ui.widget.GalleryDraweeView;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;

/* compiled from: slideshow_preview_stop */
public class DraweeTypeaheadControllerProvider extends AbstractAssistedProvider<DraweeTypeaheadController> {
    public final DraweeTypeaheadController m2615a(GalleryDraweeView galleryDraweeView, int i, String str, String str2) {
        return new DraweeTypeaheadController(galleryDraweeView, i, str, str2, TypeaheadAnimationHelper.b(this), FaceBoxInfoUtils.m2618a((InjectorLike) this), TaggingProfileFactory.m2661a(this), IdBasedLazy.a(this, 11099), DefaultSuggestionController.m2568a((InjectorLike) this), (GroupMembersTaggingTypeaheadDataSourceProvider) getOnDemandAssistedProviderForStaticDi(GroupMembersTaggingTypeaheadDataSourceProvider.class), IdBasedLazy.a(this, 11100), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
