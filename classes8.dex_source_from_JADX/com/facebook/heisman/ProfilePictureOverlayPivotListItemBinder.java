package com.facebook.heisman;

import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;

/* compiled from: user_dismiss */
public class ProfilePictureOverlayPivotListItemBinder {
    public static void m804a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel, ContentView contentView) {
        contentView.setTitleText(profileOverlayCategoryPageFieldsModel.b());
        if (profileOverlayCategoryPageFieldsModel.c() != null) {
            contentView.setThumbnailUri(profileOverlayCategoryPageFieldsModel.c().a());
        }
    }
}
