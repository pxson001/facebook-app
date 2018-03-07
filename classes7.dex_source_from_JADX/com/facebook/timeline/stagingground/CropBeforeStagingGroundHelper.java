package com.facebook.timeline.stagingground;

import android.app.Activity;
import android.net.Uri;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: fav_photos_add_prompt_suggested_impression */
public class CropBeforeStagingGroundHelper {
    @Inject
    public volatile Provider<AllCapsTransformationMethod> f14703a = UltralightRuntime.a;
    @Inject
    public volatile Provider<SecureContextHelper> f14704b = UltralightRuntime.a;

    public final void m18640a(Activity activity, Uri uri, String str, String str2, String str3, @Nullable ImageOverlayFieldsModel imageOverlayFieldsModel) {
        StickerParams a;
        SecureContextHelper secureContextHelper = (SecureContextHelper) this.f14704b.get();
        AllCapsTransformationMethod allCapsTransformationMethod = (AllCapsTransformationMethod) this.f14703a.get();
        Builder a2 = new Builder().b(EditFeature.DOODLE).b(EditFeature.FILTER).b(EditFeature.STICKER).b(EditFeature.TEXT).a(CropMode.ZOOM_CROP).a(uri, str);
        a2.k = null;
        a2 = a2;
        a2.f = false;
        Builder b = a2.b(str3);
        EditGalleryZoomCropParams.Builder builder = new EditGalleryZoomCropParams.Builder();
        builder.e = EditGalleryZoomCropParams.a;
        EditGalleryZoomCropParams.Builder builder2 = builder;
        if (imageOverlayFieldsModel != null) {
            a = FrameConversions.m8019a(imageOverlayFieldsModel);
        } else {
            a = null;
        }
        builder2.b = a;
        b.m = builder2.a();
        a2 = b;
        a2.i = allCapsTransformationMethod.getTransformation(activity.getString(2131237850), null).toString();
        secureContextHelper.a(EditGalleryIntentCreator.a(activity, str2, a2.a()), 4, activity);
    }
}
