package com.facebook.heisman.swipeable;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel.AssociatedPagesModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: platform_app */
public class ImageOverlayValidator {
    public static boolean m8021a(@Nullable ImageOverlayFieldsModel imageOverlayFieldsModel) {
        return (imageOverlayFieldsModel == null || imageOverlayFieldsModel.c() == null) ? false : true;
    }

    public static boolean m8023b(@Nullable ImageOverlayFieldsModel imageOverlayFieldsModel) {
        return (!m8021a(imageOverlayFieldsModel) || imageOverlayFieldsModel.d() == null || imageOverlayFieldsModel.d().a() == null) ? false : true;
    }

    public static String m8024c(@Nullable ImageOverlayFieldsModel imageOverlayFieldsModel) {
        String str = null;
        String str2 = "ImageOverlay: %s, (ID: %s, URI: %s)";
        Object[] objArr = new Object[3];
        objArr[0] = imageOverlayFieldsModel;
        objArr[1] = imageOverlayFieldsModel != null ? imageOverlayFieldsModel.c() : null;
        if (!(imageOverlayFieldsModel == null || imageOverlayFieldsModel.d() == null)) {
            str = imageOverlayFieldsModel.d().a();
        }
        objArr[2] = str;
        return StringLocaleUtil.a(str2, objArr);
    }

    public static boolean m8022a(@Nullable ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel) {
        if (imageOverlayWithSwipeableOverlaysModel == null || imageOverlayWithSwipeableOverlaysModel.a().isEmpty()) {
            return false;
        }
        AssociatedPagesModel associatedPagesModel = (AssociatedPagesModel) imageOverlayWithSwipeableOverlaysModel.a().get(0);
        if (associatedPagesModel.a() == null || associatedPagesModel.a().a().isEmpty()) {
            return false;
        }
        ImmutableList a = associatedPagesModel.a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!m8023b((ImageOverlayFieldsModel) a.get(i))) {
                return false;
            }
        }
        return true;
    }
}
