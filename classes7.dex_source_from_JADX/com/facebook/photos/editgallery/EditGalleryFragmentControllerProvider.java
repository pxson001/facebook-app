package com.facebook.photos.editgallery;

import android.net.Uri;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.animations.AnimationParam;

/* compiled from: left_handle_zoom_ins */
public class EditGalleryFragmentControllerProvider extends AbstractAssistedProvider<EditGalleryFragmentController> {
    public final EditGalleryFragmentController m12200a(EditGalleryDialogFragment editGalleryDialogFragment, EditGalleryCallback editGalleryCallback, Uri uri, Integer num, Integer num2, State state, AnimationParam animationParam) {
        return new EditGalleryFragmentController(editGalleryDialogFragment, editGalleryCallback, uri, num, num2, state, animationParam, IdBasedProvider.a(this, 9288), (CreativeEditingSwipeableControllerProvider) getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class), ScreenUtil.a(this), IdBasedLazy.a(this, 9300), IdBasedLazy.a(this, 3561), CreativeEditingImageHelper.a(this), (DoodlesEditControllerProvider) getOnDemandAssistedProviderForStaticDi(DoodlesEditControllerProvider.class), (TextEditControllerProvider) getOnDemandAssistedProviderForStaticDi(TextEditControllerProvider.class), (StickerEditControllerProvider) getOnDemandAssistedProviderForStaticDi(StickerEditControllerProvider.class), (CropEditControllerProvider) getOnDemandAssistedProviderForStaticDi(CropEditControllerProvider.class), (FilterEditControllerProvider) getOnDemandAssistedProviderForStaticDi(FilterEditControllerProvider.class), (ZoomCropEditControllerProvider) getOnDemandAssistedProviderForStaticDi(ZoomCropEditControllerProvider.class), CreativeEditingLogger.m11466a((InjectorLike) this), FbDraweeControllerBuilder.a(this), (PostprocessorFactoryProvider) getOnDemandAssistedProviderForStaticDi(PostprocessorFactoryProvider.class));
    }
}
