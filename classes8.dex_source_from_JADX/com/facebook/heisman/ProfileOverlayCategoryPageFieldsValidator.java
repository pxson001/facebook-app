package com.facebook.heisman;

import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.PageProfilePictureOverlaysConnectionFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.swipeable.ImageOverlayValidator;

/* compiled from: video-id */
public class ProfileOverlayCategoryPageFieldsValidator {
    public static boolean m645a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel) {
        PageProfilePictureOverlaysConnectionFieldsModel d = profileOverlayCategoryPageFieldsModel.d();
        return (d == null || d.a().isEmpty() || !ImageOverlayValidator.b((ImageOverlayFieldsModel) d.a().get(0))) ? false : true;
    }
}
