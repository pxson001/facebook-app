package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.ui.tagging.ComposerAttachmentsAutoTaggingController;
import com.facebook.composer.ui.underwood.VerticalAttachmentView.AnonymousClass15;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.photos.tagging.shared.FaceBoxesView;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelperProvider;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.ui.FaceBoxConverter;

/* compiled from: commercial_break_end */
public class TaggingControllerProvider extends AbstractAssistedProvider<TaggingController> {
    public final TaggingController m21131a(FrameLayout frameLayout, FaceBoxesView faceBoxesView, AnonymousClass15 anonymousClass15, 62 62) {
        return new TaggingController(frameLayout, faceBoxesView, anonymousClass15, 62, (Context) getInstance(Context.class), FaceBoxConverter.m12936a((InjectorLike) this), PhotoOverlayObjectMapper.a(this), ComposerAttachmentsAutoTaggingController.m21041a((InjectorLike) this), (TagsViewLayoutHelperProvider) getOnDemandAssistedProviderForStaticDi(TagsViewLayoutHelperProvider.class), TagStore.a(this));
    }
}
