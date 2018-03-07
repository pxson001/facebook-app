package com.facebook.photos.creativeediting.model;

import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.TextAssetsModel.NodesModel.LandscapePositionModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.TextAssetsModel.NodesModel.PortraitPositionModel;

/* compiled from: suppress_intro */
public class TextAssetPosition {
    private final SizeDimension f3521a;
    public final float f3522b;
    public final HorizontalAlignment f3523c = HorizontalAlignment.CENTER;
    public final VerticalAlignment f3524d;
    private final float f3525e;
    public final float f3526f;

    /* compiled from: suppress_intro */
    public enum HorizontalAlignment {
        LEFT,
        RIGHT,
        CENTER;

        public static HorizontalAlignment fromString(String str) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.name().equalsIgnoreCase(str)) {
                    return horizontalAlignment;
                }
            }
            throw new IllegalArgumentException("Name " + str + " not found in HorizontalAlignment enum");
        }
    }

    /* compiled from: suppress_intro */
    public enum SizeDimension {
        WIDTH,
        HEIGHT;

        public static SizeDimension fromString(String str) {
            for (SizeDimension sizeDimension : values()) {
                if (sizeDimension.name().equalsIgnoreCase(str)) {
                    return sizeDimension;
                }
            }
            throw new IllegalArgumentException("Name " + str + " not found in SizeDimension enum");
        }
    }

    /* compiled from: suppress_intro */
    public enum VerticalAlignment {
        TOP,
        BOTTOM,
        CENTER;

        public static VerticalAlignment fromString(String str) {
            for (VerticalAlignment verticalAlignment : values()) {
                if (verticalAlignment.name().equalsIgnoreCase(str)) {
                    return verticalAlignment;
                }
            }
            throw new IllegalArgumentException("Name " + str + " not found in VerticalAlignment enum");
        }
    }

    public TextAssetPosition(PortraitPositionModel portraitPositionModel) {
        this.f3521a = SizeDimension.fromString(portraitPositionModel.m4603d());
        this.f3522b = (float) portraitPositionModel.m4597a();
        this.f3524d = VerticalAlignment.fromString(portraitPositionModel.bI_());
        this.f3525e = (float) portraitPositionModel.m4602c();
        this.f3526f = (float) portraitPositionModel.m4604g();
    }

    public TextAssetPosition(LandscapePositionModel landscapePositionModel) {
        this.f3521a = SizeDimension.fromString(landscapePositionModel.m4592d());
        this.f3522b = (float) landscapePositionModel.m4586a();
        this.f3524d = VerticalAlignment.fromString(landscapePositionModel.bH_());
        this.f3525e = (float) landscapePositionModel.m4591c();
        this.f3526f = (float) landscapePositionModel.m4593g();
    }
}
