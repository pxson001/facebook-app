package com.facebook.photos.editgallery;

import android.content.Context;
import android.net.Uri;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.editgallery.EditGalleryFragmentController.C08695;
import com.facebook.photos.editgallery.utils.CropImageUtilsProvider;

/* compiled from: last_seq_id */
public class ZoomCropEditControllerProvider extends AbstractAssistedProvider<ZoomCropEditController> {
    public final ZoomCropEditController m12361a(Uri uri, RotatingFrameLayout rotatingFrameLayout, C08695 c08695, String str) {
        return new ZoomCropEditController(uri, rotatingFrameLayout, c08695, str, BitmapUtils.a(this), IdBasedLazy.a(this, 9300), PhotoOverlayController.m11526b(this), (CropImageUtilsProvider) getOnDemandAssistedProviderForStaticDi(CropImageUtilsProvider.class), (Context) getInstance(Context.class));
    }
}
