package com.facebook.photos.creativeediting.model;

import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.LandscapePositionModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.PortraitPositionModel;

/* compiled from: survey_header */
public class StickerAssetPosition {
    public final SizeDimension f3496a;
    private final float f3497b;
    private final HorizontalAlignment f3498c;
    private final VerticalAlignment f3499d;
    private final float f3500e;
    private final float f3501f;

    /* compiled from: survey_header */
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

    /* compiled from: survey_header */
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

    /* compiled from: survey_header */
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

    public StickerAssetPosition(PortraitPositionModel portraitPositionModel) {
        this.f3496a = SizeDimension.fromString(portraitPositionModel.m4542d());
        this.f3497b = (float) portraitPositionModel.m4536a();
        this.f3498c = HorizontalAlignment.fromString(portraitPositionModel.m4540b());
        this.f3499d = VerticalAlignment.fromString(portraitPositionModel.bG_());
        this.f3500e = (float) portraitPositionModel.m4541c();
        this.f3501f = (float) portraitPositionModel.m4543g();
    }

    public StickerAssetPosition(LandscapePositionModel landscapePositionModel) {
        this.f3496a = SizeDimension.fromString(landscapePositionModel.m4530d());
        this.f3497b = (float) landscapePositionModel.m4524a();
        this.f3498c = HorizontalAlignment.fromString(landscapePositionModel.m4528b());
        this.f3499d = VerticalAlignment.fromString(landscapePositionModel.bF_());
        this.f3500e = (float) landscapePositionModel.m4529c();
        this.f3501f = (float) landscapePositionModel.m4531g();
    }

    public final float m4669b() {
        return this.f3497b;
    }

    public final HorizontalAlignment m4670c() {
        return this.f3498c;
    }

    public final VerticalAlignment m4671d() {
        return this.f3499d;
    }

    public final float m4672e() {
        return this.f3500e;
    }

    public final float m4673f() {
        return this.f3501f;
    }
}
