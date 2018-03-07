package com.facebook.photos.mediagallery.util;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.google.common.base.Optional;

/* compiled from: is_failed */
public class ZoomableImageWrapperProvider extends AbstractAssistedProvider<ZoomableImageWrapper> {
    public final ZoomableImageWrapper m12841a(ZoomableImageView zoomableImageView, Optional<WarmupImageHelper> optional) {
        return new ZoomableImageWrapper(zoomableImageView, optional, ResourcesMethodAutoProvider.a(this), DefaultAndroidThreadUtil.b(this), (GalleryDrawableFetcherProvider) getOnDemandAssistedProviderForStaticDi(GalleryDrawableFetcherProvider.class), PhotosDialogPerfUtil.m12025a((InjectorLike) this), (DialtoneController) DialtoneControllerImpl.a(this));
    }
}
