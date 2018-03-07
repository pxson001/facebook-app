package com.facebook.heisman.swipeable;

import android.net.Uri;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLInterfaces.ImageOverlayFields;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLInterfaces.ImageOverlayWithSwipeableOverlays;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel.AssociatedPagesModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.LandscapePositionModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.PortraitPositionModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.StickerModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.StickerModel.PreviewImageModel;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.StickerParams.Builder;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: platform_postback */
public class FrameConversions {
    public static StickerParams m8019a(ImageOverlayFieldsModel imageOverlayFieldsModel) {
        Preconditions.checkArgument(ImageOverlayValidator.m8023b(imageOverlayFieldsModel));
        Builder builder = new Builder(Uri.parse(imageOverlayFieldsModel.d().a()), imageOverlayFieldsModel.c());
        builder.h = 1.0f;
        builder = builder;
        builder.g = 1.0f;
        builder = builder;
        builder.e = 0.0f;
        builder = builder;
        builder.f = 0.0f;
        builder = builder;
        builder.d = 0.0f;
        builder = builder;
        builder.k = true;
        return builder.a();
    }

    public static ImmutableList<Frame> m8020a(ImageOverlayWithSwipeableOverlays imageOverlayWithSwipeableOverlays, ImageOverlayFields imageOverlayFields) {
        int i = 0;
        if (imageOverlayWithSwipeableOverlays.a().isEmpty() || ((AssociatedPagesModel) imageOverlayWithSwipeableOverlays.a().get(0)).a() == null || ((AssociatedPagesModel) imageOverlayWithSwipeableOverlays.a().get(0)).a().a().isEmpty()) {
            throw new IllegalArgumentException("Malformed swipeable overlays");
        }
        ImmutableList a = SwipeableOverlays.m8033a(imageOverlayWithSwipeableOverlays);
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = a.size();
        while (i < size) {
            ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) a.get(i);
            if (!Objects.equal(imageOverlayFieldsModel.c(), imageOverlayFields.c()) && ImageOverlayValidator.m8023b(imageOverlayFieldsModel)) {
                builder.c(m8018a(imageOverlayFieldsModel.c(), imageOverlayFieldsModel.d().a()));
            }
            i++;
        }
        return builder.b();
    }

    public static FrameModel m8018a(String str, String str2) {
        PreviewImageModel.Builder builder = new PreviewImageModel.Builder();
        builder.b = str2;
        builder = builder;
        builder.c = 960;
        builder = builder;
        builder.a = 960;
        PreviewImageModel a = builder.a();
        StickerModel.Builder builder2 = new StickerModel.Builder();
        builder2.a = str;
        builder2 = builder2;
        builder2.b = a;
        StickerModel a2 = builder2.a();
        NodesModel.Builder builder3 = new NodesModel.Builder();
        builder3.d = a2;
        NodesModel.Builder builder4 = builder3;
        LandscapePositionModel.Builder builder5 = new LandscapePositionModel.Builder();
        builder5.d = "WIDTH";
        builder5 = builder5;
        builder5.b = "LEFT";
        builder5 = builder5;
        builder5.e = "TOP";
        builder5 = builder5;
        builder5.a = 100.0d;
        builder4.a = builder5.a();
        builder4 = builder4;
        PortraitPositionModel.Builder builder6 = new PortraitPositionModel.Builder();
        builder6.d = "WIDTH";
        builder6 = builder6;
        builder6.b = "LEFT";
        builder6 = builder6;
        builder6.e = "TOP";
        builder6 = builder6;
        builder6.a = 100.0d;
        builder4.b = builder6.a();
        NodesModel a3 = builder4.a();
        StickerAssetsModel.Builder builder7 = new StickerAssetsModel.Builder();
        builder7.a = ImmutableList.of(a3);
        StickerAssetsModel a4 = builder7.a();
        FrameModel.Builder builder8 = new FrameModel.Builder();
        builder8.b = str;
        builder8 = builder8;
        builder8.d = a4;
        return builder8.a();
    }
}
