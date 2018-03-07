package com.facebook.photos.mediagallery.ui.tagging;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import com.facebook.widget.images.zoomableimageview.ZoomableView;

/* compiled from: slideshow_picker_nux_seen */
public class LegacyTypeaheadControllerProvider extends AbstractAssistedProvider<LegacyTypeaheadController> {
    public final LegacyTypeaheadController m2630a(ZoomableView zoomableView, int i, String str, String str2) {
        return new LegacyTypeaheadController(zoomableView, i, str, str2, TypeaheadAnimationHelper.b(this), FaceBoxInfoUtils.m2618a((InjectorLike) this), TaggingProfileFactory.m2661a(this), IdBasedLazy.a(this, 11099), DefaultSuggestionController.m2568a((InjectorLike) this), (GroupMembersTaggingTypeaheadDataSourceProvider) getOnDemandAssistedProviderForStaticDi(GroupMembersTaggingTypeaheadDataSourceProvider.class), IdBasedLazy.a(this, 11100), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
