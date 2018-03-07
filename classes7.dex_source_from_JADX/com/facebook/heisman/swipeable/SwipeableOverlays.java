package com.facebook.heisman.swipeable;

import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLInterfaces.ImageOverlayFields;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLInterfaces.ImageOverlayWithSwipeableOverlays;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel.AssociatedPagesModel;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: places_query_text */
public class SwipeableOverlays {
    public static ImmutableList<? extends ImageOverlayFields> m8033a(ImageOverlayWithSwipeableOverlays imageOverlayWithSwipeableOverlays) {
        Preconditions.checkArgument(ImageOverlayValidator.m8022a((ImageOverlayWithSwipeableOverlaysModel) imageOverlayWithSwipeableOverlays));
        return ((AssociatedPagesModel) imageOverlayWithSwipeableOverlays.a().get(0)).a().a();
    }

    public static ImageOverlayFieldsModel m8032a(ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel, String str) {
        ImmutableList a = m8033a(imageOverlayWithSwipeableOverlaysModel);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) a.get(i);
            if (Objects.equal(imageOverlayFieldsModel.c(), str)) {
                return imageOverlayFieldsModel;
            }
        }
        throw new IllegalArgumentException("Selected overlay not in list");
    }
}
