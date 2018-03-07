package com.facebook.photos.editgallery;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.MovableItemContainerProvider;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.editgallery.EditGalleryFragmentController.FileEditingListener;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;

/* compiled from: like_recent_post */
public class CropEditControllerProvider extends AbstractAssistedProvider<CropEditController> {
    public final CropEditController m12086a(Uri uri, RotatingFrameLayout rotatingFrameLayout, EditableOverlayContainerView editableOverlayContainerView, FbDraweeView fbDraweeView, View view, FileEditingListener fileEditingListener, String str, RotatingPhotoViewController rotatingPhotoViewController, Optional<CreativeEditingLogger> optional, CreativeEditingPhotoOverlayView creativeEditingPhotoOverlayView) {
        return new CropEditController(uri, rotatingFrameLayout, editableOverlayContainerView, fbDraweeView, view, fileEditingListener, str, rotatingPhotoViewController, optional, creativeEditingPhotoOverlayView, Toaster.a(this), (MovableItemContainerProvider) getOnDemandAssistedProviderForStaticDi(MovableItemContainerProvider.class), IdBasedProvider.a(this, 9303), SwipeableParamsHelper.m11708a((InjectorLike) this), PhotoOverlayController.m11525a((InjectorLike) this), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), CreativeEditingFileManager.a(this), IdBasedLazy.a(this, 9300), IdBasedLazy.a(this, 3561), ImagePipelineMethodAutoProvider.a(this), (Context) getInstance(Context.class));
    }
}
