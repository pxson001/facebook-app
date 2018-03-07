package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03002;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelperProvider;

/* compiled from: skip_publish */
public class TagsViewProvider extends AbstractAssistedProvider<TagsView> {
    public final TagsView m2674a(Context context, C03002 c03002) {
        return new TagsView(context, c03002, (TagsViewLayoutHelperProvider) getOnDemandAssistedProviderForStaticDi(TagsViewLayoutHelperProvider.class), FaceBoxInfoUtils.m2618a((InjectorLike) this));
    }
}
